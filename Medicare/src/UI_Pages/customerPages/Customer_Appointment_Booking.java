/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.customerPages;

import Business.Customer.Appointment;
import Business.Customer.Patient;
import Business.Database.DB4OUtil;
import Business.Departments.Organization;
import Business.EcoSystem;
import Business.Employees.Employee;
import Business.Enterprises.Enterprise;
import Business.Medical.DoctorSchedule;
import Business.Network.Network;
import Business.Role.DoctorRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CustomerDoctorWorkRequest;
import Business.WorkQueue.CustomerLabWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sudhanshu Gangele
 */
public class Customer_Appointment_Booking extends javax.swing.JPanel {

    /**
     * Creates new form patientAppointmentJPanel
     */
    
    JPanel rightPanel;
    Patient customer;
    Organization organization;
    Enterprise enterprise;
    EcoSystem business;
    DB4OUtil dB4OUtil;
    CustomerLabWorkRequest labWorkReq ;
    CustomerDoctorWorkRequest docWorkReq;
    public Customer_Appointment_Booking(JPanel panelRight, Patient userAccount, Organization organization, Enterprise enterprise, EcoSystem business, DB4OUtil dB4OUtil){
        initComponents();
        this.rightPanel = panelRight;
        this.customer = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.dB4OUtil = dB4OUtil;
        jDateChooser1.setEnabled(false);
        rBtnVitalsTest.setVisible(false);
        rBtnInsuranceTest.setVisible(false);
        LblTestType.setVisible(false);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooser1.getDateEditor();
        editor.setEditable(false);

  //      this.docWorkReq = business.getWorkQueue().createCustomerDoctorWorkRequest();
 //       this.labWorkReq = business.getWorkQueue().createCustomerLabWorkRequest();
//        this.labWorkReq = 
  //      latestAppointmentHeading();
        populateComboBox();
        populateTbl();
   //     popEnterprise(); DELETE THIS METHOD
 
    }
    
    
    
    
    
    public void populateTbl(){
        
       DefaultTableModel model1 = (DefaultTableModel) tblBooking.getModel();
       model1.setRowCount(0);
       for (Appointment app : this.customer.getMyAppHistory().getMyAppointmentHistory())
               {
                        Object[] row = new Object[6];
                            row[0] = app.getDate();// userAccount.getEmployee().getOrg();
                            row[1] = app.getTime();  // userAccount.getEmployee().getName();
                            row[2] = app.getAppointmentType();  // userAccount.getEmployee().getId();
                            row[3] = app.getDoctor();// userAccount.getEmployee().getDocSpeciality();
                            row[4] = app.getStatus();// userAccount;
                          //  row[5] = app.getDoctor(); // userAccount.getPassword();
                            model1.addRow(row); 
                        
                        
          }
       
               
        // Setting color of JTable
        
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.white);
       // headerRenderer.set(Color.BLACK);

        for (int i = 0; i < tblBooking.getModel().getColumnCount(); i++) {
            tblBooking.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
  
       
       
    
            }
//  DONOT DELETE---UNCOMMENT ONCE THE CONNECTION IS MADE    
    public void populateComboBox(){
       
        
         DefaultComboBoxModel dm=new DefaultComboBoxModel();
         dm.addElement("Select");
           for(Network n:business.getNetworkList()){
           dm.addElement(n);    
   }
           comboBoxStateNetwork.setModel(dm);
    }
    
