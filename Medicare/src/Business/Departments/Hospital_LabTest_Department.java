/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Hospital_LabTest_Department extends Organization{

    public Hospital_LabTest_Department(String name) {
        super(name, Organization.Type.Lab_Organization.getValue());
    }
/*
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabAssistantRole());
        return roles;
    }
*/     
    @Override
    public Role getSupportedRole() {
        return new LabAssistantRole();
    }
   
    
    
}
