/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;
    

    public EmployeeDirectory() {
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
//  Created for Populating doc specialization in combobox Specialist type in Book an Appointment
    
    //private ArrayList<Employee.DocType> docSpecializationList;
    
//  Created for Populating doc specialization in combobox Specialist type in Book an Appointment
    
    public List<String> getDocLabSpecializationList() {
         List<String> values = Employee.DocType.getValues();
         return values;
    }    
    
    
}