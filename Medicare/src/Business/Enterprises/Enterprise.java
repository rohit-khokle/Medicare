 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprises;

import Business.Departments.Organization;
import Business.Departments.OrganizationDirectory;

/**
 *
 * @author MyPC1
 */
public abstract class Enterprise extends Organization{
    
    private String name;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private static int enterpriseCount = 0;
    private static int organizationCount = 0;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
//    private String enterpriseType;


  
    public enum EnterpriseType{
        
        Hospital("Hospital"), Insurance("Insurance"), Sysadmin("Sysadmin");
       
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
            return value;
    }
    } 
    

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    public Enterprise(String name,EnterpriseType type){
        
        super(name, type.Sysadmin.getValue());
        this.name = name;
        enterpriseCount++;
        this.enterpriseType=type;
        organizationDirectory=new OrganizationDirectory();
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
    
    
}
