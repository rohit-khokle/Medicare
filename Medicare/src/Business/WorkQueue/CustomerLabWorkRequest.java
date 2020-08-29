/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

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
public class CustomerLabWorkRequest extends WorkRequest {
     private String testResult;
     private Patient patient;
     private String labReqNo;
     
     
    public CustomerLabWorkRequest(){ 
    labReqNo = "LAB"+count;
        count++;
    }
    public Patient getPatient() {
        return patient;
    }
    
    private static int count = 2000;
      

   
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    private Network networkState;
    private Enterprise hospital;
    private Organization orgRequested;
    private Date appointmentDate;
    

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
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
    
    
    @Override
    public String toString() {
        return labReqNo; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   
}
