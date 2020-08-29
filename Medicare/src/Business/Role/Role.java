/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Database.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprises.Enterprise;
import Business.Departments.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),

        LabAssistant("Lab Assistant"),
        DoctorAssistant("Doctor Assistant"),
        BillingAccountant("Billing Accountant"),


        
        InsuranceManager("Insurance Manager"),
        InsuranceSales("Insurance Sales"),
        InsuranceClaims("Insurance Claims");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JFrame createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business
            ,DB4OUtil dB4OUtil);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}