/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.InsuranceEnterprise.Claims;
import Business.Billing.Bill;
import UI_Pages.InsuranceEnterprise.Manager.*;
import Business.Database.DB4OUtil;
import Business.Departments.Organization;
import Business.EcoSystem;
import Business.Enterprises.Enterprise;
import Business.Insurance.MedicalInsurance;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BillingWorkRequest;
import Business.WorkQueue.BuyInsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
//import UI_Pages.Sudhanshu.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Sudhanshu Gangele
 */
public class claimsProcessPanel extends javax.swing.JPanel {

    /**
     * Creates new form AgentJPanel
     */
    
    JPanel panelRight;
    BuyInsuranceWorkRequest buyRequest;
    UserAccount userAccount;
    Organization organization;
    Enterprise enterprise;
    EcoSystem business;
    DB4OUtil dB4OUtil;
//    WorkRequest wReq;
    BuyInsuranceWorkRequest buyReq;
    BillingWorkRequest claimFileReq;
    public claimsProcessPanel(JPanel panelRight, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business, DB4OUtil dB4OUtil,BillingWorkRequest w) {
        initComponents();
        
         //Populate AWT Choices/combobox 
        
        this.panelRight = panelRight;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.dB4OUtil = dB4OUtil;
        this.claimFileReq = w;
        
        
        loadPageWithFields();
//        visibilityonWorkReqType();
        
         

    }

