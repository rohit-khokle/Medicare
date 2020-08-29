/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employees.Employee;
import Business.Messages.MessageQueue;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private MessageQueue myMessages;

    public UserAccount() {
        workQueue = new WorkQueue();
        myMessages = new MessageQueue();
    }
    
    
    
    public String getUsername() {
        
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public MessageQueue getMyMessages() {
        return myMessages;
    }

    public void setMyMessages(MessageQueue myMessages) {
        this.myMessages = myMessages;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}
