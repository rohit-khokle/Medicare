/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.AdminRole;
import Business.Role.ClaimsRepresentativeRole;
import Business.Role.Role;
import Business.Role.SalesRepresentativeRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Insurance_Claims_Department extends Organization{

    public Insurance_Claims_Department(String name) {
        super(name,Type.Claims_Organization.getValue());
    }
  /*  
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SalesRepresentativeRole());
        return roles;
    }
*/
    
    @Override
    public Role getSupportedRole() {
        return new ClaimsRepresentativeRole();
    }

}
