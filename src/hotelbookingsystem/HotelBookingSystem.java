/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbookingsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Glenn Lim Phang Zhen
 */
public class HotelBookingSystem {
    
    public HotelBookingSystem() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
    }
    /**
     * @param args the command line arguments
     */
 
    
}

class loginProcess {
    //class login process to hold method for login
    public boolean login(String username, String password) {
        boolean found = false;
        File file = new File("Users.txt");
        String tempUsername, tempPassword;
        
        
        try {
            try ( //file data saved as : username, password
                Scanner inputFile = new Scanner(file)) {
                inputFile.useDelimiter("[,\n]"); //scanning file with a deliminiter to split it
                while (inputFile.hasNext() && !found) {
                    tempUsername = inputFile.next();
                    tempPassword = inputFile.next();    
                    found = tempUsername.trim().equals(username) && tempPassword.trim().equals(password);
                }
            } //scanning file with a deliminiter to split it
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file due to " + e);
        }
        return found;
    } 
}



class Receipt {
    public final double tax = 0.1;
    public final double tourismTax = 10.0;
    public final double pricePerNight = 350.0;
    protected int startDay, duration, endDay;
    protected double PayedMoney,change;
    boolean paidStatus = false;
    
    //constructor
    public Receipt(int startDay, int duration) {
        this.startDay = startDay;
        this.duration = duration;
        int tempendDay = startDay + duration;
        if (tempendDay > 7) {
            tempendDay = tempendDay - 7;
        }
        this.endDay = tempendDay;
    }

    public Receipt(int StartDay, int duration, int endDay) {
        this.startDay = StartDay;
        this.duration = duration;
        this.endDay = endDay;
    }
    
    //payment function to for payment from the table
    public void Pay(int rowIndex, double payedMoney, double Change) throws FileNotFoundException {
             this.PayedMoney = payedMoney;
             this.change = Change;
             File file = new File("Booking.txt");
                try (Scanner inputFile = new Scanner(file)) {
                    ArrayList<String> dataArray = new ArrayList<>();
                    while (inputFile.hasNextLine()) {
                        dataArray.add(inputFile.nextLine()); 
                    }
                    inputFile.close(); 
                    String beforePaidData = dataArray.get(rowIndex); //get the specific row of data from the txt file that needs to change
                    String[] beforePaidArr = beforePaidData.split(",", -1);
                    beforePaidArr[8] = "Paid"; //updating status to Paid
                    String newData = String.join(",", beforePaidArr[0], beforePaidArr[1], beforePaidArr[2], beforePaidArr[3], beforePaidArr[4] , beforePaidArr[5], beforePaidArr[6], beforePaidArr[7], beforePaidArr[8]);

                    String previousString = dataArray.set(rowIndex, newData);
                    PrintWriter resetFile = new PrintWriter(file); //clearing the txt file to blank
                    resetFile.close();
                    dataArray.forEach((data) -> {
                        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
                            bw.write(data);
                            bw.newLine(); //write the updated data into the file
                        } catch (IOException e) {
                            System.out.println("Unable to create file due to " + e);
                        }
                    });     
                }              
    }
    
    public double getBasePrice(){
        double totalBasePrice = duration * pricePerNight;
        return totalBasePrice;
    }
    
    public double getPrice() {
        double totalBasePrice = duration * pricePerNight;
        double taxed = this.getTaxed();
        double tourismTaxed = this.getTourismTaxed();
        double finalPrice = (totalBasePrice + taxed + tourismTaxed);
        return finalPrice;
    }
    
    public double getTaxed() {
        double totalBasePrice = duration * pricePerNight;
        double taxed = totalBasePrice * tax;
        return taxed;
    }
    
    public double getTourismTaxed(){
        double tourismTaxed = tourismTax * duration;
        return tourismTaxed;
    }
    
    
    public int getEndDay() {
        return endDay;
    }

    public int getStartDay() {
        return startDay;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setPayedMoney(double PayedMoney) {
        this.PayedMoney = PayedMoney;
    }

    public double getChange() {
        return change;
    }

    public double getPayedMoney() {
        return PayedMoney;
    }
    
}

