/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.DoctorAssistantRole;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Hospital_DoctorAssistant_Department extends Organization{

    public Hospital_DoctorAssistant_Department(String name) {
        super(name,Organization.Type.Doctor_Assistant_Organization.getValue());
    }
/*
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorAssistantRole());
        return roles;
    }
  */   
    @Override
    public Role getSupportedRole() {
        return new DoctorAssistantRole();
         
    }   
    
    
}
