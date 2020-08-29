/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.Appointment;
import Business.Customer.Patient;
import Business.Departments.Organization;
import Business.Employees.Employee;
import Business.Enterprises.Enterprise;
import Business.Network.Network;
import java.util.Date;

/**
 *
 * @author rohit
 */
public class CustomerDoctorWorkRequest extends WorkRequest {
     private String testResult;
     private Patient patient;
     private Employee receivingDoctor;
//     private Date appointmentDate;
     private Appointment appointment;
     private String timeOfAppointment;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setTimeOfAppointment(String timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }


    public Employee getReceivingDoctor() {
        return receivingDoctor;
    }

    public void setReceivingDoctor(Employee receivingDoctor) {
        this.receivingDoctor = receivingDoctor;
    }


    private Network networkState;
    private Enterprise hospital;
    private Organization orgRequested;
    
     private String specialistType;
    private String WorkRequestType;
    
    private String  RefBy;


     
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Network getNetworkState() {
        return networkState;
    }

    public void setNetworkState(Network networkState) {
        this.networkState = networkState;
    }

    public Enterprise getHospital() {
        return hospital;
    }

    public void setHospital(Enterprise hospital) {
        this.hospital = hospital;
    }

    public Organization getOrgRequested() {
        return orgRequested;
    }

    public void setOrgRequested(Organization orgRequested) {
        this.orgRequested = orgRequested;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }

    public String getWorkRequestType() {
        return WorkRequestType;
    }

    public void setWorkRequestType(String WorkRequestType) {
        this.WorkRequestType = WorkRequestType;
    }

    public String getRefBy() {
        return RefBy;
    }

    public void setRefBy(String RefBy) {
        this.RefBy = RefBy;
    }

    public String getTimeOfAppointment() {
        return timeOfAppointment;
    }

    @Override
    public String toString() {
        return patient.getfName() + " " +patient.getLastName();
    }
   
    
    
}
