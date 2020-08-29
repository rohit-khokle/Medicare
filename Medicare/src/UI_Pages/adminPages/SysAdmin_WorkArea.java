/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Pages.adminPages;

import Business.Database.DB4OUtil;
import Business.EcoSystem;
import Business.Employees.Employee;
import Business.Enterprises.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rohit
 */
public class SysAdmin_WorkArea extends javax.swing.JPanel {

    /**
     * Creates new form BillingPage1
     */
    
    JPanel rightPanel;
    UserAccount account;
    EcoSystem system;
    DB4OUtil dB4OUtil;
   // DefaultComboBoxModel<String[]> model = new DefaultComboBoxModel(states);
    // For JCombo Box
    
                 // To remove the item which is already present
                //    test = ArrayUtils.remove(test, 2);
    String[] states = new String[]{"Alaska",
                  "Alabama",
                  "Arkansas",
                  "American Samoa",
                  "Arizona",
                  "California",
                  "Colorado",
                  "Connecticut",
                  "District of Columbia",
                  "Delaware",
                  "Florida",
                  "Georgia",
                  "Guam",
                  "Hawaii",
                  "Iowa",
                  "Idaho",
                  "Illinois",
                  "Indiana",
                  "Kansas",
                  "Kentucky",
                  "Louisiana",
                  "Massachusetts",
                  "Maryland",
                  "Maine",
                  "Michigan",
                  "Minnesota",
                  "Missouri",
                  "Mississippi",
                  "Montana",
                  "North Carolina",
                  " North Dakota",
                  "Nebraska",
                  "New Hampshire",
                  "New Jersey",
                  "New Mexico",
                  "Nevada",
                  "New York",
                  "Ohio",
                  "Oklahoma",
                  "Oregon",
                  "Pennsylvania",
                  "Puerto Rico",
                  "Rhode Island",
                  "South Carolina",
                  "South Dakota",
                  "Tennessee",
                  "Texas",
                  "Utah",
                  "Virginia",
                  "Virgin Islands",
                  "Vermont",
                  "Washington",
                  "Wisconsin",
                  "West Virginia",
                  "Wyoming"};
        
    
    
    public SysAdmin_WorkArea(JPanel rightPanel, UserAccount account,  EcoSystem system, DB4OUtil dB4OUtil ) {
        this.rightPanel = rightPanel;
        this.account = account;
        this.system = system;
        this.dB4OUtil =dB4OUtil;
        
        initComponents();
        init();
        populateNetworkTable();

        
    }
    public void init(){
        welcomelabel.setText("Welcome "+account.getEmployee().getName());
        btn_close.setVisible(false);

        int emp = 0;
        for(Employee e : system.getEmployeeDirectory().getEmployeeList()){
                         
                            emp += 1; // et.getEmployeeDirectory().getEmployeeList().size();
             }
        
        for(Network net : system.getNetworkList()){
            for(Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()){
                for(Employee e : ent.getEmployeeDirectory().getEmployeeList())
                    emp += 1;
            }
          }
                        
        
      
        int ent = 0;
        for(Network net : system.getNetworkList()){
             //   ent += net.getEnterpriseDirectory().getEnterpriseList().size();
                for(Enterprise et : net.getEnterpriseDirectory().getEnterpriseList()){
                            ent += 1; // et.getEmployeeDirectory().getEmployeeList().size();
                       
                
                }
        }         
        //        system.getNetworkList() 
        enterpriseNoLbl.setText(""+ent);
        employeesNoLbl.setText(""+emp);
        networkNoLbl.setText(""+system.getNetworkList().size());
    
        
        // Setting color of JTable
        
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.white);
       // headerRenderer.set(Color.BLACK);

        for (int i = 0; i < networkEnterpriseTable.getModel().getColumnCount(); i++) {
            networkEnterpriseTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
  
        
        // Set combo box color
        networkLocation.getEditor().getEditorComponent().setBackground(Color.white);
        
        
    }
    
