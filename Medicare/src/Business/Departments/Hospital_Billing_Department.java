/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.DoctorRole;
import Business.Role.HospitalBillingRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Hospital_Billing_Department extends Organization{

    public Hospital_Billing_Department(String name) {
        super(name,Organization.Type.Billing_Organization.getValue());
    }
    /*
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HospitalBillingRole());
        return roles;
    }
     */
    @Override
    public Role getSupportedRole() {
        return new HospitalBillingRole();
       
    }      
    
    
     
}