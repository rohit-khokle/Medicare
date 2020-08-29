/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employees.*;

/**
 *
 * @author raunak
 */
public class Customer {
    
    private String name;

    private int insuranceFileNumber = 0;

    private int id;
    private static int count = 1;

    public Customer() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
