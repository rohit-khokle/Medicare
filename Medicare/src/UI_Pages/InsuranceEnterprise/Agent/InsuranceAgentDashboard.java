 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.InsuranceEnterprise.Agent;

import Business.Database.DB4OUtil;
import Business.Departments.Organization;
import Business.EcoSystem;
import Business.Enterprises.Enterprise;
import Business.Messages.Messages;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BuyInsuranceWorkRequest;
import Business.WorkQueue.CustomerLabWorkRequest;
import Business.WorkQueue.WorkRequest;
import UI_Pages.hospitalEnterprise.LabAssistant.LabProcess;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sudhanshu Gangele
 */
public class InsuranceAgentDashboard extends javax.swing.JPanel {

    /**
     * Creates new form agentDashBJPanel
     */
    JPanel rightPanel;
    BuyInsuranceWorkRequest bReq;
    UserAccount ua;
    Organization org;
    Enterprise ent;
    EcoSystem business;
    DB4OUtil dB4OUtil;
    public InsuranceAgentDashboard(JPanel rightPanel, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,DB4OUtil dB4OUtil) {
        initComponents();
        this.rightPanel =  rightPanel;
        
        this.dB4OUtil = dB4OUtil;
        this.ent = enterprise;
        this.ua = account;
        this.org = organization;
        this.business = business;
        init();
        populateInsuranceTable();
        setMyEmails();
        
                
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.white);
       // headerRenderer.set(Color.BLACK);

        for (int i = 0; i < CustomerInsuranceTbl.getModel().getColumnCount(); i++) {
            CustomerInsuranceTbl.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
    }
    
    public void init(){};
    
    
       public void populateInsuranceTable(){
       DefaultTableModel model1 = (DefaultTableModel) CustomerInsuranceTbl.getModel();
        int counter = 0;
        model1.setRowCount(0);
      /* for (WorkRequest wb : WorkQueue.workRequestList()) */
                Object[] row = new Object[5];
            for (WorkRequest wb : this.org.getWorkQueue().getWorkRequestList()){
                BuyInsuranceWorkRequest ib = (BuyInsuranceWorkRequest) wb;
                        String str = ib.getStatus();
                        String str1 = "In Process";
                        
                        if(!str.equals(str1)){
                  
               
                       // Object[] row = new Object[5];
                    
                        row[0] = ib;
                        row[1] = ib.getPatient().getfName();
                        row[2] = ib.getTypeOfInsurance();
                        row[3] = ib.getStatus();
                       
                        

                        model1.addRow(row);
                        counter = counter+1;
          }
            }
            lblPendingCount.setText(String.valueOf(counter));
                  }
        
        
              public void setMyEmails(){
        int myInboxNumber = ua.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().size();
 //       for(Messages msgs : patient.getMyMessages().getRecievedMsgsList().getRecievedMsgsList())
            if(myInboxNumber > 1){
                Messages msgs = ua.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 1);
                
                emailName1Label.setText(""+msgs.getSender());
                emailText1Label.setText(""+msgs.getSubject());                
            
                Messages lastButone  = ua.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 2);
                emailName2Label.setText(""+lastButone.getSender());
                emailText2Label.setText(""+lastButone.getSubject());                
            
            }
            else if(myInboxNumber == 1){
                Messages msgs = ua.getMyMessages().getRecievedMsgsList().getRecievedMsgsList().get(myInboxNumber - 1);
                
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgentName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblPendingCount = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerInsuranceTbl = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnSendProc = new java.awt.Button();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        emailName1Label = new javax.swing.JLabel();
        emailText1Label = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        emailName2Label = new javax.swing.JLabel();
        emailText2Label = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgentName.setBackground(new java.awt.Color(41, 216, 95));
        lblAgentName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAgentName.setForeground(new java.awt.Color(12, 115, 101));
        add(lblAgentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 170, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        lblPendingCount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPendingCount.setForeground(new java.awt.Color(12, 115, 101));
        lblPendingCount.setText("500");

        jPanel11.setBackground(new java.awt.Color(16, 190, 121));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblPendingCount, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblPendingCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 156, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(12, 115, 101));
        jLabel7.setText("Requests Pending");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, 170, 41));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        CustomerInsuranceTbl.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        CustomerInsuranceTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Allan", "XLS", "2hrs", "$200"},
                {"Brian", "React", "1hr", "$100 per hr"},
                {"Romeo", "C#", "3 Days", "$1000"},
                {"Alex", "C++ ", "10 hrs", "$50 per hr"}
            },
            new String [] {
                "File Number", "Name", "Plan", "Current Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CustomerInsuranceTbl.setGridColor(new java.awt.Color(247, 247, 247));
        CustomerInsuranceTbl.setRowHeight(20);
        CustomerInsuranceTbl.setSelectionBackground(new java.awt.Color(153, 255, 153));
        jScrollPane1.setViewportView(CustomerInsuranceTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 258, 492, 190));

        jLabel11.setBackground(new java.awt.Color(41, 216, 95));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(12, 115, 101));
        jLabel11.setText("Welcome");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 23, 90, 37));

        btnSendProc.setBackground(new java.awt.Color(16, 190, 121));
        btnSendProc.setForeground(new java.awt.Color(255, 255, 255));
        btnSendProc.setLabel("Process");
        btnSendProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendProcActionPerformed(evt);
            }
        });
        add(btnSendProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 458, 170, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));

        emailName1Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailName1Label.setForeground(new java.awt.Color(96, 83, 150));
        emailName1Label.setText("Oscar");

        emailText1Label.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        emailText1Label.setForeground(new java.awt.Color(96, 83, 150));
        emailText1Label.setText("<html> New incoming story on this side<br> Nothing major happening </html>");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailName1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailText1Label))
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
        emailText2Label.setText("<html>\nNew incoming story on this side<br>\nNothing major happening\n</html>");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailName2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailText2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailName2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailText2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        jPanel12.setBackground(new java.awt.Color(16, 190, 121));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 1050, 10));

        jPanel15.setBackground(new java.awt.Color(12, 115, 101));

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

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 230, 70));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(96, 83, 150));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_open_envelope_48px.png"))); // NOI18N
        jLabel17.setText("Recent messages");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendProcActionPerformed
        // TODO add your handling code here:
         int selectedRow = CustomerInsuranceTbl.getSelectedRow();
        if(selectedRow >= 0)
        {
            BuyInsuranceWorkRequest  bReq   = (BuyInsuranceWorkRequest) CustomerInsuranceTbl.getValueAt(selectedRow, 0);
            CardLayout layout = (CardLayout)this.rightPanel.getLayout();
            this.rightPanel.add(new InsuranceAgentProcess(rightPanel,business,bReq,dB4OUtil));
            layout.next(this.rightPanel);

        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a record");
        }

    }//GEN-LAST:event_btnSendProcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomerInsuranceTbl;
    private java.awt.Button btnSendProc;
    private javax.swing.JLabel emailName1Label;
    private javax.swing.JLabel emailName2Label;
    private javax.swing.JLabel emailText1Label;
    private javax.swing.JLabel emailText2Label;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgentName;
    private javax.swing.JLabel lblPendingCount;
    // End of variables declaration//GEN-END:variables
}
