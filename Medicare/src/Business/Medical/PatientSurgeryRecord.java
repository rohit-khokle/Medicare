/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medical;

import Business.Customer.*;
import Business.Employees.*;
import java.util.HashMap;


public class PatientSurgeryRecord {
    
    private String patient;
    private String date;
    private int surgeryNumber;
    private String surgeryType;
    private String surgeryStatus;
    private String surgeryNotes;
   
    
    private static int count = 1001;

    public PatientSurgeryRecord() {
        surgeryNumber = count;
        count++;
    }

    

    //@Override
   // public String toString() {
   //     return name;
   // }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSurgeryNumber() {
        return surgeryNumber;
    }

    public void setSurgeryNumber(int surgeryNumber) {
        this.surgeryNumber = surgeryNumber;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public String getSurgeryStatus() {
        return surgeryStatus;
    }

    public void setSurgeryStatus(String surgeryStatus) {
        this.surgeryStatus = surgeryStatus;
    }

    public String getSurgeryNotes() {
        return surgeryNotes;
    }

    public void setSurgeryNotes(String surgeryNotes) {
        this.surgeryNotes = surgeryNotes;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        PatientSurgeryRecord.count = count;
    }

  @Override
   public String toString() {
       return String.valueOf(surgeryNumber);
    }
    
}
