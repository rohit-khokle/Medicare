/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Billing;

import Business.Customer.Appointment;
import Business.Enterprises.Enterprise;

/**
 *
 * @author Sudhanshu Gangele
 */
public class Bill {
    
    private Appointment appointment;
    private boolean insurancePresent;
    private double paidThroughInsurance;
    private double paidThroughSelf;
    private String billStatus;
    private String billNo;
    private String testType;//Doctor
    private String billAmount;

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }
    private Enterprise enterprise; //insurance or hospital
    private String billType; //claim or self



    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return billNo; //To change body of generated methods, choose Tools | Templates.
    }
    
    private static int count = 100;
      public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
}

     public Bill() {
         
        this.billNo = "Bill "+count;
        count++;
    }
    
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public boolean isInsurancePresent() {
        return insurancePresent;
    }

    public void setInsurancePresent(boolean insurancePresent) {
        this.insurancePresent = insurancePresent;
    }

    public double getPaidThroughInsurance() {
        return paidThroughInsurance;
    }

    public void setPaidThroughInsurance(double paidThroughInsurance) {
        this.paidThroughInsurance = paidThroughInsurance;
    }

    public double getPaidThroughSelf() {
        return paidThroughSelf;
    }

    public void setPaidThroughSelf(double paidThroughSelf) {
        this.paidThroughSelf = paidThroughSelf;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
    
    
    
}
