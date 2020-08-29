/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employees;

import Business.Departments.Organization;
import Business.Enterprises.Enterprise;
import Business.Medical.DoctorSchedule;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;
    private int id;
    private static int count = 1;
    private String profilePicture;
    private Image picture;
    private Enterprise enterprise;
    private Organization org;
    

    public Employee() {
        id = count;
        count++;
        this.ds = new ArrayList<>();
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
   
    public String getProfilePicture() {
        if(this.profilePicture == null)
                return "";
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }
 //   //Below variables added for new customer role
    private String userId;
    private String dob;
    private String insDetail;
    private String mobno;
    private String emerName;
    private String emerMobile;
    private String primDoc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getInsDetail() {
        return insDetail;
    }

    public void setInsDetail(String insDetail) {
        this.insDetail = insDetail;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public String getEmerName() {
        return emerName;
    }

    public void setEmerName(String emerName) {
        this.emerName = emerName;
    }

    public String getEmerMobile() {
        return emerMobile;
    }

    public void setEmerMobile(String emerMobile) {
        this.emerMobile = emerMobile;
    }

    public String getPrimDoc() {
        return primDoc;
    }

    public void setPrimDoc(String primDoc) {
        this.primDoc = primDoc;
    }

   //below is included for doctors type.
    
    private String docSpeciality;

    public String getDocSpeciality() {
         return docSpeciality;
    }

    public void setDocSpeciality(Employee.DocType docType ) {
        this.docSpeciality = docType.getValue();
    }
    
    public enum DocType{
        PrimaryPhysician("Primary Physician"), 
        
        Cardiologist("Cardiologist"), 
        Rheumatologist("Rheumatologist"),
        Surgeon("General Surgeon"), 
        
        Psychiatrist("Psychiatrist"), 
        Dermatologist("Dermatologist"),        
        Neurologist("Neurologist");
        
        private String value;
        private DocType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
		
		
		private static final List<String> VALUES;
		
		static {
        VALUES = new ArrayList<>();
        for (DocType docType : DocType.values()) {
            VALUES.add(docType.value);
			}
		}
		
		public static List<String> getValues() {
        return Collections.unmodifiableList(VALUES);
		}
    }
        
        
        // only for Doctors and lab START
    
    ArrayList<DoctorSchedule> ds;

    public ArrayList<DoctorSchedule> getDs() {
        return ds;
    }

    public void setDs() {
        this.ds = new ArrayList<>();
    }
    
    public boolean checkScheduleAvailability(DoctorSchedule checkDS){
        for(DoctorSchedule check : ds){
           if((checkDS.getDate().compareTo(check.getDate()) == 0) &&(checkDS.getTime().equals(check.getTime())) ){
                    System.out.println("Date compared");
                    return false;            
            }
        }
        return true;
    }    
    
        // only for Doctors and lab END        
        
        
}
    

