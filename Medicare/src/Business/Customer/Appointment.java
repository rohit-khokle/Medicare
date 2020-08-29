/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Medical.*;
import Business.Customer.Patient;
import Business.Employees.Employee;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author rohit
 */
public class Appointment {
    Date date;
    String time;
    Employee doctor;
    String docType;
    String status;
    String appointmentType;

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
    
    
    public Appointment(Date date,
    String time,
    Employee doctor,
    String docType,
    String status,
   String appType
    ){
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.docType = docType;
        this.status = status;
        this.appointmentType  = appType;
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

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "DoctorSchedule{" + "date=" + date + ", time=" + time + '}';
    }

}