class convertDay {
    //static methods, convert int day -> String day / string day -> int day
    public static String convertInt(int dayOfWeek) {
        String dayName;
        switch (dayOfWeek) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3: 
                dayName = "Wednesday";
                break;
            case 4: 
                dayName = "Thursday";
                break;
            case 5: 
                dayName = "Friday";
                break;
            case 6: 
                dayName = "Saturday";
                break;
            case 7: 
                dayName = "Sunday";
                break;
            default:
                dayName = "No such day";
                 break;
        }
        return dayName;
    }
    
    public static int convertString(String dayName){
        int dayInt;
        switch (dayName) {
            case "Monday":
                dayInt = 1;
                break;
            case "Tuesday":
                dayInt = 2;
                break;
            case "Wednesday": 
                dayInt = 3;
                break;
            case "Thursday": 
                dayInt = 4;
                break;
            case "Friday": 
                dayInt = 5;
                break;
            case "Saturday": 
                dayInt = 6;
                break;
            case "Sunday": 
                dayInt = 7;
                break;
            default:
                dayInt = 1;
                 break;
        }
        return dayInt;
    }
}

//cleanup to force delete all the bookings that are passed due date already automatically.
class cleanup {
    public cleanup() throws FileNotFoundException {
        File file = new File("Booking.txt");
        Date newDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yy");
        String todayDate = formatDate.format(newDate);
        ArrayList<String> newArray = new ArrayList<>();
        try {
            try ( //file data saved as : username, password
                Scanner inputFile = new Scanner(file)) {//scanning file with a deliminiter to split it
                while (inputFile.hasNextLine()) {
                    String data = inputFile.nextLine();
                    String[] dataArr = data.split(",", -1);
                    int endDay = Integer.parseInt(dataArr[2]);
                    String fileBookDate = dataArr[7];
                    Calendar calendar = Calendar.getInstance();
                    int todayDayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) - 1);
                    if (todayDayOfWeek <= 0) {
                        todayDayOfWeek = todayDayOfWeek + 7;
                    }
          
                    //if the endDays are the same and the book day is not same, Delete
                    if ((endDay == todayDayOfWeek) && !(fileBookDate.equals(todayDate))) {
                        System.out.println(data);
                    } else {
                        newArray.add(data);
                    }
                }
            } 
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file due to " + e);
        }
        
                //Reseting the file to a blank sheed
                PrintWriter resetFile = new PrintWriter(file);
                resetFile.close();
                newArray.forEach((data) -> {
                    //for each string in the newArray, write it into file
                    try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
                        bw.write(data);
                        bw.newLine();
                    } catch (IOException e) {
                        System.out.println("Unable to create file due to " + e);
                    }
                });
        
    }
}


//this class is to check for the available rooms on a book date
class checkRoom {
    protected int startDay, duration, endDay;
    
    public checkRoom(int startDay, int duration) {  
        this.startDay = startDay;
        this.duration = duration;  
        int tempEndDay = startDay + duration;
        if (tempEndDay > 7) {
            this.endDay = (tempEndDay - 7);
        } else {
            this.endDay = tempEndDay;
        }
        
    }
    
    public ArrayList<String> getAvailableRooms() {
        //first make a list of all the rooms
         ArrayList<String> allRooms = new ArrayList<>();
          for (int i = 1; i <= 20; i++) {
            allRooms.add("R"+ i);
          }
         ArrayList<String> notAvailableRooms = new ArrayList<>();
         
        //check all the current bookings in the file
        File roomFile = new File("Booking.txt");
          try (Scanner room = new Scanner(roomFile)){
            while (room.hasNextLine()) {
                //get the content in line first 
                String Data = room.nextLine();
                //spliting content into array
                String[] tempRoomArray = Data.split(",", -1);
                
                //getting the data from the array
                int fileStartDay = Integer.parseInt(tempRoomArray[1]);
                int fileEndDay = Integer.parseInt(tempRoomArray[2]);
                
                //algorithm to get rooms that are not availble
                if (!((startDay >= fileEndDay) || (endDay <= fileStartDay)) || (startDay == fileStartDay && endDay == fileEndDay)) {
                    String roomNo = tempRoomArray[0];  
                    notAvailableRooms.add(roomNo);
                } 
            }
        } catch (Exception e) {
        }
          
          //minusing the not available rooms from the available rooms
          notAvailableRooms.forEach((string) -> {
              allRooms.remove(string);
        });
          
       //returns the list of available rooms    
       return allRooms;
    } 
    
}
 