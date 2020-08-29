package Business;

import Business.Employees.Employee;
import Business.Enterprises.Enterprise;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/*
import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
*/
/**
 *
 * @author Rohit
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
          
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin"); // getEmployeeDirectory().createEmployee("RRH");
        employee.setProfilePicture("Jon_Snow");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        employee = system.getEmployeeDirectory().createEmployee("Anthony"); // getEmployeeDirectory().createEmployee("RRH");
        employee.setProfilePicture("Anthony");
        ua = system.getUserAccountDirectory().createUserAccount("anthony", "anthony", employee, new SystemAdminRole());
                
        
        employee = system.getEmployeeDirectory().createEmployee("Amar"); // getEmployeeDirectory().createEmployee("RRH");
        employee.setProfilePicture("Amar");
        ua = system.getUserAccountDirectory().createUserAccount("amar", "amar", employee, new SystemAdminRole());
                


        employee = system.getEmployeeDirectory().createEmployee("Akbar"); // getEmployeeDirectory().createEmployee("RRH");
        employee.setProfilePicture("Akbar");
        ua = system.getUserAccountDirectory().createUserAccount("akbar", "akbar", employee, new SystemAdminRole());
                
        
        
        return system;
    
    
    }
    
}