         public void loadPageWithFields(){
     
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
         
         
//             for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
//                if((org.getOrganizationType().equals(Organization.Type.Sales_Organization.getValue()))&&(organization.getWorkQueue().getWorkRequestList().contains(wReq))){
//                    
//                   BuyInsuranceWorkRequest repWorkreq = (BuyInsuranceWorkRequest)wReq;
//                                this.buyReq = repWorkreq;
//                                        
////                    if(repWorkreq.getStatus().equals("In process")){
//                                  
//                                 txtFirstName.setText(repWorkreq.getPatient().getfName());
//                                 txtLastName.setText(repWorkreq.getPatient().getLastName());
//                                 txtMobileNo.setText(repWorkreq.getPatient().getMobno());
//                                 txtNetwork.setText(repWorkreq.getPatient().getNetwork().getName());
//                                String dob = simpleDateFormat.format(repWorkreq.getPatient().getDob());
//                                txtDOB.setText(dob);
//                                txtTestresult.setText(repWorkreq.getTestResult());
//                                lblHealthHistory.setText(repWorkreq.getPatient().getCheckBoxHealth()[0]+" "+repWorkreq.getPatient().getCheckBoxHealth()[1]);
//                                txtPlan.setText(repWorkreq.getPatient().getPlanType());
//                                txtEstEmi.setText(repWorkreq.getPatient().getEstEmi());
////                    }         

//                }
//                if((org.getOrganizationType().equals(Organization.Type.Claims_Organization.getValue()))&&(organization.getWorkQueue().getWorkRequestList().contains(wReq))){

//                   BillingWorkRequest claimReq = (BillingWorkRequest)claimFileReq;
//                                 this.claimFileReq = claimReq;
//                    if(claimReq.getStatus().equals("In process")){
                                  
                                 txtFirstName.setText(claimFileReq.getPatient().getfName());
                                 txtLastName.setText(claimFileReq.getPatient().getLastName());
                                 txtMobileNo.setText(claimFileReq.getPatient().getMobno());
                                 txtNetwork.setText(claimFileReq.getPatient().getNetwork().getName());
                                 String dob = simpleDateFormat.format(claimFileReq.getPatient().getDob());
                                 txtDOB.setText(dob);
//                                txtTestresult.setVisible(false);
//                                lblVitTestReport.setVisible(false);
//                                txtTestresult.setText(claimReq.getTestResult());
                                lblHealthHistory.setText(claimFileReq.getPatient().getCheckBoxHealth()[0]+" "+claimFileReq.getPatient().getCheckBoxHealth()[1]);
                                txtPlan.setText(claimFileReq.getPatient().getPlanType());
                                txtInsNo.setText(claimFileReq.getPatient().getInsDetail());
                                txtInsuredAmount.setText(claimFileReq.getPatient().getInsuredAmount());
                                txtInsPremium.setText(claimFileReq.getPatient().getActualEmi());
                                txtClaimAmount.setText(claimFileReq.getClaimedAmount());
//                                txtClaimSanctioned.setText(claimReq.getClaimSantioned());
//                    }
                
//                }
    
//             }

     }   
         
         
         
         
//         
//         public void visibilityonWorkReqType(){
//         
//             if(claimFileReq == null){
//                 lblVitTestReport.setVisible(true);
//                 txtTestresult.setVisible(true);
//                 txtEstEmi.setVisible(true);
//                 lblESTEmi.setVisible(true);
//                 txtClaimAmount.setVisible(false);
//                 txtClaimSanctioned.setVisible(false);
//                 txtCopay.setVisible(false);
//                 lblClaimedAmount.setVisible(false);
//                 lblCopay.setVisible(false);
//                 lblClaimSanctioned.setVisible(false);
//             }
//             
//             else{
//                 lblVitTestReport.setVisible(false);
//                 txtTestresult.setVisible(false);
//                 txtEstEmi.setVisible(false);
//                 lblESTEmi.setVisible(false);
//                 txtClaimAmount.setVisible(true);
//                 txtClaimSanctioned.setVisible(true);
//                 txtCopay.setVisible(true);
//                 lblClaimedAmount.setVisible(true);
//                 lblCopay.setVisible(true);
//                 lblClaimSanctioned.setVisible(true);
//             }
//         }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        txtMobileNo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPlan = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNetwork = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lblHealthHistory = new javax.swing.JLabel();
        txtInsNo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtInsPremium = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtInsuredAmount = new javax.swing.JTextField();
        lblClaimedAmount = new javax.swing.JLabel();
        txtClaimAmount = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        btnApprove = new java.awt.Button();
        jPanel11 = new javax.swing.JPanel();
        txtcustomerName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1140, 510));
        setPreferredSize(new java.awt.Dimension(1140, 510));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(16, 190, 121)));
        jPanel4.setForeground(new java.awt.Color(255, 182, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(12, 115, 101));
        jLabel8.setText("First Name");

        txtFirstName.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txtFirstNameComponentMoved(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(12, 115, 101));
        jLabel11.setText("Date Of Birth");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(12, 115, 101));
        jLabel13.setText("Plan");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(12, 115, 101));
        jLabel20.setText("State");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(12, 115, 101));
        jLabel21.setText("Health History");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(12, 115, 101));
        jLabel22.setText("Last Name");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(12, 115, 101));
        jLabel23.setText("Mobile");

        lblHealthHistory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHealthHistory.setText("jLabel1");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(12, 115, 101));
        jLabel25.setText("Insurance No.");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(12, 115, 101));
        jLabel26.setText("Customer EMI");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(12, 115, 101));
        jLabel27.setText("Insured Amount");

        txtInsuredAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInsuredAmountActionPerformed(evt);
            }
        });

        lblClaimedAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClaimedAmount.setForeground(new java.awt.Color(12, 115, 101));
        lblClaimedAmount.setText("Amount Claimed");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(txtFirstName)
                                .addComponent(txtMobileNo)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtInsNo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(txtInsPremium))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblClaimedAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtClaimAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNetwork, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtInsuredAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHealthHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInsNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInsPremium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHealthHistory)))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClaimedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClaimAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsuredAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 840, 470));

        jPanel15.setBackground(new java.awt.Color(12, 115, 101));

        btn_back.setBackground(new java.awt.Color(96, 83, 150));
        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_previous_48px.png"))); // NOI18N
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 182, Short.MAX_VALUE)
                .addComponent(btn_back))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 230, 70));

        btnApprove.setBackground(new java.awt.Color(16, 190, 121));
        btnApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnApprove.setLabel("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });
        add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 640, 130, 40));

        jPanel11.setBackground(new java.awt.Color(16, 190, 121));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1100, -1));

        txtcustomerName.setBackground(new java.awt.Color(41, 216, 95));
        txtcustomerName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcustomerName.setForeground(new java.awt.Color(12, 115, 101));
        add(txtcustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 190, 30));

        jLabel14.setBackground(new java.awt.Color(41, 216, 95));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(12, 115, 101));
        jLabel14.setText("Patient Details ");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 190, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed


        // TODO add your handling code here:
        
       