 //   public String[] populateHospitalEnterpriseComboBox(String s1){
    
//         DONOT DELETE ------ Uncode when the object call is successfully done -------
            public Enterprise[] populateHospitalEnterpriseComboBox(Network s1){
            Enterprise epList[] = new Enterprise[s1.getEnterpriseDirectory().getEnterpriseList().size()];
            int count = 0;

            for(Enterprise e : s1.getEnterpriseDirectory().getEnterpriseList()){
                     
                    if(e.getEnterpriseType().getValue().equals("Hospital"))
                    {   
                         epList[count] = e;
                         count++;
                    }
            }
            // RK Added 18th 4
            Enterprise result[] = new Enterprise[count];
            int counter = 0;            
            for(Enterprise e : epList){
                    if(e != null)
                    { 
                        result[counter] =  e;
                        counter++;
                    }
            }
            return result;

//            return epList;
            // END 18th
            
           /* for(Network n:business.getNetworkList()){
                if(n.equals(s1)){
                 for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                     epList[count] = e;
                     count++;
                 }
                }
            } */   


/*
        String s[] = new String[3]; 
         if(s1.equals("Massachussets")){
            s[0]= "Boston City Hospital";
            s[1]= "Cambridge Lifeline Hospital";
            
         }
         if(s1.equals("California")){
             s[0]= "Valley Sunshine Hospital";
             s[1]= "Fremont RedCross Hospital";
             
       }

        return s; */
    }
       public Employee[] populateDoctorComboBox(String s1, Organization org){ 
       
          int count = 0;
          Employee sp[] = new Employee[100];
        
         
            System.out.println("String : "+s1);
            System.out.println("String org : "+org);
            for(Employee e :org.getEmployeeDirectory().getEmployeeList()){
                System.out.println(" Emp name"+ e.getDocSpeciality());
                System.out.println(" Emp doc spec"+ e.getName());
                          
              if(e.getDocSpeciality().equals(s1)){
                
                  sp[count] = e;
                  count++;
                  System.out.println("inside emp :name"+e.getName());
              
              
              } 
          
          }
              Employee emp[] = new Employee[count];
             for(int i =0;i<emp.length;i++){
                 
             emp[i] = sp[i];  
             }
          return emp;
             }
   // public String[] populateDoctorComboBox(String s1){
//       public Employee[] populateDoctorComboBox(String s1){
////      DONOT DELETE ---UNCODE WHEN THE OBJECT CALL IS DONE
//
//
//// RK
//
//          int count = 0;
////          String sp[] = new String[10];
//          Employee doctor[] = {};
//         // for()
//
//
//
//
//
//
//
//
//// RK END
//
//
//         // int count = 0;
//          String sp[] = new String[10];
//         // Employee doctor[] = {};
//          Employee temp[] = new Employee[100];
//          List<String> docLabSpecializationList;
//          docLabSpecializationList = business.getEmployeeDirectory().getDocLabSpecializationList();
//          Network n1 = (Network)comboBoxStateNetwork.getSelectedItem();
//          Enterprise e1 = (Enterprise)comboBoxhospitalEnterprise.getSelectedItem();
////          String speciality = comboBoxSpecialistType.getSelectedItem().toString();
//          
//          for(Network n : business.getNetworkList()){
//              if(n.equals(n1)){
//              for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
//                  if(e.equals(e1)){
//                  for(Organization org : e.getOrganizationDirectory().getOrganizationList()){
//                      if(org.getOrganizationType().equals("Doctor Organization")){
//                          for(Employee emp : org.getEmployeeDirectory().getEmployeeList()){
//                              if(emp.getDocSpeciality().equals(s1)){
//                                  temp[count] = emp;
//                                  count++;
//                              }
//                          }                          
////                      for(String l : docLabSpecializationList){
////                          if(l.equals(s1)){
////                              doctor = new UserAccount[org.getUserAccountDirectory().getUserAccountList().size()];
////                          for(UserAccount ua : org.getUserAccountDirectory().getUserAccountList()){
////                              
////                              doctor[count] = ua;
////                              count++;
//////                              continue;
////                          }
////                          }else{
////                          doctor[count] = null;     
////                          }
////                      }
//                          
//                      }
//                      
//                      
////                      if(org.getOrganizationType()=="Lab Organization"){
////                      for(String l : docLabSpecializationList){
////                          if(l.equals(s1)){
////                          for(Employee emp : org.getEmployeeDirectory().getEmployeeList()){
////                              sp[count] = emp.getName();
////                              count++;
//////                              continue;
////                          }
////                          }else{
////                          sp[count] = "No LabPerson";     
////                          }
////                      }
////                          
////                      }
//                 
//                  }
//                  }else{
//                      //No Hospitals
//                      doctor[count] = null;
//                     }
//              }
//              } else{
//                  //No Network
//                      doctor[count] = null;
//                  }
//          }
//          
//         for(int i =0;i<temp.length;i++){
//             doctor[i] = temp[i];
//         } 
//         return doctor;
//
//
//
//
//   /*
//        String sp[] = new String[10]; 
//         if(s1.equals("Primary Physician")){
//            sp[0]="Julia Brown";
//         }
//         if(s1.equals("Cardiologist")){
//            sp[0]="Deepak BalaSubramaniam";
//            sp[1]="Zhang Wei";
//         }
//         if(s1.equals("Rheumatologist")){
//            sp[0]="Ryan Gosling";
//            sp[1]="Emma Watson";
//         }
//         if(s1.equals("General Surgeon")){
//            sp[0]="Bruce Lee";
//            sp[1]="Jackie Chan";
//         }
//         if(s1.equals("Psychiatrist")){
//            sp[0]="Rihanna";
//            sp[1]="Kal Penn";
//         }
//         if(s1.equals("Dermatologist")){
//            sp[0]="Cameroon Diaz";
//            sp[1]="Charlize Theron";
//         }
//         if(s1.equals("Neurologist")){
//            sp[0]="Erner Werhard";
//            sp[1]="James Cameroon";
//         }
//         
//        return sp; */
//    }
//    
    
    
  
//      DONOT DELETE ---UNCODE WHEN THE OBJECT CALL IS DONE   
       
//    public String[] populateAppointmentTypeOrganizationComboBox(String s1){
        public Organization[] populateAppointmentTypeOrganizationComboBox(Enterprise s1){

        
            Organization org[] = new Organization[s1.getOrganizationDirectory().getOrganizationList().size()];
           
            int count = 0;
            
            for(Organization o : s1.getOrganizationDirectory().getOrganizationList()){
                System.out.println(" org "+o.getOrganizationType());
                    if(o.getOrganizationType().equals("Doctor Organization"))
                    {           
                               org[count] = o;
                               count++;
                    }   
                    if(o.getOrganizationType().equals("Lab Organization"))
                    {           
                               org[count] = o;
                               count++;
                    }

            }
            // RK Added 18th 4
                Organization result[] = new Organization[count];
                int counter = 0;            
                for(Organization e : org){
                 //     System.out.println(" org "+e.getOrganizationType());
                   if(e != null){ 
                            result[counter] =  e;
                            counter++;
                        }
                }
                return result;            
               // return org;
            
            // RK End
            
         /*   for(Network n:business.getNetworkList()){
                
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e.equals(s1)){

                       for(Organization o1: e.getOrganizationDirectory().getOrganizationList()){
                               org[count] = o1;
                               count++;
                             
                       }
                       
                    }
                }
            }  */
            

            
      /*      
// ---CODE ABOVE DONOT DELETE ------            
        String s[] = new String[3];
         s[0] = "Doctor Appointment";
         s[1] = "Lab Appointment";
         
          

        
        return s; */
    
    }
    
