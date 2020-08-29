/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employees.*;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class CustomerDirectory {
    
    private ArrayList<Employee> employeeList;

    public CustomerDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
}