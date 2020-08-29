/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.customerPages;

import Business.Billing.Bill;
import Business.Customer.Patient;
import Business.Database.DB4OUtil;
import Business.Departments.Organization;
import Business.EcoSystem;
import Business.Enterprises.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BuyInsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sudhanshu Gangele
 */
public class DetailsAndPurchasePlanJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DetailsAndPurchasePlanJPanel
     */
    
    JPanel panelRight;
    BuyInsuranceWorkRequest buyRequest;
    UserAccount patient;
    Organization organization;
    Enterprise enterprise;
    EcoSystem business;
    DB4OUtil dB4OUtil;
    String plan;
    Patient p;
    int amount = 0;

    DetailsAndPurchasePlanJPanel(JPanel panelRight, UserAccount patient, Organization organization, Enterprise enterprise, EcoSystem business, DB4OUtil dB4OUtil,String plan) {
        initComponents();
        this.panelRight = panelRight;
        this.patient = patient;
 //       this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.dB4OUtil = dB4OUtil;
        this.plan = plan;
//        if(enterprise.equals(null)){
//        }else{
//        }
        p = (Patient)this.patient;
        System.out.println("Patient plan"+p.getPlanType());
        btnPay.setVisible(false);
        txtcustomerName.setText(p.getfName() + " "+p.getLastName());
        if(!(p.getPlanType()==null)){
        loadPageWithFields();
        loadPlan();
            System.out.println("landing here now");
        loadPageAfterReqSubmission();
        btnPay.setVisible(true);
        btnPay.setEnabled(false);
        Color lightPurple = new Color(232,201,232);
        btnPay.setBackground(lightPurple);
        btnReqInsurance.setLabel("Request submitted");
            System.out.println("in pay enable session 1");    
            
        btnReqInsurance.setEnabled(false);
        }
        else{
        loadPageWithFields();
        loadPlan();
        initialLoad();
        }
        
        paybtnmethod();
        
        this.dB4OUtil.storeSystem(business);
         }
            public void paybtnmethod(){
                
                System.out.println("getactualemi"+p.getActualEmi());
            if(!(p.getActualEmi()== null))   { 
                System.out.println("in pay enable session 2"); 
            for(Organization org : p.getInsCompany().getOrganizationDirectory().getOrganizationList()){
                if(org.getOrganizationType().equals(Organization.Type.Sales_Organization.getValue())){
                for( WorkRequest InsuranceBuyReq: org.getWorkQueue().getWorkRequestList()) {
                    
                   BuyInsuranceWorkRequest insWorkreq = (BuyInsuranceWorkRequest)InsuranceBuyReq;
                   System.out.println(" in populate table "+insWorkreq.getPatient().getUserName());
                   String s1 =insWorkreq.getPatient().getUserName();
                   String s2 = p.getUserName();
                   if(s1==s2){
                       System.out.println(" p.getinsdetail is"+p.getInsDetail()+" for "+p.getUserName());
                       System.out.println(" insWrokrep.getstatus is"+insWorkreq.getStatus());
                       
                       
                              if(!(p.getInsDetail().isEmpty())&& (insWorkreq.getStatus().contains("Approved"))){
                                  System.out.println("in pay enalbe session 3");
                                btnPay.setVisible(true);
                                btnPay.setEnabled(true);
                                Color purple = new Color(96,83,150);
                                btnPay.setBackground(purple);
                                btnReqInsurance.setLabel("Request submitted");
                                btnReqInsurance.setEnabled(false);
                                
                                lblAppearonAuth1.setVisible(true);
                                lblAppearonAuth2.setVisible(true);
                                lblAppearonAuth3.setVisible(true);
                                txtEMIAmount.setVisible(true);  
                                txtInsuranceNumber.setVisible(true);
                                txtInsuredAmount.setVisible(true);
                                txtInsuredAmount.setText(p.getInsuredAmount());
                                txtInsuranceNumber.setText(p.getInsDetail()); 
                                lblPaymentAmount.setText(p.getActualEmi()); 
                                }
                              else if(!(p.getInsDetail().isEmpty())&& (insWorkreq.getStatus().contentEquals("Paid"))){
                                btnPay.setVisible(true);
                                btnPay.setEnabled(false);
                                Color purple = new Color(96,83,150);
                                btnPay.setBackground(purple);
                                btnPay.setLabel("Paid");
                                btnReqInsurance.setLabel("Request submitted");
                                btnReqInsurance.setEnabled(false);
                                
                                lblAppearonAuth1.setVisible(true);
                                lblAppearonAuth2.setVisible(true);
                                lblAppearonAuth3.setVisible(true);
                                txtEMIAmount.setVisible(true);  
                                txtInsuranceNumber.setVisible(true);
                                txtInsuredAmount.setVisible(true);
                                txtInsuredAmount.setText(p.getInsuredAmount());
                                txtInsuranceNumber.setText(p.getInsDetail()); 
                                txtInsuranceNumber.setText(p.getActualEmi());
                                lblPaymentAmount.setText(p.getActualEmi());
                                }
                              else{
                                btnPay.setVisible(true);
                                btnPay.setEnabled(false);
                                Color pinkPurple = new Color(232,201,232);
                                btnPay.setBackground(pinkPurple);
                                btnReqInsurance.setLabel("Request submitted");
                                btnReqInsurance.setEnabled(false);
                                
                                
                                lblAppearonAuth1.setVisible(false);
                                lblAppearonAuth2.setVisible(false);
                                lblAppearonAuth3.setVisible(false);
                                txtEMIAmount.setVisible(false);  
                                txtInsuranceNumber.setVisible(false);
                                txtInsuredAmount.setVisible(false);
                              }
                   }
                }
                }
            }
            }
            }
            public void populateReqTableAfterReload(){
                
            DefaultTableModel dtm = (DefaultTableModel) tblAppear.getModel();
            dtm.setRowCount(0);
            for(Organization org : p.getInsCompany().getOrganizationDirectory().getOrganizationList()){
                if(org.getOrganizationType().equals(Organization.Type.Sales_Organization.getValue())){
                for( WorkRequest InsuranceBuyReq: org.getWorkQueue().getWorkRequestList()) {
                    
                   BuyInsuranceWorkRequest insWorkreq = (BuyInsuranceWorkRequest)InsuranceBuyReq;
                   System.out.println(" in populate table "+insWorkreq.getPatient().getUserName());
                   String s1 =insWorkreq.getPatient().getUserName();
                   String s2 = p.getUserName();
                   if(s1==s2){
//                    if(insWorkreq.getPatient().getUsername().equals(p.getUserName())){
                        Object[] row = new Object[4];
                        row[0]=insWorkreq.getRequestDate();
                        row[1]=insWorkreq.getCurrentEnterprise();
                        row[2]=insWorkreq.getTypeOfInsurance();
                        row[3]=insWorkreq.getStatus();
                        dtm.addRow(row);
                    }

                }
            }
            }
            }
            public void populateReqTable(){
            DefaultTableModel dtm = (DefaultTableModel) tblAppear.getModel();
            dtm.setRowCount(0);
           
                for( WorkRequest InsuranceBuyReq: organization.getWorkQueue().getWorkRequestList()) {
                    
                   BuyInsuranceWorkRequest insWorkreq = (BuyInsuranceWorkRequest)InsuranceBuyReq;
                   System.out.println(" in populate table "+insWorkreq.getPatient().getUserName());
                   String s1 =insWorkreq.getPatient().getUserName();
                   String s2 = p.getUserName();
                   if(s1==s2){
//                    if(insWorkreq.getPatient().getUsername().equals(p.getUserName())){
                        Object[] row = new Object[4];
                        row[0]=insWorkreq.getRequestDate();
                        row[1]=insWorkreq.getCurrentEnterprise();
                        row[2]=insWorkreq.getTypeOfInsurance();
                        row[3]=insWorkreq.getStatus();
                        dtm.addRow(row);
                    }

                }
            }
    
        public void populateComboBox(){
       
        
        
         DefaultComboBoxModel dm=new DefaultComboBoxModel();
         
         dm.addElement("Select");
         
           for(Enterprise e : this.p.getNetwork().getEnterpriseDirectory().getEnterpriseList()){
               
               if(e.getEnterpriseType()== Enterprise.EnterpriseType.Insurance){
           dm.addElement(e);    
               }
   }
           comboBoxETPName.setModel(dm);
    }
        
     public void loadPageAfterReqSubmission(){
         
// When the request is hit and pay button shows up
             lblDisappearonAuth.setVisible(false);
             lblDisappearonAuth1.setVisible(false);
             
             lblAppearonAuth.setVisible(true);
             lblAppear.setVisible(true);
             
            lblcbox1.setVisible(true);
           
             lblAppearonAuth5.setVisible(true);
             checkBox1.setVisible(false);
             checkbox2.setVisible(false);
             System.out.println("value of plan "+p.getPlanType());
             System.out.println("value of checkbostring"+p.getCheckBoxHealth().length);
             System.out.println("value of checkbox 1"+p.getCheckBoxHealth()[0]);
             if(!(p.getCheckBoxHealth()[0] == "")&&!(p.getCheckBoxHealth()[1]=="")){
                 lblcbox1.setText("Smoking History , Past Surgeries ");
             }
             else if(!(p.getCheckBoxHealth()[0]=="")){
                 lblcbox1.setText("Smoking History");
             }
             else {
                 if(!(p.getCheckBoxHealth()[1]=="")){
                 lblcbox1.setText("Past Surgeries");
             }
             }
             comboBoxETPName.setVisible(false);
             
             txtEstEMI.setText(p.getEstEmi());
             System.out.println("esemi"+p.getEstEmi());
             txtInsuranceCompanyName.setVisible(true);
             btnCalEStEMI.setEnabled(false);
             btnCalEStEMI.setLabel("Estimate");
             
             
             tblAppear.setVisible(true);
             txtInsuranceCompanyName.setText(p.getInsCompany().getName());
             txtEMIAmount.setText(p.getActualEmi());
             checkBox1.setSelected(false);
             checkbox2.setSelected(false);
             lblPaymentAmount.setVisible(false);
             lblPaymentAmount.setText("");
             populateComboBox();
//             populateReqTable();
             populateReqTableAfterReload();
             
     
     }
     
     public void loadPlan(){
     
                  if(plan =="Bronze"){
             Color bronze = new Color(205,127,50);
             Font font = new Font("Courier", Font.BOLD,14);
             txtPlan.setForeground(bronze);
             txtPlan.setFont(font);
             txtPlan.setText(this.plan);
         }
         if(plan =="Gold"){
             Color gold = new Color(212,175,55);
             Font font = new Font("Courier", Font.BOLD,14);
             txtPlan.setForeground(gold);
             txtPlan.setFont(font);
             txtPlan.setText(this.plan);
         }
         if(plan =="Platinum"){
             Color platinum = new Color(211,211,211);
             Font font = new Font("Courier", Font.BOLD,14);
             txtPlan.setForeground(platinum);
             txtPlan.setFont(font);
             txtPlan.setText(this.plan);
         }
     }
     
     public void initialLoad(){

         // This runs before request button is clicked
             lblDisappearonAuth.setVisible(true);
             lblDisappearonAuth1.setVisible(true);
             lblDisaapearonAuth2.setVisible(true);
             lblAppearonAuth.setVisible(false);
             lblAppear.setVisible(false);
             lblAppearonAuth1.setVisible(false);
             lblAppearonAuth2.setVisible(false);
             lblAppearonAuth3.setVisible(false);
             lblAppearonAuth5.setVisible(false);
             checkBox1.setEnabled(true);
             checkbox2.setEnabled(true);
             comboBoxETPName.setEnabled(true);
             comboBoxETPName.setVisible(true);
             txtEMIAmount.setVisible(false);
             txtEstEMI.setVisible(true);
             txtInsuranceCompanyName.setVisible(false);
             txtInsuranceNumber.setVisible(false);
             txtInsuredAmount.setVisible(false);
             btnCalEStEMI.setVisible(true);
             btnReqInsurance.setVisible(true);
             tblAppear.setVisible(false);
             txtInsuredAmount.setText("");
             txtInsuranceNumber.setText("");
             txtInsuranceCompanyName.setText("");
             txtEMIAmount.setText("");
             checkBox1.setSelected(false);
             checkbox2.setSelected(false);
             lblPaymentAmount.setVisible(true);
             lblPaymentAmount.setText("");
             lblcbox1.setVisible(false);
                     
             populateComboBox();
   
     }
     public void loadPageWithFields(){
     
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
         txtFirstName.setText(p.getfName());
         txtLastName.setText(p.getLastName());
         txtMobileNo.setText(p.getMobno());

         txtNetwork.setText(p.getNetwork().getName());
         String dob = simpleDateFormat.format(p.getDob());
         txtDOB.setText(dob);

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
        jLabel13 = new javax.swing.JLabel();
        txtPlan = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMobileNo = new javax.swing.JTextField();
        txtNetwork = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppear = new javax.swing.JTable();
        lblAppear = new javax.swing.JLabel();
        lblAppearonAuth1 = new javax.swing.JLabel();
        txtInsuranceNumber = new javax.swing.JTextField();
        txtInsuredAmount = new javax.swing.JTextField();
        lblAppearonAuth2 = new javax.swing.JLabel();
        lblAppearonAuth3 = new javax.swing.JLabel();
        txtEMIAmount = new javax.swing.JTextField();
        seperatorAppearonAuth = new javax.swing.JSeparator();
        lblDisaapearonAuth2 = new javax.swing.JLabel();
        btnReqInsurance = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        btnCalEStEMI = new java.awt.Button();
        txtEstEMI = new javax.swing.JTextField();
        comboBoxETPName = new javax.swing.JComboBox<>();
        lblDisappearonAuth1 = new javax.swing.JLabel();
        checkbox2 = new javax.swing.JCheckBox();
        checkBox1 = new javax.swing.JCheckBox();
        lblMedHistory = new javax.swing.JLabel();
        lblDisappearonAuth = new javax.swing.JLabel();
        lblAppearonAuth5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtInsuranceCompanyName = new javax.swing.JTextField();
        lblDisappearonAuth2 = new javax.swing.JLabel();
        lblcbox1 = new javax.swing.JLabel();
        btnPay = new java.awt.Button();
        lblAppearonAuth = new javax.swing.JLabel();
        lblPaymentAmount = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtcustomerName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1140, 510));
        setPreferredSize(new java.awt.Dimension(1140, 510));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 201, 232)));
        jPanel4.setForeground(new java.awt.Color(255, 182, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(96, 83, 150));
        jLabel8.setText("First Name");

        txtFirstName.setEditable(false);
        txtFirstName.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txtFirstNameComponentMoved(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(96, 83, 150));
        jLabel11.setText("Date Of Birth");

        txtDOB.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(96, 83, 150));
        jLabel13.setText("Plan Opted");

        txtPlan.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(96, 83, 150));
        jLabel22.setText("Last Name");

        txtLastName.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(96, 83, 150));
        jLabel23.setText("Mobile");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(96, 83, 150));
        jLabel15.setText("State ");

        txtMobileNo.setEditable(false);

        txtNetwork.setEditable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblAppear.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblAppear.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Company", "Plan", "Status"
            }
        ));
        tblAppear.setGridColor(new java.awt.Color(247, 247, 247));
        tblAppear.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblAppear.setRowHeight(20);
        tblAppear.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane1.setViewportView(tblAppear);

        lblAppear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAppear.setForeground(new java.awt.Color(96, 83, 150));
        lblAppear.setText("Track your request");

        lblAppearonAuth1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAppearonAuth1.setForeground(new java.awt.Color(96, 83, 150));
        lblAppearonAuth1.setText("Insurance Number");

        txtInsuranceNumber.setEditable(false);

        txtInsuredAmount.setEditable(false);

        lblAppearonAuth2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAppearonAuth2.setForeground(new java.awt.Color(96, 83, 150));
        lblAppearonAuth2.setText("Insured Amount");

        lblAppearonAuth3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAppearonAuth3.setForeground(new java.awt.Color(96, 83, 150));
        lblAppearonAuth3.setText("EMI");

        txtEMIAmount.setEditable(false);

        lblDisaapearonAuth2.setText("*Test for Insurance is Mandatory for Requesting a Purchase");

        btnReqInsurance.setBackground(new java.awt.Color(96, 83, 150));
        btnReqInsurance.setForeground(new java.awt.Color(255, 255, 255));
        btnReqInsurance.setLabel("Request Insurance");
        btnReqInsurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReqInsuranceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(seperatorAppearonAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAppear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAppearonAuth1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAppearonAuth2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblAppearonAuth3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInsuranceNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEMIAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInsuredAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDisaapearonAuth2)
                                    .addComponent(btnReqInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppearonAuth1)
                            .addComponent(txtInsuranceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppearonAuth2)
                            .addComponent(txtInsuredAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAppear, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAppearonAuth3)
                            .addComponent(txtEMIAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(lblDisaapearonAuth2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReqInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(seperatorAppearonAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCalEStEMI.setBackground(new java.awt.Color(96, 83, 150));
        btnCalEStEMI.setForeground(new java.awt.Color(255, 255, 255));
        btnCalEStEMI.setLabel("Calcuate Estimated EMI");
        btnCalEStEMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalEStEMIActionPerformed(evt);
            }
        });

        txtEstEMI.setEditable(false);
        txtEstEMI.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        txtEstEMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstEMIActionPerformed(evt);
            }
        });

        comboBoxETPName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxETPName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxETPNameActionPerformed(evt);
            }
        });

        lblDisappearonAuth1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblDisappearonAuth1.setForeground(new java.awt.Color(96, 83, 150));
        lblDisappearonAuth1.setText("* Select any Insurance Company in your Network for Claims and Corresponce");

        checkbox2.setText("Any Past Surgery Done");
        checkbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox2ActionPerformed(evt);
            }
        });

        checkBox1.setText("Smoking");

        lblMedHistory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedHistory.setForeground(new java.awt.Color(96, 83, 150));
        lblMedHistory.setText("Medical History");

        lblDisappearonAuth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDisappearonAuth.setForeground(new java.awt.Color(96, 83, 150));
        lblDisappearonAuth.setText("Please fill below information if applicable and see your estimated EMI");

        lblAppearonAuth5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAppearonAuth5.setForeground(new java.awt.Color(96, 83, 150));
        lblAppearonAuth5.setText("Insurance Company");

        txtInsuranceCompanyName.setEditable(false);
        txtInsuranceCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInsuranceCompanyNameActionPerformed(evt);
            }
        });

        lblDisappearonAuth2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDisappearonAuth2.setForeground(new java.awt.Color(96, 83, 150));
        lblDisappearonAuth2.setText("in USD");

        lblcbox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblcbox1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblcbox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMedHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addComponent(checkBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkbox2))
                            .addComponent(comboBoxETPName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisappearonAuth1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAppearonAuth5)
                                .addGap(18, 18, 18)
                                .addComponent(txtInsuranceCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCalEStEMI, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstEMI, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDisappearonAuth2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisappearonAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDisappearonAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkbox2)
                            .addComponent(checkBox1)
                            .addComponent(lblMedHistory)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAppearonAuth5)
                        .addComponent(txtInsuranceCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblcbox1)
                        .addGap(10, 10, 10)
                        .addComponent(lblDisappearonAuth1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxETPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalEStEMI, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEstEMI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDisappearonAuth2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnPay.setBackground(new java.awt.Color(96, 83, 150));
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setLabel("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        lblAppearonAuth.setText("Thank you for considering us for Business. Please track your request.Once approved,proceed with the payment");

        lblPaymentAmount.setBackground(new java.awt.Color(255, 255, 255));
        lblPaymentAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(196, 196, 196)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(178, 178, 178))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblAppearonAuth))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(lblPaymentAmount)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAppearonAuth)
                .addGap(19, 19, 19)
                .addComponent(lblPaymentAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 930, 710));

        jPanel15.setBackground(new java.awt.Color(96, 83, 150));

        btn_back.setBackground(new java.awt.Color(96, 83, 150));
        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_back_to_40px.png"))); // NOI18N
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
                .addGap(0, 190, Short.MAX_VALUE)
                .addComponent(btn_back))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 230, 70));

        jPanel11.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1110, 10));

        txtcustomerName.setBackground(new java.awt.Color(41, 216, 95));
        txtcustomerName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcustomerName.setForeground(new java.awt.Color(96, 83, 150));
        txtcustomerName.setText(" Dino Konstantopolos");
        add(txtcustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 190, 30));

        jLabel14.setBackground(new java.awt.Color(41, 216, 95));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(96, 83, 150));
        jLabel14.setText("Details for ");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(96, 83, 150));
        jLabel9.setText("Below are your details with us");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 200, 41));
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtFirstNameComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameComponentMoved

    public double calculateEmi(double i){
    
        
        Date dob =p.getDob();
        LocalDate localDate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        Period diff = Period.between(localDate, now);
        int years = diff.getYears();
        
        if(checkBox1.isSelected()){
            i = i+ (i*0.1);
        }
        if(checkbox2.isSelected()){
            i = i+ (i*0.05);
        }
        if(years>30 && years<=40){
            i = i+ (i*0.1);
        }
        if(years>40 && years<=50){
        i = i+ (i*0.1);
        }
        if(years>50 && years<=60){
        i = i+ (i*0.1);
        }
        if(years>60 && years<=70){
        i = i+ (i*0.1);
        }
        if(years>70 && years<=80){
        i = i+ (i*0.1);
        }
        if(years>80){
        i = i+ (i*0.1);
        }
        
        return i;
    }
    private void btnCalEStEMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalEStEMIActionPerformed
        // TODO add your handling code here:
        
        if(this.plan =="Bronze"){
            amount = 600;
            amount = (int) calculateEmi(amount);
        }
        if(this.plan =="Gold"){
            amount = 800;
            amount = (int) calculateEmi(amount);
        }
        if(this.plan =="Platinum"){
            amount =1000;
            amount = (int) calculateEmi(amount);
        }

        txtEstEMI.setText(String.valueOf(amount));
  this.dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_btnCalEStEMIActionPerformed

    private void txtEstEMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstEMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstEMIActionPerformed

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
        //  System.exit(0);
        
        panelRight.remove(this);
 
        Component[] componentArray = panelRight.getComponents();
        Component component = componentArray[componentArray.length-1];
        buyPlanJPanel buyPanel = (buyPlanJPanel) component;
        buyPanel.btnView();
        CardLayout layout = (CardLayout)panelRight.getLayout();
        layout.previous(panelRight);
        this.dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_btn_backMouseClicked

    private void checkbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox2ActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        
             lblAppearonAuth1.setVisible(true);
             lblAppearonAuth2.setVisible(true);
             lblAppearonAuth3.setVisible(true);
             txtEMIAmount.setVisible(true);  
             txtInsuranceNumber.setVisible(true);
             txtInsuredAmount.setVisible(true);
             txtInsuredAmount.setText(p.getInsuredAmount());
             txtInsuranceNumber.setText(p.getInsDetail()); 
             
          
            btnPay.setLabel("Paid");
            Color purple = new Color(96,83,150);
            btnPay.setBackground(purple);
            
        String paymentAmount = lblPaymentAmount.getText();
        Bill newBill = new Bill();
        BillingPage panel = new BillingPage(panelRight, patient, organization, enterprise, business, dB4OUtil,paymentAmount,newBill);
        panelRight.add("BillingPage", panel);
        CardLayout layout = (CardLayout) panelRight.getLayout();
        layout.next(panelRight);
                                
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnReqInsuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReqInsuranceActionPerformed
        // TODO add your handling code here:
         
        if(comboBoxETPName.getSelectedIndex()<=0){
             JOptionPane.showMessageDialog(null, "Please select the Insurance company");
        }
        else if(txtEstEMI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please calculate EMI score before submitting request");
        }
        else{
        this.enterprise = (Enterprise)comboBoxETPName.getSelectedItem();
         String a[] = new String[2];
         if(checkBox1.isSelected()){
             a[0] = "Smoking";
         }
         if(checkbox2.isSelected()){
             a[1] = "Surgery Done";
         }
         
         
         System.out.println(" befor org check after sales confirm, size of enterprise"+enterprise.getOrganizationDirectory().getOrganizationList().size());
         BuyInsuranceWorkRequest buyReq = new BuyInsuranceWorkRequest();
         
         for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
         if(org.getOrganizationType().equals(Organization.Type.Sales_Organization.getValue())){
//             System.out.println(" inside org check after sales confirm"+org.getName());
             this.organization = org;
             p.setInsuranceOrganization(organization);
             this.enterprise = enterprise;
             organization.getWorkQueue().getWorkRequestList().add(buyReq);
             p.setCheckBoxHealth(a);
             p.setEstEmi(txtEstEMI.getText());
             p.setInsCompany(enterprise);
             p.setInsDetail("");
             p.setInsuredAmount("");
             p.setPlanType(this.plan);
             p.setInsuranceOrganization(organization);
             buyReq.setPatient((Patient)patient);
             buyReq.setTypeOfInsurance(plan);
             buyReq.setStatus("Insurance Requested");
             buyReq.setMessage("");
             buyReq.setCurrentEnterprise(enterprise);
             buyReq.setRequestDate(new Date());
             buyReq.setPremiums(amount);
             
             
//             org.getWorkQueue().getWorkRequestList().add(buyReq);
             
//             System.out.println(" organization after adding wr "+org.getWorkQueue().getWorkRequestList().size());
//             System.out.println(" username of patient in buyrequest "+buyReq.getPatient().getUserName());
//             System.out.println("username of patient in object"+p.getUserName());
             loadPageAfterReqSubmission();
             this.buyRequest = buyReq;
            
             
             btnPay.setVisible(true);
             btnPay.setEnabled(false);
            Color lightPurple = new Color(232,201,232);
            btnPay.setBackground(lightPurple);
            btnReqInsurance.setLabel("Request submitted");
            
            
            btnReqInsurance.setEnabled(false);
//            dB4OUtil.storeSystem(business);
             
             JOptionPane.showMessageDialog(null, "Insurance requested successfully");
         }
         }
         
         this.dB4OUtil.storeSystem(business);
        
    }//GEN-LAST:event_btnReqInsuranceActionPerformed
    }
    private void comboBoxETPNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxETPNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxETPNameActionPerformed

    private void txtInsuranceCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInsuranceCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInsuranceCompanyNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCalEStEMI;
    private java.awt.Button btnPay;
    private java.awt.Button btnReqInsurance;
    private javax.swing.JLabel btn_back;
    private javax.swing.JCheckBox checkBox1;
    private javax.swing.JCheckBox checkbox2;
    private javax.swing.JComboBox<String> comboBoxETPName;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAppear;
    private javax.swing.JLabel lblAppearonAuth;
    private javax.swing.JLabel lblAppearonAuth1;
    private javax.swing.JLabel lblAppearonAuth2;
    private javax.swing.JLabel lblAppearonAuth3;
    private javax.swing.JLabel lblAppearonAuth5;
    private javax.swing.JLabel lblDisaapearonAuth2;
    private javax.swing.JLabel lblDisappearonAuth;
    private javax.swing.JLabel lblDisappearonAuth1;
    private javax.swing.JLabel lblDisappearonAuth2;
    private javax.swing.JLabel lblMedHistory;
    private javax.swing.JLabel lblPaymentAmount;
    private javax.swing.JLabel lblcbox1;
    private javax.swing.JSeparator seperatorAppearonAuth;
    private javax.swing.JTable tblAppear;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEMIAmount;
    private javax.swing.JTextField txtEstEMI;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtInsuranceCompanyName;
    private javax.swing.JTextField txtInsuranceNumber;
    private javax.swing.JTextField txtInsuredAmount;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMobileNo;
    private javax.swing.JTextField txtNetwork;
    private javax.swing.JTextField txtPlan;
    private javax.swing.JLabel txtcustomerName;
    // End of variables declaration//GEN-END:variables
}
