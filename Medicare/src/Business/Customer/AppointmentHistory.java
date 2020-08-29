/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author rohit
 */
public class AppointmentHistory {
    ArrayList<Appointment> myAppointmentHistory;

    public AppointmentHistory() {
        
        this.myAppointmentHistory = new ArrayList<Appointment>();
    }

    public ArrayList<Appointment> getMyAppointmentHistory() {
        return myAppointmentHistory;
    }

    public void setMyAppointmentHistory(ArrayList<Appointment> myAppointmentHistory) {
        this.myAppointmentHistory = myAppointmentHistory;
    }
    
    
    
    
}
