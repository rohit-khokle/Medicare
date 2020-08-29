/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Employees.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    

    // 13th
    private String organizationType;

    public String getOrganizationType() {
        return organizationType;
    }
    
    public enum Type{
        Admin_Organization("Admin Organization"), 
        
        Doctor_Organization("Doctor Organization"), 
        Lab_Organization("Lab Organization"),
        Doctor_Assistant_Organization("DA Organization"), 
        Billing_Organization("Hospital Billing Organization"), 
        
        Insurance_Manager_Organization("Insurance Manager Organization"), 
        Claims_Organization("Claims  Organization"),        
        Sales_Organization("Sales Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value; //To change body of generated methods, choose Tools | Templates.
        }
        
        
    }

    public Organization(String name, String type) {
        this.name = name;
        this.organizationType = type;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

 //   public abstract ArrayList<Role> getSupportedRole();
      public abstract Role getSupportedRole();
    
    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    
    @Override
    public String toString() {
        return name;
    }
    
    
}
