/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.AdminRole;
import Business.Role.InsuranceManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Insurance_Management_Department extends Organization{

    public Insurance_Management_Department(String name) {
        super(name,Type.Insurance_Manager_Organization.getValue());
    }
    /*
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InsuranceManagerRole());
        return roles;
    } */
    @Override
    public Role getSupportedRole() {
        return new InsuranceManagerRole();
    }     
}
