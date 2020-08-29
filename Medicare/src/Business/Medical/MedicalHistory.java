/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medical;

import Business.Customer.*;
import Business.Employees.*;
import java.util.ArrayList;




public class MedicalHistory {
    
    private String Patient;
    
    private ArrayList<MedicalReport> medReportDir;
    private ArrayList<PatientDocRecord> patientDocDir;
    private ArrayList<PatientSurgeryRecord> patientSurgeryDir;

    public MedicalHistory() {
        medReportDir = new ArrayList();
        patientDocDir = new ArrayList();
        patientSurgeryDir = new ArrayList();
        
    }

    public String getPatient() {
        return Patient;
    }

    public void setPatient(String Patient) {
        this.Patient = Patient;
    }

    public ArrayList<MedicalReport> getMedReportDir() {
        return medReportDir;
    }

    public void setMedReportDir(ArrayList<MedicalReport> medReportDir) {
        this.medReportDir = medReportDir;
    }

    public ArrayList<PatientDocRecord> getPatientDocDir() {
        return patientDocDir;
    }

    public void setPatientDocDir(ArrayList<PatientDocRecord> patientDocDir) {
        this.patientDocDir = patientDocDir;
    }

    public ArrayList<PatientSurgeryRecord> getPatientSurgeryDir() {
        return patientSurgeryDir;
    }

    public void setPatientSurgeryDir(ArrayList<PatientSurgeryRecord> patientSurgeryDir) {
        this.patientSurgeryDir = patientSurgeryDir;
    }
  
    
    public MedicalReport createMedReport(){
        MedicalReport medRep = new MedicalReport();
        medReportDir.add(medRep);
      
        return medRep;
    }
    
     public PatientDocRecord createPatientDoc(){
        PatientDocRecord patDocRec = new PatientDocRecord();
        patientDocDir.add(patDocRec);
      
        return patDocRec;
    }
     
      public PatientSurgeryRecord createPatSurgRec(){
        PatientSurgeryRecord patSurgRec = new PatientSurgeryRecord();
        patientSurgeryDir.add(patSurgRec);
      
        return patSurgRec;
    }

}