/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medical;

import Business.Customer.*;
import Business.Employees.*;
import java.util.HashMap;


public class PatientDocRecord {
    
    private Patient patient;
    private String date;
    private int patientDocNumber;
    private String diagnosis;
    private String prescription;
    private StringBuilder labTests;
    private Appointment apt;
    private String status;

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    
    
    private static int count = 1001;

    public PatientDocRecord() {
        patientDocNumber = count;
        count++;
    }

    

    //@Override
   // public String toString() {
   //     return name;
   // }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPatientDocNumber() {
        return patientDocNumber;
    }

    public void setPatientDocNumber(int patientDocNumber) {
        this.patientDocNumber = patientDocNumber;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        PatientDocRecord.count = count;
    }

    public Appointment getApt() {
        return apt;
    }

    public void setApt(Appointment apt) {
        this.apt = apt;
    }

    public StringBuilder getLabTests() {
        return labTests;
    }

    public void setLabTests(StringBuilder labTests) {
        this.labTests = labTests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
     @Override
   public String toString() {
       return String.valueOf(patientDocNumber);
    }
    
}
