/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Role.AdminRole;
import Business.Role.Role;
import Business.Role.SalesRepresentativeRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Insurance_Sales_Department extends Organization{

    public Insurance_Sales_Department(String name) {
        super(name,Type.Sales_Organization.getValue());
    }
    
    @Override
    public Role getSupportedRole() {
        return new SalesRepresentativeRole();
    }
     
}
