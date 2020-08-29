/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.hospitalEnterprise.doctorPages;

import Business.Database.DB4OUtil;
import Business.Departments.Organization;
import Business.EcoSystem;
import Business.Enterprises.Enterprise;
import Business.Messages.Messages;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CustomerDoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import UI_Pages.hospitalEnterprise.DoctorAssistantPages.DocAssistantHome;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rohit
 */
public class Doctor_Home extends javax.swing.JPanel {

    JPanel rightPanel;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    EcoSystem business;
    DB4OUtil dB4OUtil;
    
    public Doctor_Home(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization,
            Enterprise enterprise, 
            EcoSystem business,DB4OUtil dB4OUtil){

            this.rightPanel = userProcessContainer;
            this.account = account;
            this.organization = organization;
            this.enterprise = enterprise;
            this.business = business;
            this.dB4OUtil = dB4OUtil;

            initComponents();
          //  btn_close.setVisible(false);
            init();    
            setMyEmails();
            btn_close.setVisible(false);
        
        
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

        for (int i = 0; i < DocWRTable.getModel().getColumnCount(); i++) {
            DocWRTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
 // Labels
        int totApp = 0;
        int completed = 0;
        for(Organization org : this.enterprise.getOrganizationDirectory().getOrganizationList()){
           if(org.getOrganizationType().equals("Doctor Organization"))
           {
               for(WorkRequest wr : org.getWorkQueue().getWorkRequestList()){
                   CustomerDoctorWorkRequest wr1 =(CustomerDoctorWorkRequest) wr;
                   if(wr1.getStatus().equals("Scheduled")){
                        totApp++;
                   }        
                   else if(wr1.getStatus().equals("Declined")){
                        completed++;
                   }        
                   else if(wr1.getStatus().equals("Attended")){
                        completed++;
                   }        
               }
            }          
       }
       myScheduleLbl.setText(""+totApp);
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

       DefaultTableModel model1 = (DefaultTableModel) DocWRTable.getModel();
       model1.setRowCount(0);
       for(Organization org : this.enterprise.getOrganizationDirectory().getOrganizationList()){
           if(org.getOrganizationType().equals("Doctor Organization"))
           {
               for(WorkRequest wr : org.getWorkQueue().getWorkRequestList()){
                  
                   if((wr.getStatus().equals("Scheduled") || wr.getStatus().equals("Attended")
                           || wr.getStatus().equals("Declined")
                           )){
                       
                            CustomerDoctorWorkRequest wr1 = (CustomerDoctorWorkRequest) wr;
                            if(wr1.getReceivingDoctor().equals(account.getEmployee())){
                                    Object[] row = new Object[4];
                                    row[0] = wr1.getAppointment().getDate();
                                    row[2] = wr1;
                                    row[3] = wr1.getStatus();
                                    row[1] = wr1.getTimeOfAppointment();
                                    model1.addRow(row);
                            }               
                   }
               
               
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

        usernameLbl = new javax.swing.JLabel();
        CancelAppointment = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        emailName1Label = new javax.swing.JLabel();
        emailText1Label = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        emailName2Label = new javax.swing.JLabel();
        emailText2Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DocWRTable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        notificationLbl = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        myScheduleLbl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        TreatmentButton = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        assignedLbl = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usernameLbl.setForeground(new java.awt.Color(96, 83, 150));
        usernameLbl.setText("Hello Dr. S");
        add(usernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 250, 37));

        CancelAppointment.setBackground(new java.awt.Color(255, 255, 255));
        CancelAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelAppointmentMouseClicked(evt);
            }
        });
        CancelAppointment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CancelAppointmentKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(96, 83, 150));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_multiply_26px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 83, 150));
        jLabel6.setText("<html><b>Cancel <br> Appointment");

        javax.swing.GroupLayout CancelAppointmentLayout = new javax.swing.GroupLayout(CancelAppointment);
        CancelAppointment.setLayout(CancelAppointmentLayout);
        CancelAppointmentLayout.setHorizontalGroup(
            CancelAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CancelAppointmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(75, 75, 75))
            .addGroup(CancelAppointmentLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CancelAppointmentLayout.setVerticalGroup(
            CancelAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CancelAppointmentLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        add(CancelAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, 90, 90));

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
                    .addComponent(emailText1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
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
                    .addComponent(emailText2Label))
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
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 340, 350));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        DocWRTable.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        DocWRTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"12 Apr ", "10.30", "Allan", null}
            },
            new String [] {
                "Date", "Time", "Patient", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DocWRTable.setGridColor(new java.awt.Color(247, 247, 247));
        DocWRTable.setRowHeight(20);
        DocWRTable.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane1.setViewportView(DocWRTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 600, 320));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(96, 83, 150));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_open_envelope_48px.png"))); // NOI18N
        jLabel16.setText("Recent messages");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 170, -1));

        jPanel15.setBackground(new java.awt.Color(96, 83, 150));

        btn_close.setBackground(new java.awt.Color(96, 83, 150));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(btn_close)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 230, 70));

        notificationLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        notificationLbl.setForeground(new java.awt.Color(96, 83, 150));
        notificationLbl.setText("You have 5 new Notifications");
        add(notificationLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 270, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(96, 83, 150));
        jLabel21.setText("My Schedule");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 124, 41));

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));

        myScheduleLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        myScheduleLbl.setForeground(new java.awt.Color(96, 83, 150));
        myScheduleLbl.setText("4");

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
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myScheduleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(myScheduleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        TreatmentButton.setBackground(new java.awt.Color(255, 255, 255));
        TreatmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TreatmentButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TreatmentButtonMousePressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(96, 83, 150));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_treatment_48px.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(96, 83, 150));
        jLabel25.setText("<html><b>Treatment");

        javax.swing.GroupLayout TreatmentButtonLayout = new javax.swing.GroupLayout(TreatmentButton);
        TreatmentButton.setLayout(TreatmentButtonLayout);
        TreatmentButtonLayout.setHorizontalGroup(
            TreatmentButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TreatmentButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TreatmentButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        TreatmentButtonLayout.setVerticalGroup(
            TreatmentButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TreatmentButtonLayout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        add(TreatmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 90, 90));

        jPanel17.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1230, 10));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(96, 83, 150));
        jLabel22.setText("Completed");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 124, 41));

        jPanel16.setBackground(new java.awt.Color(255, 255, 204));

        assignedLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        assignedLbl.setForeground(new java.awt.Color(96, 83, 150));
        assignedLbl.setText("4");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(96, 83, 150));
        jLabel26.setText("Total");

        jPanel18.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignedLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(assignedLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
      //  System.exit(0);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void TreatmentButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreatmentButtonMousePressed

        
        
    }//GEN-LAST:event_TreatmentButtonMousePressed

    private void CancelAppointmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CancelAppointmentKeyPressed

        
        
        
        
        
    }//GEN-LAST:event_CancelAppointmentKeyPressed

    private void CancelAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelAppointmentMouseClicked
        int selectedRow = DocWRTable.getSelectedRow();

        if(selectedRow >= 0)
        {
           CustomerDoctorWorkRequest wReq   = (CustomerDoctorWorkRequest) DocWRTable.getValueAt(selectedRow, 2);
           
            wReq.setStatus("Declined");
            
            wReq.setMessage("");
           
            wReq.getAppointment().setStatus("Declined");
            
            init();
            
            dB4OUtil.storeSystem(business);
                                  
        }
        else{
                 JOptionPane.showMessageDialog(null, "Please select a record");
        }
        
        
    }//GEN-LAST:event_CancelAppointmentMouseClicked

    private void TreatmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreatmentButtonMouseClicked
        int selectedRow = DocWRTable.getSelectedRow();
        if(selectedRow >= 0)
        {
            CustomerDoctorWorkRequest wReq   = (CustomerDoctorWorkRequest) DocWRTable.getValueAt(selectedRow, 2);
            if(wReq.getStatus().equals("Scheduled")){
                CardLayout layout = (CardLayout)rightPanel.getLayout();
              //  rightPanel.add(new DoctorProcess(rightPanel, (CustomerDoctorWorkRequest)wReq, account, organization, enterprise, business, dB4OUtil));
                rightPanel.add(new Doctor_Work(rightPanel, wReq, account, organization, enterprise, business, dB4OUtil));
               
              
              layout.next(rightPanel);        
            
            }
            else{
                JOptionPane.showMessageDialog(null, "The Patient is "+wReq.getStatus());
            }
           }
        else{
                 
            
                JOptionPane.showMessageDialog(null, "Please select a record");
        }
     
        
        
        
        
        
    }//GEN-LAST:event_TreatmentButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CancelAppointment;
    private javax.swing.JTable DocWRTable;
    private javax.swing.JPanel TreatmentButton;
    private javax.swing.JLabel assignedLbl;
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel emailName1Label;
    private javax.swing.JLabel emailName2Label;
    private javax.swing.JLabel emailText1Label;
    private javax.swing.JLabel emailText2Label;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myScheduleLbl;
    private javax.swing.JLabel notificationLbl;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