 //      public String[] populateSpecialistComboBox(String s1){
//         DONOT DELETE ------ Uncode when the object call is successfully done -------
       public String[] populateSpecialistComboBox(Organization s1){
          int count = 0;
          String sp[] ={};
          
//          List<String> docLabSpecializationList;
//          docLabSpecializationList = business.getEmployeeDirectory().getDocLabSpecializationList();
//          Network n1 = (Network)comboBoxStateNetwork.getSelectedItem();
//          Enterprise e1 = (Enterprise)comboBoxhospitalEnterprise.getSelectedItem();
          
              
                     if(s1.getOrganizationType().equals("Doctor Organization")){

                        comboBoxSpecialistType.setEnabled(true);
                        comboBoxDoctor.setEnabled(true);
                        LblTestType.setVisible(false);
                        rBtnVitalsTest.setVisible(false);
                        rBtnInsuranceTest.setVisible(false);
                        rBtnVitalsTest.setEnabled(false);
                        rBtnInsuranceTest.setEnabled(false);
                        // System.out.println("in Doc Org");
                         HashSet<String> hs = new HashSet <String>();
                          for(Employee emp : s1.getEmployeeDirectory().getEmployeeList()){
                                hs.add(emp.getDocSpeciality());
                                //System.out.println("in Doc Org Emp loop");
//                              continue;

                          }
                          sp =  new String[hs.size()];
                          for(String s : hs){
                                sp[count] = s;
                                count++;                                                          
                          }
                      }
                      
                      if(s1.getOrganizationType().equals("Lab Organization")){
                          comboBoxSpecialistType.setEnabled(false);
                          comboBoxDoctor.setEnabled(false);
                          jDateChooser1.setEnabled(true);
                          LblTestType.setVisible(true);
                          rBtnVitalsTest.setVisible(true);
                          rBtnInsuranceTest.setVisible(true);
                          rBtnVitalsTest.setEnabled(true);
                          rBtnInsuranceTest.setEnabled(true);
//                          for(Employee emp : org.getEmployeeDirectory().getEmployeeList()){
//                              sp[count] = emp.getSpeciality();
//                              count++;
////                              continue;
//                          }
                      }
         return sp;
/*
// ---DONOT DELETE ABOVE----

        String sp[] = new String[10]; 
      
         if(s1.equals("Lab Appointment")){
            comboBoxSpecialistType.setEnabled(false);
            comboBoxDoctor.setEnabled(false);
            jDateChooser1.setEnabled(true);
            LblTestType.setVisible(true);
            rBtnVitalsTest.setVisible(true);
            rBtnInsuranceTest.setVisible(true);
            rBtnVitalsTest.setEnabled(true);
            rBtnInsuranceTest.setEnabled(true);
         }
         if(s1.equals("Doctor Appointment")){
            comboBoxSpecialistType.setEnabled(true);
            comboBoxDoctor.setEnabled(true);
            LblTestType.setVisible(false);
            rBtnVitalsTest.setVisible(false);
            rBtnInsuranceTest.setVisible(false);
            rBtnVitalsTest.setEnabled(false);
            rBtnInsuranceTest.setEnabled(false);
             sp[0]= "Primary Physician";
             sp[1]= "Cardiologist";
             sp[2]= "Rheumatologist";
             sp[3]= "General Surgeon";
             sp[4]= "Psychiatrist";
             sp[5]= "Dermatologist";
             sp[6]= "Neurologist";
         }

        return sp; */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboBoxSpecialistType = new javax.swing.JComboBox<>();
        comboBoxAppTypeOrganization = new javax.swing.JComboBox<>();
        comboBoxDoctor = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboBoxStateNetwork = new javax.swing.JComboBox<>();
        comboBoxhospitalEnterprise = new javax.swing.JComboBox<>();
        LblTestType = new javax.swing.JLabel();
        rBtnVitalsTest = new javax.swing.JRadioButton();
        rBtnInsuranceTest = new javax.swing.JRadioButton();
        comboBoxTime = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooking = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        labelIcon = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnBookAppointment = new java.awt.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1140, 510));
        setPreferredSize(new java.awt.Dimension(1140, 510));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 201, 232)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(96, 83, 150));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Make Appointment");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(96, 83, 150));
        jLabel8.setText("Appointment Type");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(96, 83, 150));
        jLabel14.setText("Specialist");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(96, 83, 150));
        jLabel15.setText("Date");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(96, 83, 150));
        jLabel16.setText("Doctor");

        comboBoxSpecialistType.setEditable(true);
        comboBoxSpecialistType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxSpecialistType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSpecialistTypeItemStateChanged(evt);
            }
        });
        comboBoxSpecialistType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSpecialistTypeActionPerformed(evt);
            }
        });

        comboBoxAppTypeOrganization.setEditable(true);
        comboBoxAppTypeOrganization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxAppTypeOrganization.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxAppTypeOrganizationItemStateChanged(evt);
            }
        });
        comboBoxAppTypeOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAppTypeOrganizationActionPerformed(evt);
            }
        });

        comboBoxDoctor.setEditable(true);
        comboBoxDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxDoctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboBoxDoctorFocusLost(evt);
            }
        });

        jDateChooser1.setMinSelectableDate(new Date());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(96, 83, 150));
        jLabel9.setText("Hospital Name");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(96, 83, 150));
        jLabel17.setText("State");

        comboBoxStateNetwork.setEditable(true);
        comboBoxStateNetwork.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxStateNetworkItemStateChanged(evt);
            }
        });
        comboBoxStateNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStateNetworkActionPerformed(evt);
            }
        });

        comboBoxhospitalEnterprise.setEditable(true);
        comboBoxhospitalEnterprise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxhospitalEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxhospitalEnterpriseItemStateChanged(evt);
            }
        });
        comboBoxhospitalEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxhospitalEnterpriseActionPerformed(evt);
            }
        });

        LblTestType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblTestType.setForeground(new java.awt.Color(96, 83, 150));
        LblTestType.setText("Lab Test Type");

        rBtnVitalsTest.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rBtnVitalsTest);
        rBtnVitalsTest.setText("Vitals Test");
        rBtnVitalsTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnVitalsTestActionPerformed(evt);
            }
        });

        rBtnInsuranceTest.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rBtnInsuranceTest);
        rBtnInsuranceTest.setText("Tests For Insurance");

        comboBoxTime.setEditable(true);
        comboBoxTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9:00 - 9:30", "9:30 - 10:00", "10:00 - 10:30", "10:30 - 11:00", "11:00 - 11:30", "11:30 - 12:00", "12:00 - 12:30", "13:30 - 14:00", "14:00 - 14:30", "14:30 - 15:00", "15:00 - 15:30", "15:30 - 16:00", "16:00 - 16:30", "16:30 - 17:00", "17:00 - 17:30", "17:30 - 18:00", "17:00 - 17:30", "17:30 - 18:00", "18:00 - 18:30", "18:30 - 19:00", "19:00 - 19:30", "19:30 - 20:00" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTestType, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboBoxDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxSpecialistType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxAppTypeOrganization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxhospitalEnterprise, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxStateNetwork, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboBoxTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rBtnVitalsTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnInsuranceTest)))
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(comboBoxStateNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(comboBoxhospitalEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(comboBoxAppTypeOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTestType)
                    .addComponent(rBtnVitalsTest)
                    .addComponent(rBtnInsuranceTest))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSpecialistType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(comboBoxTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(29, 29, 29))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 490, 420));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 201, 232)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(96, 83, 150));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Booking History");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 490, 30));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblBooking.setBackground(new java.awt.Color(247, 247, 247));
        tblBooking.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Appointment Type ", "Doctor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        tblBooking.setToolTipText("");
        tblBooking.setGridColor(new java.awt.Color(247, 247, 247));
        tblBooking.setRowHeight(20);
        tblBooking.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane1.setViewportView(tblBooking);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 470, 180));

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 500, 420));

        jPanel15.setBackground(new java.awt.Color(96, 83, 150));

        btn_close.setBackground(new java.awt.Color(96, 83, 150));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_back_to_40px.png"))); // NOI18N
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
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(btn_close)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 230, 70));

        labelIcon.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelIcon.setForeground(new java.awt.Color(96, 83, 150));
        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_Pages/images/icons8_health_checkup_80px.png"))); // NOI18N
        add(labelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 90));

        jPanel11.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1370, -1));

        btnBookAppointment.setBackground(new java.awt.Color(96, 83, 150));
        btnBookAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btnBookAppointment.setLabel("Book Appointment");
        btnBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookAppointmentActionPerformed(evt);
            }
        });
        add(btnBookAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
      //  System.exit(0);
              CardLayout layout = (CardLayout)rightPanel.getLayout();
        rightPanel.remove(this);
        layout.previous(rightPanel);

      
      
      
    }//GEN-LAST:event_btn_closeMouseClicked
    public boolean CheckScheduleAvailability(){
                Employee doctor = (Employee)comboBoxDoctor.getSelectedItem();
                String testType ="";
                String timeOfAppointment = comboBoxTime.getSelectedItem().toString();
                Date date = jDateChooser1.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try{
                  date = sdf.parse(sdf.format(date));
                }
                catch(ParseException e){
                    System.out.println("Parse Exception");
                }
                DoctorSchedule ds = new DoctorSchedule(date,timeOfAppointment, this.customer);

                return doctor.checkScheduleAvailability(ds);
    }   
    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed

        // TODO add your handling code here:
        
        if((comboBoxhospitalEnterprise.getSelectedIndex()<= 0)||(comboBoxAppTypeOrganization.getSelectedIndex()<=0)){
            JOptionPane.showMessageDialog(null, "Please select required values");
        }else if((comboBoxAppTypeOrganization.getSelectedItem().equals("Doctor Organization"))&&(comboBoxSpecialistType.getSelectedIndex()<=0)){
            JOptionPane.showMessageDialog(null, "Please select required Specialist");
        }else if((comboBoxSpecialistType.getSelectedIndex()>0)&&(comboBoxDoctor.getSelectedIndex()<=0)){
            JOptionPane.showMessageDialog(null, "Please select required Doctor");
        }else if((comboBoxAppTypeOrganization.getSelectedItem().equals("Lab Organization"))&&(!(rBtnVitalsTest.isSelected())||!(rBtnInsuranceTest.isSelected()))){
            JOptionPane.showMessageDialog(null, "Please select Type of Test");
        }else if((comboBoxAppTypeOrganization.getSelectedIndex()>0)&&(jDateChooser1.getDate() == null)){
            JOptionPane.showMessageDialog(null, "Please select appropriate date");
        }
        else if(((Organization)comboBoxAppTypeOrganization.getSelectedItem()).getOrganizationType().equals("Doctor Organization")         
        &&
          !CheckScheduleAvailability()       
                ){
            JOptionPane.showMessageDialog(null, "The time slot is already booked. Please try other time slot.");
        }
        
        
        
        //Booking the appointment now
        else{

            Network state = (Network)comboBoxStateNetwork.getSelectedItem();
            Enterprise hospital = (Enterprise)comboBoxhospitalEnterprise.getSelectedItem();
            Organization org= (Organization)comboBoxAppTypeOrganization.getSelectedItem();
            //Reminder: specialist type and UserAccount will have null values in case of Lab organization. This has been implemented below
            String specialistType = comboBoxSpecialistType.getSelectedItem().toString();
            Date date = jDateChooser1.getDate();
            String testType ="";
            Employee doctor = (Employee)comboBoxDoctor.getSelectedItem();
            String timeOfAppointment = comboBoxTime.getSelectedItem().toString();
            
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          //  Date dateWithoutTime;
          try{
            date = sdf.parse(sdf.format(date));
          }
          catch(ParseException e){
              System.out.println("Parse Exception");
          }
            
         DoctorSchedule ds = new DoctorSchedule(date,timeOfAppointment, this.customer);
            

        //    doctor.checkScheduleAvailability(ds);
        
        //Preparing Customer Working request and Customer Lab Work Request
        
        if(org.getOrganizationType().equals("Doctor Organization")){
                
                docWorkReq =new CustomerDoctorWorkRequest();
                
                docWorkReq.setPatient(customer);
                docWorkReq.setNetworkState(state);
                docWorkReq.setHospital(hospital);
                docWorkReq.setOrgRequested(org);
                docWorkReq.setSpecialistType(specialistType);
                docWorkReq.setSender(customer);
                docWorkReq.setReceivingDoctor(doctor);
                docWorkReq.setWorkRequestType("");
                docWorkReq.setRequestDate(new Date());
           //     docWorkReq.setAppointmentDate(date);
                docWorkReq.setStatus("Appointment Requested");
                docWorkReq.setRefBy("Self");
                docWorkReq.setMessage("");
                docWorkReq.setTestResult("");
                docWorkReq.setTimeOfAppointment(timeOfAppointment);
                
                
                doctor.getDs().add(ds);
                Appointment e = new Appointment(ds.getDate(), ds.getTime(), doctor, specialistType, "Processing", "Doctor");
                docWorkReq.setAppointment(e);
                org.getWorkQueue().getWorkRequestList().add(docWorkReq);
                
                customer.getMyAppHistory().getMyAppointmentHistory().add(e);
                
                
                JOptionPane.showMessageDialog(null, "Your Appointment With Dr. "+doctor.getName()+" is on request. We will process it and confirm shortly.");

                populateTbl();
                
                comboBoxStateNetwork.removeAllItems();
                comboBoxhospitalEnterprise.removeAllItems();
                comboBoxAppTypeOrganization.removeAllItems();
                comboBoxSpecialistType.removeAllItems();
                comboBoxDoctor.removeAllItems();
                jDateChooser1.setDate(null);
                populateComboBox();
                dB4OUtil.storeSystem(business);
        
        }
        if(org.getOrganizationType().equals("Lab Organization")){
            
           labWorkReq = new CustomerLabWorkRequest();
           specialistType = "";
           doctor = null;
            if(rBtnVitalsTest.isSelected()){
                testType = "Vitals Test";
            }
            if(rBtnInsuranceTest.isSelected()){
                testType = "Tests For Insurance";
            } 
        labWorkReq.setPatient(customer);
        labWorkReq.setNetworkState(state);
        labWorkReq.setHospital(hospital);
        labWorkReq.setOrgRequested(org);
        labWorkReq.setSpecialistType(specialistType);
        labWorkReq.setSender(customer);

        labWorkReq.setWorkRequestType(testType);
        labWorkReq.setRequestDate(new Date());
        labWorkReq.setAppointmentDate(date);
        labWorkReq.setStatus( " "+testType+ "Appointment Requested");
        labWorkReq.setRefBy("Self");
        labWorkReq.setMessage("");
        labWorkReq.setTestResult("");
        
//        doctor.getDs().add(ds);
        
        org.getWorkQueue().getWorkRequestList().add(labWorkReq);
        Appointment e = new Appointment(ds.getDate(), ds.getTime(), null, "Lab Testing", "Confirmed", "Lab Department");
        customer.getMyAppHistory().getMyAppointmentHistory().add(e);

        JOptionPane.showMessageDialog(null, "Your Lab Appointment is confirmed successfully");
                        
        populateTbl();
        
        comboBoxStateNetwork.removeAllItems();
        comboBoxhospitalEnterprise.removeAllItems();
        comboBoxAppTypeOrganization.removeAllItems();
        comboBoxSpecialistType.removeAllItems();
        comboBoxDoctor.removeAllItems();
        jDateChooser1.setDate(null);
        populateComboBox();
        dB4OUtil.storeSystem(business);
        
            } 
        }
    }//GEN-LAST:event_btnBookAppointmentActionPerformed
   
    private void comboBoxAppTypeOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAppTypeOrganizationActionPerformed
        // TODO add your handling code here:
     //   comboBoxDoctor.removeAllItems();
        
        
    }//GEN-LAST:event_comboBoxAppTypeOrganizationActionPerformed

    private void comboBoxSpecialistTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSpecialistTypeActionPerformed
        // TODO add your handling code here:
   //     comboBoxDoctor.removeAllItems();
       
    }//GEN-LAST:event_comboBoxSpecialistTypeActionPerformed

    private void comboBoxAppTypeOrganizationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxAppTypeOrganizationItemStateChanged

        // TODO add your handling code here:
        
        if(evt.getStateChange()==ItemEvent.SELECTED){
           
            comboBoxDoctor.removeAllItems();
            if(this.comboBoxAppTypeOrganization.getSelectedIndex()>0){
                   DefaultComboBoxModel dm=new DefaultComboBoxModel();
                   int i = 0;
                    dm.addElement("Select");
                    String[] sp = this.populateSpecialistComboBox((Organization)this.comboBoxAppTypeOrganization.getSelectedItem());
                    for(i = 0;i<sp.length;i++){
                        dm.addElement(sp[i]);
                    }
                    this.comboBoxSpecialistType.setModel(dm);
//                this.comboBoxSpecialistType.setModel(new DefaultComboBoxModel(this.populateSpecialistComboBox((Organization)this.comboBoxAppTypeOrganization.getSelectedItem())));
//                this.comboBoxSpecialistType.setModel(new DefaultComboBoxModel(this.populateSpecialistComboBox(this.comboBoxAppTypeOrganization.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_comboBoxAppTypeOrganizationItemStateChanged

    private void comboBoxSpecialistTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSpecialistTypeItemStateChanged
        // TODO add your handling code here:
        
        
        
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(this.comboBoxSpecialistType.getSelectedIndex()>0){
                jDateChooser1.setEnabled(true);
                
                   DefaultComboBoxModel dm=new DefaultComboBoxModel();
                   int i = 0;
                    dm.addElement("Select");
                    Employee[] emp = this.populateDoctorComboBox(this.comboBoxSpecialistType.getSelectedItem().toString(),(Organization) this.comboBoxAppTypeOrganization.getSelectedItem());
                    for(i = 0;i<emp.length;i++){
                        dm.addElement(emp[i]);
                    }
                    this.comboBoxDoctor.setModel(dm);
        //        this.comboBoxDoctor.setModel(new DefaultComboBoxModel(this.populateDoctorComboBox(this.comboBoxSpecialistType.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_comboBoxSpecialistTypeItemStateChanged

    private void comboBoxStateNetworkItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxStateNetworkItemStateChanged
        // TODO add your handling code here:
        
        if(evt.getStateChange()==ItemEvent.SELECTED){
            comboBoxAppTypeOrganization.removeAllItems();
            comboBoxSpecialistType.removeAllItems();
            comboBoxDoctor.removeAllItems();
            
            
            if(this.comboBoxStateNetwork.getSelectedIndex()>0){
                
                System.out.println("Selected network");
 //               this.comboBoxhospitalEnterprise.setModel(new DefaultComboBoxModel(this.populateHospitalEnterpriseComboBox(this.comboBoxStateNetwork.getSelectedItem().toString())));
                   DefaultComboBoxModel dm=new DefaultComboBoxModel();
                   int i = 0;
                    dm.addElement("Select");
                    Enterprise[] e = this.populateHospitalEnterpriseComboBox((Network)this.comboBoxStateNetwork.getSelectedItem());
                    for(i = 0;i<e.length;i++){
                        dm.addElement(e[i]);
                    }
                    this.comboBoxhospitalEnterprise.setModel(dm);
                    

//                  this.comboBoxhospitalEnterprise.setModel(new DefaultComboBoxModel(this.populateHospitalEnterpriseComboBox((Network)this.comboBoxStateNetwork.getSelectedItem())));
            }
        }  
    }//GEN-LAST:event_comboBoxStateNetworkItemStateChanged

    private void comboBoxStateNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStateNetworkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxStateNetworkActionPerformed

    private void comboBoxhospitalEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxhospitalEnterpriseItemStateChanged
        // TODO add your handling code here:
        
        if(evt.getStateChange()==ItemEvent.SELECTED){
           
            comboBoxSpecialistType.removeAllItems();
            comboBoxDoctor.removeAllItems();
            if(this.comboBoxhospitalEnterprise.getSelectedIndex()>0){
                   DefaultComboBoxModel dm=new DefaultComboBoxModel();
                   int i = 0;
                    dm.addElement("Select");
                    Organization[] org = this.populateAppointmentTypeOrganizationComboBox((Enterprise)this.comboBoxhospitalEnterprise.getSelectedItem());
                    for(i = 0;i<org.length;i++){
                        dm.addElement(org[i]);
                    }
                    this.comboBoxAppTypeOrganization.setModel(dm);
//                this.comboBoxAppTypeOrganization.setModel(new DefaultComboBoxModel(this.populateAppointmentTypeOrganizationComboBox(this.comboBoxhospitalEnterprise.getSelectedItem().toString())));
//                this.comboBoxAppTypeOrganization.setModel(new DefaultComboBoxModel(this.populateAppointmentTypeOrganizationComboBox((Enterprise)this.comboBoxhospitalEnterprise.getSelectedItem())));
            }
        }
    }//GEN-LAST:event_comboBoxhospitalEnterpriseItemStateChanged

    private void comboBoxhospitalEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxhospitalEnterpriseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxhospitalEnterpriseActionPerformed

    private void rBtnVitalsTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnVitalsTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnVitalsTestActionPerformed

    private void comboBoxDoctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxDoctorFocusLost
          

    }//GEN-LAST:event_comboBoxDoctorFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblTestType;
    private java.awt.Button btnBookAppointment;
    private javax.swing.JLabel btn_close;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboBoxAppTypeOrganization;
    private javax.swing.JComboBox<String> comboBoxDoctor;
    private javax.swing.JComboBox<String> comboBoxSpecialistType;
    private javax.swing.JComboBox<String> comboBoxStateNetwork;
    private javax.swing.JComboBox<String> comboBoxTime;
    private javax.swing.JComboBox<String> comboBoxhospitalEnterprise;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JRadioButton rBtnInsuranceTest;
    private javax.swing.JRadioButton rBtnVitalsTest;
    private javax.swing.JTable tblBooking;
    // End of variables declaration//GEN-END:variables
}
