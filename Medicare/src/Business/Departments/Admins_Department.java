/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Admins_Department extends Organization{

    public Admins_Department(String name) {
        super(name,Type.Admin_Organization.getValue());
    }
    /*
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AdminRole());
        return roles;
    } */
    @Override
    public Role getSupportedRole() {
        return new AdminRole();
       
    }      
}