//        if(btnCalEMI.isEnabled()){
//            JOptionPane.showMessageDialog(null, "Please first complete above actions by clicking on Process ");
//        }
//        else{
        
            
              
//        if(claimFileReq ==null){
//            
//            buyReq.getPatient().setActualEmi(txtInsPremium.getText());
//            buyReq.getPatient().setInsDetail(txtInsNo.getText());
//            buyReq.getPatient().setInsuredAmount(txtInsuredAmount.getText());
//            
//            MedicalInsurance medIns = new MedicalInsurance();
//            medIns.setInsuranceNumber(Integer.parseInt(txtInsNo.getText()));
//            medIns.setPatient(buyReq.getPatient().getfName());
//            medIns.setStartDate(new Date());
//            Date date = new Date();
//            //end date to be set 
//            buyReq.getPatient().setMedIns(medIns);
//            
//            buyReq.setStatus("Approved");
//          
//            JOptionPane.showMessageDialog(null, " Claim Approved successfully");
//            btnApprove.setEnabled(false);
//        }
        
//        if(buyReq ==null){
            
//            claimFileReq.setCopay(txtCopay.getText());
//            claimFileReq.setClaimSantioned(txtClaimSanctioned.getText());

//            MedicalInsurance medIns = new MedicalInsurance();
//            medIns.setInsuranceNumber(Integer.parseInt(txtInsNo.getText()));
//            medIns.setPatient(buyReq.getPatient().getfName());
//            medIns.setStartDate(new Date());
//            buyReq.getPatient().setMedIns(medIns);
            
            
           
            claimFileReq.setStatus("In Process");
            JOptionPane.showMessageDialog(null, " Claim Processed successfully");
            btnApprove.setEnabled(false);
            
//        }   
//    }     
    }//GEN-LAST:event_btnApproveActionPerformed

    private void txtFirstNameComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtFirstNameComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameComponentMoved

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        Component[] comps = this.panelRight.getComponents();
        for(Component comp: comps){
            if(comp instanceof Claimsperson_workspace_1){
                Claimsperson_workspace_1 manageAdmin = (Claimsperson_workspace_1) comp;
                manageAdmin.populateTable(); // populateNetworkTable();
               // manageAdmin.init();
            
            }
        
        
        }
        
        CardLayout layout = (CardLayout)panelRight.getLayout();
        panelRight.remove(this);
        layout.previous(panelRight);
        
        
        // TODO add your handling code here:
        //  System.exit(0);

        //        Component[] componentArray = panelRight.getComponents();
        //        Component component = componentArray[componentArray.length-1];
        //        buyPlanJPanel buyPanel = (buyPlanJPanel) component;
        //        buyPanel.btnView();
        //        CardLayout layout = (CardLayout)panelRight.getLayout();
        //        layout.previous(panelRight);
    }//GEN-LAST:event_btn_backMouseClicked

    private void txtInsuredAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInsuredAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInsuredAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnApprove;
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblClaimedAmount;
    private javax.swing.JLabel lblHealthHistory;
    private javax.swing.JTextField txtClaimAmount;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtInsNo;
    private javax.swing.JTextField txtInsPremium;
    private javax.swing.JTextField txtInsuredAmount;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMobileNo;
    private javax.swing.JTextField txtNetwork;
    private javax.swing.JTextField txtPlan;
    private javax.swing.JLabel txtcustomerName;
    // End of variables declaration//GEN-END:variables
//    
//    private java.awt.Choice choice2;
//    private java.awt.Choice choice3;
}
