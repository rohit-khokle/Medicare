/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Insurance;

import Business.Medical.*;
import Business.Customer.*;
import Business.Departments.Organization;
import Business.Employees.*;
import java.util.ArrayList;
import java.util.Date;




public class MedicalInsurance {
    
    private String Patient;
    private Date startDate;
    private Date endDate;
       private Organization org;
       
           private String InsuranceNumber;

    public String getInsuranceNumber() {
        return InsuranceNumber;
    }
    
    
    private static int count = 100001;

        public MedicalInsurance (){
        InsuranceNumber = "INC"+count;
        count++;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
 

    public String getPatient() {
        return Patient;
    }

    public void setPatient(String Patient) {
        this.Patient = Patient;
    }

 

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }



    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MedicalInsurance.count = count;
    }
    


 
 

   

}