/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.hospitalEnterprise.DoctorAssistantPages;

import Business.Database.DB4OUtil;
import Business.Departments.Organization;
import Business.EcoSystem;
import UI_Pages.hospitalEnterprise.LabAssistant.*;
import Business.Enterprises.Enterprise;
import Business.Messages.Messages;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CustomerDoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import UI_Pages.hospitalEnterprise.doctorPages.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author madhav437
 */
public class DocAssistantHome extends javax.swing.JPanel {

    /**
     * Creates new form BillingPage1
     */
    JPanel rightPanel;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    EcoSystem business;
    DB4OUtil dB4OUtil;
    
    public DocAssistantHome(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization,
            Enterprise enterprise, 
            EcoSystem business,DB4OUtil dB4OUtil) {
        
        this.rightPanel = rightPanel;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.dB4OUtil = dB4OUtil;
        
        initComponents();
      //  btn_close.setVisible(false);
        init();
        setMyEmails();
    }
    
    public void init(){
         // Setting welcome string
         
         //welcomelabel.setText("");
            usernameLbl.setText(" Welcome "+this.account.getEmployee().getName());
         // Pseudo Code
         
         notificationLbl.setVisible(false);
         
       // Setting color of JTable
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.white);
       // headerRenderer.set(Color.BLACK);

