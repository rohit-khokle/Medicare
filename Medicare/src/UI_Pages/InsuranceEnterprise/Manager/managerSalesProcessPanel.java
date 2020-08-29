/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.InsuranceEnterprise.Manager;
import Business.Billing.Bill;
import Business.Database.DB4OUtil;
import Business.Departments.Organization;
import Business.EcoSystem;
import Business.Enterprises.Enterprise;
import Business.Insurance.MedicalInsurance;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BillingWorkRequest;
import Business.WorkQueue.BuyInsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;
//import UI_Pages.Sudhanshu.*;
import java.awt.CardLayout;
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
public class managerSalesProcessPanel extends javax.swing.JPanel {

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
    WorkRequest wReq;
    BuyInsuranceWorkRequest buyReq;
    BillingWorkRequest claimFileReq;
    public managerSalesProcessPanel(JPanel panelRight, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business, DB4OUtil dB4OUtil,WorkRequest w) {
        initComponents();
        
         //Populate AWT Choices/combobox 
        
        this.panelRight = panelRight;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.dB4OUtil = dB4OUtil;
        this.wReq = w;
        
        loadPageWithFields();
        visibilityonWorkReqType();
        
       
        
    }

         public void loadPageWithFields(){
     
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
         
         
             for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
                if((org.getOrganizationType().equals(Organization.Type.Sales_Organization.getValue()))&&(org.getWorkQueue().getWorkRequestList().contains(wReq))){
                    
                   BuyInsuranceWorkRequest repWorkreq = (BuyInsuranceWorkRequest)wReq;
                                this.buyReq = repWorkreq;
                                        
//                    if(repWorkreq.getStatus().equals("In process")){
                                  
                                 txtFirstName.setText(repWorkreq.getPatient().getfName());
                                 txtLastName.setText(repWorkreq.getPatient().getLastName());
                                 txtMobileNo.setText(repWorkreq.getPatient().getMobno());
                                 txtNetwork.setText(repWorkreq.getPatient().getNetwork().getName());
                                String dob = simpleDateFormat.format(repWorkreq.getPatient().getDob());
                                txtDOB.setText(dob);
                                txtTestresult.setText(repWorkreq.getTestResult());
                                lblHealthHistory.setText(repWorkreq.getPatient().getCheckBoxHealth()[0]+" "+repWorkreq.getPatient().getCheckBoxHealth()[1]);
                                txtPlan.setText(repWorkreq.getPatient().getPlanType());
                                txtEstEmi.setText(repWorkreq.getPatient().getEstEmi());
//                    }         

                }
                if((org.getOrganizationType().equals(Organization.Type.Claims_Organization.getValue()))&&(org.getWorkQueue().getWorkRequestList().contains(wReq))){

                   BillingWorkRequest claimReq = (BillingWorkRequest)wReq;
                                 this.claimFileReq = claimReq;
//                    if(claimReq.getStatus().equals("In process")){
                                  
                                 txtFirstName.setText(claimReq.getPatient().getfName());
                                 txtLastName.setText(claimReq.getPatient().getLastName());
                                 txtMobileNo.setText(claimReq.getPatient().getMobno());
                                 txtNetwork.setText(claimReq.getPatient().getNetwork().getName());
                                String dob = simpleDateFormat.format(claimReq.getPatient().getDob());
                                txtDOB.setText(dob);
//                                txtTestresult.setVisible(false);
//                                lblVitTestReport.setVisible(false);
//                                txtTestresult.setText(claimReq.getTestResult());
                                lblHealthHistory.setText(claimReq.getPatient().getCheckBoxHealth()[0]+" "+claimReq.getPatient().getCheckBoxHealth()[1]);
                                txtPlan.setText(claimReq.getPatient().getPlanType());
                                txtInsNo.setText(claimReq.getPatient().getInsDetail());
                                txtInsuredAmount.setText(claimReq.getPatient().getInsuredAmount());
                                txtInsPremium.setText(claimReq.getPatient().getActualEmi());
                                txtClaimAmount.setText(claimReq.getClaimedAmount());
//                                txtClaimSanctioned.setText(claimReq.getClaimSantioned());
//                    }
                
                }
    
             }

     }   
         
         
         
         
         
         public void visibilityonWorkReqType(){
         
             if(claimFileReq == null){
                 lblVitTestReport.setVisible(true);
                 txtTestresult.setVisible(true);
                 txtEstEmi.setVisible(true);
                 lblESTEmi.setVisible(true);
                 txtClaimAmount.setVisible(false);
                 txtClaimSanctioned.setVisible(false);
                 txtCopay.setVisible(false);
                 lblClaimedAmount.setVisible(false);
                 lblCopay.setVisible(false);
                 lblClaimSanctioned.setVisible(false);
             }
             
             else{
                 lblVitTestReport.setVisible(false);
                 txtTestresult.setVisible(false);
                 txtEstEmi.setVisible(false);
                 lblESTEmi.setVisible(false);
                 txtClaimAmount.setVisible(true);
                 txtClaimSanctioned.setVisible(true);
                 txtCopay.setVisible(true);
                 lblClaimedAmount.setVisible(true);
                 lblCopay.setVisible(true);
                 lblClaimSanctioned.setVisible(true);
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
        btnCalEMI = new java.awt.Button();
        lblVitTestReport = new javax.swing.JLabel();
        txtTestresult = new javax.swing.JTextField();
        lblHealthHistory = new javax.swing.JLabel();
        txtInsNo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtInsPremium = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtInsuredAmount = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblClaimedAmount = new javax.swing.JLabel();
        txtClaimAmount = new javax.swing.JTextField();
        lblClaimSanctioned = new javax.swing.JLabel();
        txtClaimSanctioned = new javax.swing.JTextField();
        txtCopay = new javax.swing.JTextField();
        lblCopay = new javax.swing.JLabel();
        lblESTEmi = new javax.swing.JLabel();
        txtEstEmi = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        btnApprove = new java.awt.Button();
        jPanel11 = new javax.swing.JPanel();
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

        btnCalEMI.setBackground(new java.awt.Color(16, 190, 121));
        btnCalEMI.setForeground(new java.awt.Color(255, 255, 255));
        btnCalEMI.setLabel("Process");
        btnCalEMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalEMIActionPerformed(evt);
            }
        });

        lblVitTestReport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVitTestReport.setForeground(new java.awt.Color(12, 115, 101));
        lblVitTestReport.setText("Vital Test Report");

        lblHealthHistory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        lblClaimSanctioned.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClaimSanctioned.setForeground(new java.awt.Color(12, 115, 101));
        lblClaimSanctioned.setText("Claim Santioned");

        lblCopay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCopay.setForeground(new java.awt.Color(12, 115, 101));
        lblCopay.setText("Copay");

        lblESTEmi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblESTEmi.setForeground(new java.awt.Color(12, 115, 101));
        lblESTEmi.setText("Estimated EMI Amount");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lblVitTestReport, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblCopay)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtInsuredAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCopay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtInsNo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(150, 150, 150)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblClaimedAmount)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtClaimAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtInsPremium, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblClaimSanctioned)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtClaimSanctioned, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(106, 106, 106))
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalEMI, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblESTEmi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEstEmi, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                            .addComponent(txtFirstName)
                                            .addComponent(txtMobileNo)
                                            .addComponent(txtTestresult, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(34, 34, 34)
                                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPlan)))
                                        .addGap(98, 98, 98))
                                    .addComponent(lblHealthHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
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
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblVitTestReport, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTestresult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblESTEmi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstEmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHealthHistory)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnCalEMI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsPremium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsuredAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClaimedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClaimAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClaimSanctioned, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtClaimSanctioned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCopay)
                        .addComponent(txtCopay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 840, 470));

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
        add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, 130, 40));

        jPanel11.setBackground(new java.awt.Color(16, 190, 121));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1130, -1));

        jLabel14.setBackground(new java.awt.Color(41, 216, 95));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(12, 115, 101));
        jLabel14.setText("Customer Details");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    public double calculateEmi(double amount){
         
        if(txtTestresult.getText().equals("Normal")){
         amount = amount - (amount*0.1);
        }
        if(txtTestresult.getText().equals("Abnormal")){
         amount = amount + (amount*0.1);
        }
        return amount;
    }
    private void btnCalEMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalEMIActionPerformed

        // TODO add your handling code here:
        
        if(claimFileReq ==null){
           int actualEmi = 0;
           int insuredAmount = 0;
           int  estESMI = Integer.parseInt(txtEstEmi.getText());
           actualEmi = (int) calculateEmi(estESMI);
           
        if(txtPlan.getText().equals("Bronze")){
            
            insuredAmount = 50000;
        }
        if(txtPlan.getText().equals("Gold")){
            insuredAmount = 75000;
        }
        if(txtPlan.getText().equals("Platinum")){
            insuredAmount = 100000;
        }
           
           txtInsNo.setText(buyReq.getInsReqNo());
           txtInsPremium.setText(String.valueOf(actualEmi));
           txtInsuredAmount.setText(String.valueOf(insuredAmount));
           
        }
        
        if(buyReq == null){
            double copay = 0,sanctioned = 0;
            int claimAmount = Integer.parseInt(txtClaimAmount.getText());
//            sanctioned = 0.9*claimAmount;
//            copay      = 0.1*claimAmount;
            if(txtPlan.getText().equals("Bronze")){
                sanctioned = 0.6*claimAmount;
                copay      = 0.4*claimAmount;            
            }
            if(txtPlan.getText().equals("Gold")){
                sanctioned = 0.7*claimAmount;
                copay      = 0.3*claimAmount;            
            }
            if(txtPlan.getText().equals("Platinum")){
                sanctioned = 0.8*claimAmount;
                copay      = 0.2*claimAmount;            
            }
            txtClaimSanctioned.setText(String.valueOf(sanctioned));
            txtCopay.setText(String.valueOf(copay));
        }
  
        btnCalEMI.setEnabled(false);
        
    }//GEN-LAST:event_btnCalEMIActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed


        // TODO add your handling code here:
        
       
        if(btnCalEMI.isEnabled()){
            JOptionPane.showMessageDialog(null, "Please first complete above actions by clicking on Process ");
        }
        else{
        
            
              
        if(claimFileReq ==null){
            System.out.println("in buy insurance section");
            buyReq.getPatient().setActualEmi(txtInsPremium.getText());
            buyReq.getPatient().setInsDetail(txtInsNo.getText());
            buyReq.getPatient().setInsuredAmount(txtInsuredAmount.getText());
            
            MedicalInsurance medIns = new MedicalInsurance();
            
            medIns.setPatient(buyReq.getPatient().getfName());
            medIns.setStartDate(new Date());
            Date date = new Date();
            //end date to be set 
            buyReq.getPatient().setMedIns(medIns);
            buyReq.getPatient().setInsCompany(enterprise);
            
//            Bill newBill =buyReq.getPatient().getMyBillingHistory().createNewBill();
//            
//            newBill.setBillType("Insurance Bill");
//            newBill.setBillAmount(txtInsPremium.getText());
//            newBill.setBillStatus("Pending");
//            newBill.setEnterprise(buyReq.getPatient().getInsCompany());
////            newBill.setPaidThroughInsurance(Double.parseDouble(txtClaimSanctioned.getText()));
//            newBill.setPaidThroughSelf(Double.parseDouble(txtInsPremium.getText()));
//            
            
            buyReq.setStatus("Approved");
          
            JOptionPane.showMessageDialog(null, " Insurance sale Approved successfully");
            btnApprove.setEnabled(false);
        }
        
        if(buyReq ==null){
            System.out.println("in claimfile section");
            claimFileReq.setCopay(txtCopay.getText());
            claimFileReq.setClaimSantioned(txtClaimSanctioned.getText());


            Bill newBill =claimFileReq.getPatient().getMyBillingHistory().createNewBill();
            if(claimFileReq.getTestType().equals("Vitals Test")){
                newBill.setBillType("ClaimBill for Vital Test");
            }
            else if(claimFileReq.getTestType().equals("Doctor")){
                newBill.setBillType("ClaimBill for Doctor");
            }
            
            newBill.setBillAmount(txtClaimAmount.getText());
            newBill.setBillStatus("Pending");
            newBill.setEnterprise(claimFileReq.getEnterprise());
            newBill.setPaidThroughInsurance(Double.parseDouble(txtClaimSanctioned.getText()));
            newBill.setPaidThroughSelf(Double.parseDouble(txtCopay.getText()));
            
            claimFileReq.setStatus("Approved");
            JOptionPane.showMessageDialog(null, " Claim Approved successfully");
            btnApprove.setEnabled(false);
            
        }   
    }     
    }//GEN-LAST:event_btnApproveActionPerformed

    private void txtFirstNameComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtFirstNameComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameComponentMoved

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
        //  System.exit(0);

        panelRight.remove(this);

                Component[] componentArray = panelRight.getComponents();
                Component component = componentArray[componentArray.length-1];
                manager_workspace_1 panel = (manager_workspace_1) component;
                panel.populateTable();
                CardLayout layout = (CardLayout)panelRight.getLayout();
                layout.previous(panelRight);
    }//GEN-LAST:event_btn_backMouseClicked

    private void txtInsuredAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInsuredAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInsuredAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnApprove;
    private java.awt.Button btnCalEMI;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblClaimSanctioned;
    private javax.swing.JLabel lblClaimedAmount;
    private javax.swing.JLabel lblCopay;
    private javax.swing.JLabel lblESTEmi;
    private javax.swing.JLabel lblHealthHistory;
    private javax.swing.JLabel lblVitTestReport;
    private javax.swing.JTextField txtClaimAmount;
    private javax.swing.JTextField txtClaimSanctioned;
    private javax.swing.JTextField txtCopay;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEstEmi;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtInsNo;
    private javax.swing.JTextField txtInsPremium;
    private javax.swing.JTextField txtInsuredAmount;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMobileNo;
    private javax.swing.JTextField txtNetwork;
    private javax.swing.JTextField txtPlan;
    private javax.swing.JTextField txtTestresult;
    // End of variables declaration//GEN-END:variables
//    
//    private java.awt.Choice choice2;
//    private java.awt.Choice choice3;
}
