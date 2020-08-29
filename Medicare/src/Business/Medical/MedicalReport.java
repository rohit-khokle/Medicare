/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medical;

import Business.Customer.*;
import Business.Employees.*;
import java.util.Date;
import java.util.HashMap;


public class MedicalReport {
    
    private String Patient;
    private Date Date;
    private int TestNumber;
    HashMap<String, String> testParameters;
    
    private static int count = 1001;

    public MedicalReport() {
        TestNumber = count;
        count++;
    }

    

    //@Override
   // public String toString() {
   //     return name;
   // }

    public String getPatient() {
        return Patient;
    }

    public void setPatient(String Patient) {
        this.Patient = Patient;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getTestNumber() {
        return TestNumber;
    }

    public void setTestNumber(int TestNumber) {
        this.TestNumber = TestNumber;
    }

    public HashMap<String, String> getTestParameters() {
        return testParameters;
    }

    public void setTestParameters(HashMap<String, String> testParameters) {
        this.testParameters = testParameters;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MedicalReport.count = count;
    }
    
    @Override
    public String toString() {
        return String.valueOf(TestNumber); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
