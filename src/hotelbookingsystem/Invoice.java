/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbookingsystem;

/**
 *
 * @author Glenn Lim Phang Zhen
 */
public class Invoice extends javax.swing.JFrame {
    String startDay, endDay, roomNo;
    double finalPrice, tax, tourismTax, basePrice; 
    /**
     * Creates new form Invoice
     * @param booking
     */
    
    //constructor from the payment from after booking
    public Invoice(Booking booking) {
        initComponents();
        //setting all the label values in the jform
        startDay = convertDay.convertInt(booking.getStartDay());
        endDay = convertDay.convertInt(booking.getEndDay());  
        finalPrice = booking.getPrice();
        tax = booking.getTaxed();
        roomNo = booking.getRoomNo();
        tourismTax = booking.getTourismTaxed();
        basePrice = booking.getBasePrice();
        
        lblStartDay.setText(startDay);
        lblEndDay.setText(endDay);
        lblRoomNo.setText(roomNo);
        lblFinalPrice.setText("RM "+String.valueOf(finalPrice));
        lblTaxed.setText("RM "+String.valueOf(tax));
        lblTourismTax.setText("RM "+String.valueOf(tourismTax));
        lblBasePrice.setText("RM "+String.valueOf(basePrice));
        lblDuration.setText(String.valueOf(booking.getDuration()));
        lblChange.setText("RM " + String.valueOf(booking.getChange()));
        lblPaid.setText("RM " + String.valueOf(booking.getPayedMoney()));
        lblCustomerName.setText(booking.getCustomerName());
        
        
    }
    
    //constructor to generate invoice from the table, WITHOUT PAYMENT
    public Invoice(Receipt showReceipt, String roomNo, String customerName) {
        initComponents();
        //setting all the label values in the jform
        startDay = convertDay.convertInt(showReceipt.getStartDay());
        endDay = convertDay.convertInt(showReceipt.getEndDay());
        finalPrice = showReceipt.getPrice();
        tax = showReceipt.getTaxed();
        tourismTax = showReceipt.getTourismTaxed();
        basePrice = showReceipt.getBasePrice();
        lblCustomerName.setText(customerName);
        
        lblRoomNo.setText(roomNo);
        lblStartDay.setText(startDay);
        lblEndDay.setText(endDay);
        lblDuration.setText(String.valueOf(showReceipt.getDuration()));
        lblFinalPrice.setText("RM "+String.valueOf(finalPrice));
        lblTaxed.setText("RM "+String.valueOf(tax));
        lblTourismTax.setText("RM "+String.valueOf(tourismTax));
        lblBasePrice.setText("RM "+String.valueOf(basePrice));
        
        lblChangeLabel.setText("");
        lblPaidLabel.setText("");
        lblChange.setText("");
        lblPaid.setText("");
   
    }
    
    
    //generate receipt after a payment is done from the data in the table
    public Invoice(Receipt showReceipt, String roomNo, String customerName, String paidStatus) {
        initComponents();
        //setting all the label values in the jform
        jLabel1.setText("Receipt");
        startDay = convertDay.convertInt(showReceipt.getStartDay());
        endDay = convertDay.convertInt(showReceipt.getEndDay());
        finalPrice = showReceipt.getPrice();
        tax = showReceipt.getTaxed();
        tourismTax = showReceipt.getTourismTaxed();
        basePrice = showReceipt.getBasePrice();
        lblCustomerName.setText(customerName);
        lblRoomNo.setText(roomNo);
        lblStartDay.setText(startDay);
        lblEndDay.setText(endDay);
        lblDuration.setText(String.valueOf(showReceipt.getDuration()));
        lblFinalPrice.setText("RM "+String.valueOf(finalPrice));
        lblTaxed.setText("RM "+String.valueOf(tax));
        lblTourismTax.setText("RM "+String.valueOf(tourismTax));
        lblBasePrice.setText("RM "+String.valueOf(basePrice));
        lblChange.setText("RM " + String.valueOf(showReceipt.getChange()));
        lblPaid.setText("RM " + String.valueOf(showReceipt.getPayedMoney()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRoomNo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTaxed = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDuration = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        lblTourismTax = new javax.swing.JLabel();
        lblFinalPrice = new javax.swing.JLabel();
        lblBasePrice = new javax.swing.JLabel();
        lblStartDay = new javax.swing.JLabel();
        lblEndDay = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblPaidLabel = new javax.swing.JLabel();
        lblPaid = new javax.swing.JLabel();
        lblChangeLabel = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 50)); // NOI18N
        jLabel2.setText("Getwellsoon Hotel");

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 1, 24)); // NOI18N
        jLabel1.setText("Invoice");

        jLabel3.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel3.setText("Room No :");

        lblRoomNo.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        lblRoomNo.setText("Room No ");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel4.setText("Start Day :");

        jLabel5.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel5.setText("End Day :");

        jLabel6.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel6.setText("Base Price :");

        jLabel7.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel7.setText("Total Price:");

        jLabel8.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel8.setText("10% Service tax :");

        lblTaxed.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        lblTaxed.setText("Rm 10:");

        jLabel10.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel10.setText("RM350.00");

        jLabel11.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        jLabel11.setText("X");

        lblDuration.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        lblDuration.setText("3");

        jLabel13.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        jLabel13.setText("Night(s)");

        jLabel14.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel14.setText("Tourism Tax (RM10 pernight) :");

        lblTourismTax.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        lblTourismTax.setText("Rm 10:");

        lblFinalPrice.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        lblFinalPrice.setText("Rm 10:");

        lblBasePrice.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        lblBasePrice.setText("Rm 10:");

        lblStartDay.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        lblStartDay.setText("jLabel9");

        lblEndDay.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        lblEndDay.setText("jLabel9");

        lblCustomerName.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        lblCustomerName.setText("Customer Name");

        lblPaidLabel.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        lblPaidLabel.setText("Paid :");

        lblPaid.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        lblPaid.setText("Rm 10:");

        lblChangeLabel.setFont(new java.awt.Font("NSimSun", 0, 15)); // NOI18N
        lblChangeLabel.setText("Change :");

        lblChange.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        lblChange.setText("Rm 10:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)
                            .addComponent(lblPaidLabel)
                            .addComponent(lblChangeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFinalPrice)
                            .addComponent(lblTaxed)
                            .addComponent(lblTourismTax)
                            .addComponent(lblPaid)
                            .addComponent(lblChange)))
                    .addComponent(lblCustomerName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDuration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblStartDay))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblEndDay))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(lblBasePrice))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblRoomNo))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(lblCustomerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblRoomNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblStartDay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblEndDay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(lblDuration)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBasePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblTourismTax))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblTaxed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblFinalPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaidLabel)
                    .addComponent(lblPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChange)
                    .addComponent(lblChangeLabel))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBasePrice;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblChangeLabel;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblEndDay;
    private javax.swing.JLabel lblFinalPrice;
    private javax.swing.JLabel lblPaid;
    private javax.swing.JLabel lblPaidLabel;
    private javax.swing.JLabel lblRoomNo;
    private javax.swing.JLabel lblStartDay;
    private javax.swing.JLabel lblTaxed;
    private javax.swing.JLabel lblTourismTax;
    // End of variables declaration//GEN-END:variables
}
