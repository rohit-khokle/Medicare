/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.Patient;
import Business.Enterprises.Enterprise;

/**
 *
 * @author rohit
 */
public class BuyInsuranceWorkRequest extends WorkRequest {
     private String testResult;
     private Enterprise currentEnterprise;
     private String typeOfInsurance;
     private String insReqNo;
     private float premiums;
     private Patient patient;
     private String vitals;

     private static int count = 2000;
      

     public BuyInsuranceWorkRequest() {
        insReqNo = "INS"+count;
        count++;
    }
 

     public String getInsReqNo() {
        return insReqNo;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Enterprise getCurrentEnterprise() {
        return currentEnterprise;
    }

    public void setCurrentEnterprise(Enterprise currentEnterprise) {
        this.currentEnterprise = currentEnterprise;
    }

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public float getPremiums() {
        return premiums;
    }

    public void setPremiums(float premiums) {
        this.premiums = premiums;
    }

    public String getVitals() {
        return vitals;
    }

    public void setVitals(String vitals) {
        this.vitals = vitals;
    }
     
     // Below needs to be changed, file number

     

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    @Override
    public String toString() {
        return insReqNo; //To change body of generated methods, choose Tools | Templates.
    }

   
}
