/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Hospital_Doctor_Department extends Organization{

    public Hospital_Doctor_Department(String name) {
        super(name,Organization.Type.Doctor_Organization.getValue());
    }
/*    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        return roles;
    } 
*/
    @Override
    public Role getSupportedRole() {
        return new DoctorRole();
    } 
    
    
}