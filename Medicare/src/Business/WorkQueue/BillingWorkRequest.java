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
public class BillingWorkRequest extends WorkRequest {
     private String testResult;
     private String claimReqNo;
     private Patient patient;
     private String typeOfInsurance;
     private String claimedAmount;
     private String claimSantioned;
     private String copay;
     private String testType;//Doctor
     private Enterprise enterprise;

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getClaimedAmount() {
        return claimedAmount;
    }

    public void setClaimedAmount(String claimedAmount) {
        this.claimedAmount = claimedAmount;
    }

    public String getClaimSantioned() {
        return claimSantioned;
    }

    public void setClaimSantioned(String claimSantioned) {
        this.claimSantioned = claimSantioned;
    }

    public String getCopay() {
        return copay;
    }

    public void setCopay(String copay) {
        this.copay = copay;
    }
     
     private static int count = 2000;
      

     
    public BillingWorkRequest() {
        claimReqNo = "CLM"+count;
        count++;
    }


    
   
    
    public String getClaimReqNo() {
        return claimReqNo;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
   
        public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
        @Override
    public String toString() {
        return claimReqNo; //To change body of generated methods, choose Tools | Templates.
    }
}
