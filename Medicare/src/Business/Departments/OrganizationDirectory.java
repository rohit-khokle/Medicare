/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Departments;

import Business.Departments.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(String name, Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor_Organization.getValue())){
            
            organization = new Hospital_Doctor_Department(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab_Organization.getValue())){
            organization = new Hospital_LabTest_Department(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Insurance_Manager_Organization.getValue())){
            organization = new Insurance_Management_Department(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Claims_Organization.getValue())){
            organization = new Insurance_Claims_Department(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Sales_Organization.getValue())){
            organization = new Insurance_Sales_Department(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Doctor_Assistant_Organization.getValue())){
            organization = new Hospital_DoctorAssistant_Department(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Billing_Organization.getValue())){
            organization = new Hospital_Billing_Department(name);
            organizationList.add(organization);
        }
        return organization;
    }
    
    // Written on 13th April
    public boolean checkIfDepartmentTypePresent(String type){
        for(Organization o : this.organizationList){
            if(o.getOrganizationType().equals(type))   
                 return true;
        }
    return false;
    }
    // Written on 13th April
    public boolean checkIfDepartmentNamePresent(String type){
        for(Organization o : this.organizationList){
            if(o.getName().equalsIgnoreCase(type))   
                 return true;
        }
    return false;
    }
}