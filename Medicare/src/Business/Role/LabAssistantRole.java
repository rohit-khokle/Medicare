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
import UI_Pages.hospitalEnterprise.LabAssistant.LabAssistant_WorkSpace;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class LabAssistantRole extends Role {

    @Override
    public JFrame createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,DB4OUtil dB4OUtil) {
    //    return new LabAssistantWorkAreaJPanel(userProcessContainer, account, organization, business);
    
        return new LabAssistant_WorkSpace(userProcessContainer,account,organization,enterprise,business,dB4OUtil);

    }
    
}
