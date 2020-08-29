/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
/*
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
*/

import Business.Customer.Patient;
import Business.Customer.PatientDirectory;
import Business.Departments.Organization;
import Business.Network.Network;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Rohit
 */
public class EcoSystem  extends Organization
{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    
    
    // New changes
    private  PatientDirectory patientDirectory;   // customerDirectory

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    
    
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    } 
    /*
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }  */
    @Override
    public Role getSupportedRole() {
        return new SystemAdminRole();
    } 



    private EcoSystem(){
        super(null, null);
        networkList=new ArrayList<Network>();
        patientDirectory = new PatientDirectory();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    // For employee user check
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }
    
    // For Network present for same location
    public boolean checkIfNetworkLocationUnique(String location){
        for(Network n : this.networkList){
           if(n.getLocation().equals(location))
               return false;        
        }
        return true;
    }
    
    
}
