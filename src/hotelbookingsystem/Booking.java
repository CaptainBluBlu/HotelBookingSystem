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
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Glenn Lim Phang Zhen
 */
public class Booking extends Receipt {
    
    //data in file will be saved as
    // roomNo, startDay, endDay, CustomerIC, customerName, customerEmail, customercontact, bookedDate, paidStatus
    protected String roomNo, customerIC, customerName, customerEmail, customerContact;
    protected int startDay, endDay, rowIndex;

    /**
     *
     * @param RoomNo
     * @param day
     * @param duration
     * @param customerIC
     * @param customerName
     * @param customerEmail
     * @param customerContact
     */
    public Booking(String RoomNo, int day, int duration, String customerIC, 
            String customerName, String customerEmail, String customerContact) {
        super(day, duration);
        this.roomNo = RoomNo;
        this.startDay = day;
        this.customerIC = customerIC;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        int tempEndDay = day + duration;   
        if (tempEndDay > 7) {
            this.endDay = (tempEndDay - 7);
        } else {
            this.endDay = tempEndDay;
        }
        this.customerContact = customerContact;       
    }
    
    public Booking(String RoomNo, int day, int duration, String customerIC, 
            String customerName, String customerEmail, String customerContact, int rowIndex) {
        super(day, duration);
        this.roomNo = RoomNo;
        this.startDay = day;
        this.customerIC = customerIC;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        int tempEndDay = day + duration;   
        if (tempEndDay > 7) {
            this.endDay = (tempEndDay - 7);
        } else {
            this.endDay = tempEndDay;
        }
        this.customerContact = customerContact;  
        this.rowIndex = rowIndex;    
    }
    
    public boolean checkBookingEntry() {
       //returns success
       boolean success = true;
       //using regex to check do input validation
        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String contactRegex = "^(6)?0(1)?(5)?[0-46-9]*?[0-9]{8,8}$";
        String ICRegex = "^\\d{12}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern contactPattern = Pattern.compile(contactRegex);
        Pattern ICPattern = Pattern.compile(ICRegex);
        Matcher emailMatcher = emailPattern.matcher(customerEmail);
        Matcher contactMatcher = contactPattern.matcher(customerContact);
        Matcher ICMatcher = ICPattern.matcher(customerIC);
        
        if (!emailMatcher.find()) {
            JOptionPane.showMessageDialog(null, "Please input a legitimate email!", "Error", JOptionPane.ERROR_MESSAGE);
            success = false;
        } else if (!contactMatcher.find()) {
            JOptionPane.showMessageDialog(null, "Please input a legitimate contact number!", "Error", JOptionPane.ERROR_MESSAGE);
            success =false;
        } else if (!ICMatcher.find()) {
            JOptionPane.showMessageDialog(null, "Please input a legitimate IC number!", "Error", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        return success;
    }
   
    
    public boolean writeBooking() {
        //roomNo, day, duration, endDay, duration, customerIC, customerName, customerEmail  
        String bookDay = String.valueOf(this.startDay);
        String endDay = String.valueOf(this.endDay);
        boolean success = true;
        Date newDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yy");
        String BookDate = formatDate.format(newDate);
            try {
                try (FileWriter fw = new FileWriter("Booking.txt", true); BufferedWriter bw = new BufferedWriter(fw)) {
                    // if already paid, write paid else notPaid
                    if (super.paidStatus) {
                        //joing all the fields data to a string with , as delimiter
                        String Data = String.join(",", roomNo, bookDay, endDay, customerIC, customerName  , customerEmail, customerContact, BookDate, "Paid");
                        bw.write(Data);
                        bw.newLine();
                        success = true;
                    } else {
                        String Data = String.join(",", roomNo, bookDay, endDay, customerIC, customerName  , customerEmail, customerContact, BookDate, "notPaid");
                        bw.write(Data);
                        bw.newLine();
                        success = true;
                    }
                    
                }
            } catch (IOException e) {
                System.out.println("Unable to create file due to " + e);
                success = false;
            }

        return success;
    }
    
    
    public boolean updateBooking() { //used for updating the txt file
        String bookDay = String.valueOf(this.startDay);
        String endDay = String.valueOf(this.endDay);
        boolean success = true;
        Date newDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yy"); //getting today's date, as booked day
        String BookDate = formatDate.format(newDate);
        if (this.checkBookingEntry()) {
            //join all the field data to be saved
            String updatedData = String.join(",", roomNo, bookDay, endDay, customerIC, customerName  , customerEmail, customerContact, BookDate, "notPaid");
            File file = new File("Booking.txt");
            try {
                ArrayList<String> dataArray;
                try (Scanner inputFile = new Scanner(file)) { //getting all the old data of the file and put them into array
                    dataArray = new ArrayList<>();
                    while (inputFile.hasNextLine()) {
                        dataArray.add(inputFile.nextLine());
                    }
                }
                //replace the old data with new data at the specific index
                String previousString = dataArray.set(rowIndex, updatedData);

                PrintWriter resetFile = new PrintWriter(file);
                resetFile.close();
                dataArray.forEach((data) -> {
                    try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
                        bw.write(data);
                        bw.newLine();
                    } catch (IOException e) {
                        System.out.println("Unable to create file due to " + e);
                    }
                });
                
            } catch (FileNotFoundException e) {
                System.out.println("Unable to open file due to " + e);
            }
        }
        return success;
    }
    
    //payment method after booking
    public void Pay(double payedMoney) {
        this.PayedMoney = payedMoney;
        double finalPrice = this.getPrice();
        double change = payedMoney - finalPrice;
        this.change = change;
        if (change >= 0) {
            this.paidStatus = true;
        }
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getCustomerIC() {
        return customerIC;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public int getEndDay() {
        return endDay;
    }

    public int getStartDay() {
        return startDay;
    }
    
}
