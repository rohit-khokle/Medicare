/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medical;

import Business.Customer.Patient;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author rohit
 */
public class DoctorSchedule {
    Date date;
    String time;
    Patient patient;

    public DoctorSchedule(Date date,String timeOfAppointment, Patient patient){
        this.date = date;
        this.time = timeOfAppointment;
        this.patient = patient;
    }
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "DoctorSchedule{" + "date=" + date + ", time=" + time + '}';
    }

}