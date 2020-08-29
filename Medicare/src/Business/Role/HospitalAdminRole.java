/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Database.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprises.Enterprise;
import Business.Departments.Organization;
import Business.UserAccount.UserAccount;
import UI_Pages.adminPages.Admin_WorkSpace;
import UI_Pages.adminPages.Hospital_Admin_WorkSpace;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class HospitalAdminRole extends Role{

    @Override
    public JFrame createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,DB4OUtil dB4OUtil) {
     //   return new Admin_WorkSpace(userProcessContainer, enterprise);
                return new Hospital_Admin_WorkSpace(userProcessContainer,  account,enterprise, business, dB4OUtil);
    }

    
    
}
