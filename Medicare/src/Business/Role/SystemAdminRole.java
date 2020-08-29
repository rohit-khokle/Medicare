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
import UI_Pages.adminPages.SysAdmin_WorkSpace;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class SystemAdminRole extends Role{

    @Override
    public JFrame createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil dB4OUtil){
        
        
        return new SysAdmin_WorkSpace( userProcessContainer,  account,  system,  dB4OUtil );
    
    
    
    }
    
}