    public void populateNetworkTable(){
        DefaultTableModel model = (DefaultTableModel) networkEnterpriseTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[2];
            row[0] = network;
            row[1] = network.getLocation();
            model.addRow(row);
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

        welcomelabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        addNetBtn = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        networkNoLbl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        enterpriseNoLbl = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        employeesNoLbl = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        networkName = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        networkLocation = new javax.swing.JComboBox<>(states);
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        networkEnterpriseTable = new javax.swing.JTable();
        addNetworkBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomelabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        welcomelabel.setForeground(new java.awt.Color(96, 83, 150));
        welcomelabel.setText("Hello");
        add(welcomelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 22, -1, 33));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(96, 83, 150));
        jLabel7.setText("Networks");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 293, 228, 41));

        jPanel15.setBackground(new java.awt.Color(96, 83, 150));

        btn_close.setBackground(new java.awt.Color(96, 83, 150));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/icons8_close_window_52px_2_1.png"))); // NOI18N
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
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(btn_close)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        addNetBtn.setBackground(new java.awt.Color(247, 247, 247));
        addNetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/icons8_add_40px_1.png"))); // NOI18N
        addNetBtn.setOpaque(false);
        addNetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNetBtnActionPerformed(evt);
            }
        });
        add(addNetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 506, -1, -1));

        jPanel11.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 930, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));

        networkNoLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        networkNoLbl.setForeground(new java.awt.Color(96, 83, 150));
        networkNoLbl.setText("4");

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
                    .addComponent(networkNoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(networkNoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 175, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseNoLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        enterpriseNoLbl.setForeground(new java.awt.Color(96, 83, 150));
        enterpriseNoLbl.setText("3");
        jPanel5.add(enterpriseNoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));

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

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 175, -1, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeesNoLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        employeesNoLbl.setForeground(new java.awt.Color(96, 83, 150));
        employeesNoLbl.setText("1");
        jPanel6.add(employeesNoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 75, -1));

        jPanel12.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(96, 83, 150));
        jLabel20.setText("Total");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 40, 10));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 175, -1, 80));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(96, 83, 150));
        jLabel12.setText("Employees");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 139, 124, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(96, 83, 150));
        jLabel13.setText("Running Networks");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 139, 124, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(96, 83, 150));
        jLabel14.setText("Running Enterprise");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 139, 124, 30));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 413, 270, 10));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(96, 83, 150));
        jLabel4.setText("Network Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 348, -1, -1));

        networkName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        networkName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        networkName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        networkName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                networkNameMouseClicked(evt);
            }
        });
        add(networkName, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 383, 270, 30));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 490, 270, 10));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(96, 83, 150));
        jLabel8.setText("Network Location");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 423, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(96, 83, 150));
        jLabel9.setText("Add New Network?");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 293, 228, 41));
        add(networkLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 448, 270, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        networkEnterpriseTable.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        networkEnterpriseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Name", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        networkEnterpriseTable.setGridColor(new java.awt.Color(247, 247, 247));
        networkEnterpriseTable.setRowHeight(20);
        networkEnterpriseTable.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane1.setViewportView(networkEnterpriseTable);

        addNetworkBtn.setBackground(new java.awt.Color(247, 247, 247));
        addNetworkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/icons8_database_view_48px.png"))); // NOI18N
        addNetworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNetworkBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(addNetworkBtn)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(addNetworkBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 600, 290));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void addNetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNetBtnActionPerformed
        // TODO add your handling code here:
        
        
        String name = networkName.getText();
        
        
        
        String loc = (String)networkLocation.getSelectedItem();
           
          name = name.trim();
       
         if (name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Name is empty");
            return;}
    
        if(this.system.checkIfNetworkLocationUnique(loc))
        {
            Network network = system.createAndAddNetwork();
            network.setName(name);
            network.setLocation(loc);
            populateNetworkTable();
            init();
        }
        else{
            JOptionPane.showMessageDialog(null, "Network for "+loc+ " already present.");
        
        }
        
    }//GEN-LAST:event_addNetBtnActionPerformed

    private void networkNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkNameMouseClicked
        // TODO add your handling code here:
    //    jTextField1.setText("");
    }//GEN-LAST:event_networkNameMouseClicked

    private void addNetworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNetworkBtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = networkEnterpriseTable.getSelectedRow();
        if(selectedRow >= 0)
        {
            Network net = (Network) networkEnterpriseTable.getValueAt(selectedRow, 0);
            
            CardLayout layout = (CardLayout)rightPanel.getLayout();
            rightPanel.add(new CreateEnterprise(rightPanel, net, this.account, this.system));
            layout.next(rightPanel);
    

        }

        
        
        
        
        
        
    }//GEN-LAST:event_addNetworkBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNetBtn;
    private javax.swing.JButton addNetworkBtn;
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel employeesNoLbl;
    private javax.swing.JLabel enterpriseNoLbl;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable networkEnterpriseTable;
    private javax.swing.JComboBox<String> networkLocation;
    private javax.swing.JTextField networkName;
    private javax.swing.JLabel networkNoLbl;
    private javax.swing.JLabel welcomelabel;
    // End of variables declaration//GEN-END:variables
}