        for (int i = 0; i < DAWorkReqTable.getModel().getColumnCount(); i++) {
            DAWorkReqTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
 // Labels
        int totApp = 0;
        int completed = 0;
        for(Organization org : this.enterprise.getOrganizationDirectory().getOrganizationList()){
           if(org.getOrganizationType().equals("Doctor Organization"))
           {
               for(WorkRequest wr : org.getWorkQueue().getWorkRequestList()){
                   CustomerDoctorWorkRequest wr1 =(CustomerDoctorWorkRequest) wr;
                   if(wr1.getStatus().equals("Appointment Requested")){
                        totApp++;
                   }
                   else if(wr1.getStatus().equals("Scheduled")){
                        completed++;
                   }        
                   else if(wr1.getStatus().equals("Declined")){
                        completed++;
                   }        
               }
            }          
       }
       totalApptLbl.setText(""+totApp);
       assignedLbl.setText(""+completed);
 
        populateLabTable();
    }
 public void setMyEmails(){
        int myInboxNumber = account.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().size();
 //       for(Messages msgs : patient.getMyMessages().getRecievedMsgsList().getRecievedMsgsList())
            if(myInboxNumber > 1){
                Messages msgs = account.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 1);
                
                emailName1Label.setText(""+msgs.getSender());
                emailText1Label.setText(""+msgs.getSubject());                
            
                Messages lastButone  = account.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 2);
                emailName2Label.setText(""+lastButone.getSender());
                emailText2Label.setText(""+lastButone.getSubject());                
            
            }
            else if(myInboxNumber == 1){
                Messages msgs = account.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 1);
                
                emailName1Label.setText(""+msgs.getSender());
                emailText1Label.setText(""+msgs.getSubject());                
            
            //    Messages lastButone  = patient.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 2);
                emailName2Label.setText("                                               ");; // .setText(""+lastButone.getSender());
                emailText2Label.setText("                                               ");; //.setText(""+lastButone.getSubject());                
            
            }
            else if(myInboxNumber == 0){
//                Messages msgs = patient.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 1);
                
                emailName1Label.setText("No new messages");
                emailText1Label.setText("                                               ");;               
            
            //    Messages lastButone  = patient.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 2);
                emailName2Label.setText("                                               "); // .setText(""+lastButone.getSender());
                emailText2Label.setText("                                               "); //.setText(""+lastButone.getSubject());                
            
            }



            
        
    }   
     public void populateLabTable(){

       DefaultTableModel model1 = (DefaultTableModel) DAWorkReqTable.getModel();
       model1.setRowCount(0);
       for(Organization org : this.enterprise.getOrganizationDirectory().getOrganizationList()){
           if(org.getOrganizationType().equals("Doctor Organization"))
           {int i = 0;
               for(WorkRequest wr : org.getWorkQueue().getWorkRequestList()){
                  
//                   if(wr.getStatus().equals("Doctor Appointment Requested")){
                        CustomerDoctorWorkRequest wr1 = (CustomerDoctorWorkRequest) wr;
                        Object[] row = new Object[5];
                        
                        Format f = new SimpleDateFormat("MM/dd/yy");
                        String strDate = f.format(wr1.getAppointment().getDate());
                        row[0] = strDate;
                       // row[0] = wr1.getAppointment().getDate();
                        row[2] = wr1;
                        row[3] = wr1.getReceivingDoctor();
                        row[4] = wr1.getStatus();
                        row[1] = wr1.getTimeOfAppointment();
                        System.out.println(" running "+i);
                        i++;
                        model1.addRow(row);               
  //                 }
               
               
               }
            }
           
           
       }
     
     }
       
        
           
           
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outLabPerson = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        assignedLbl = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DAWorkReqTable = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        notificationLbl = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        totalApptLbl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        confirmAppointmentButton = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        declineAppButton = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        emailName1Label = new javax.swing.JLabel();
        emailText1Label = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        emailName2Label = new javax.swing.JLabel();
        emailText2Label = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        outLabPerson.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        outLabPerson.setForeground(new java.awt.Color(96, 83, 150));
        add(outLabPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 150, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignedLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        assignedLbl.setForeground(new java.awt.Color(96, 83, 150));
        assignedLbl.setText("3");
        jPanel5.add(assignedLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, 60, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(96, 83, 150));
        jLabel19.setText("Total");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 30, 10));

        jPanel10.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 10));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 130, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(96, 83, 150));
        jLabel10.setText("Assigned");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 124, 30));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        DAWorkReqTable.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        DAWorkReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Patients", "Doctor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DAWorkReqTable.setGridColor(new java.awt.Color(247, 247, 247));
        DAWorkReqTable.setRowHeight(20);
        DAWorkReqTable.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane1.setViewportView(DAWorkReqTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 540, 260));

        jPanel15.setBackground(new java.awt.Color(96, 83, 150));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 230, 70));

        notificationLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        notificationLbl.setForeground(new java.awt.Color(96, 83, 150));
        notificationLbl.setText("You have 5 new Notifications");
        add(notificationLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 270, 30));

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));

        totalApptLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalApptLbl.setForeground(new java.awt.Color(96, 83, 150));
        totalApptLbl.setText("4");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(96, 83, 150));
        jLabel23.setText("Total");

        jPanel14.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(totalApptLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(totalApptLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(96, 83, 150));
        jLabel25.setText("<html>Total Appointments<br> request");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 41));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 83, 150));
        jLabel6.setText("Doctor Assistant Home Page");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 280, 40));

        usernameLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usernameLbl.setForeground(new java.awt.Color(96, 83, 150));
        usernameLbl.setText("Hello ");
        add(usernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 230, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(96, 83, 150));
        jLabel22.setText("Confirm");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 80, 30));

        confirmAppointmentButton.setBackground(new java.awt.Color(247, 247, 247));
        confirmAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_confirm_48px.png"))); // NOI18N
        confirmAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAppointmentButtonActionPerformed(evt);
            }
        });
        add(confirmAppointmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(96, 83, 150));
        jLabel21.setText("Decline");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 80, 30));

        declineAppButton.setBackground(new java.awt.Color(247, 247, 247));
        declineAppButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_banned_48px.png"))); // NOI18N
        declineAppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineAppButtonActionPerformed(evt);
            }
        });
        add(declineAppButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, -1, -1));

        jPanel12.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1470, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1470, 10));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));

        emailName1Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailName1Label.setForeground(new java.awt.Color(96, 83, 150));
        emailName1Label.setText("Dr Rohit");

        emailText1Label.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        emailText1Label.setForeground(new java.awt.Color(96, 83, 150));
        emailText1Label.setText("<html> Check Ron's Report<br> Surgery needed </html>");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(emailName1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(emailText1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailName1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailText1Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));

        emailName2Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailName2Label.setForeground(new java.awt.Color(96, 83, 150));
        emailName2Label.setText("Omar");

        emailText2Label.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        emailText2Label.setForeground(new java.awt.Color(96, 83, 150));
        emailText2Label.setText("<html> Are we done with Corona Tests ?<br></html>");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(emailName2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(emailText2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailName2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailText2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 390, 350));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(96, 83, 150));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_open_envelope_48px.png"))); // NOI18N
        jLabel16.setText("Recent messages");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 170, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void confirmAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAppointmentButtonActionPerformed
        // TODO add your handling code here:
        

        int selectedRow = DAWorkReqTable.getSelectedRow();
        if(selectedRow >= 0)
        {
           CustomerDoctorWorkRequest wReq   = (CustomerDoctorWorkRequest) DAWorkReqTable.getValueAt(selectedRow, 2);
           wReq.setStatus("Scheduled");
           
           wReq.getAppointment().setStatus("Confirmed");
           
            init();
            dB4OUtil.storeSystem(business);
            DAWorkReqTable.removeAll();

        }
        else{
                 JOptionPane.showMessageDialog(null, "Please select a record");
        }
        
    }//GEN-LAST:event_confirmAppointmentButtonActionPerformed

    private void declineAppButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineAppButtonActionPerformed
        // TODO add your handling code here:
        
        
        
        int selectedRow = DAWorkReqTable.getSelectedRow();
        if(selectedRow >= 0)
        {
           CustomerDoctorWorkRequest wReq   = (CustomerDoctorWorkRequest) DAWorkReqTable.getValueAt(selectedRow, 2);
           wReq.setStatus("Declined");
           wReq.getAppointment().setStatus("Appointment Declined.");
            dB4OUtil.storeSystem(business);           
           init();
        }
        else{
        JOptionPane.showMessageDialog(null, "Please select a record");
        }
        
    }//GEN-LAST:event_declineAppButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DAWorkReqTable;
    private javax.swing.JLabel assignedLbl;
    private javax.swing.JButton confirmAppointmentButton;
    private javax.swing.JButton declineAppButton;
    private javax.swing.JLabel emailName1Label;
    private javax.swing.JLabel emailName2Label;
    private javax.swing.JLabel emailText1Label;
    private javax.swing.JLabel emailText2Label;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel notificationLbl;
    private javax.swing.JLabel outLabPerson;
    private javax.swing.JLabel totalApptLbl;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
