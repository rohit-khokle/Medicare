/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprises.Enterprise;
import Business.Enterprises.EnterpriseDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author MyPC1
 */
public class Network {
    private String name;
    private String location;
    private EnterpriseDirectory enterpriseDirectory;
    private WorkQueue workQueue;

    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
        workQueue = new WorkQueue();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    
    public boolean checkEnterpriseNameUnique(String name){
        for(Enterprise e: this.enterpriseDirectory.getEnterpriseList()){
            if(e.getName().equals(name)){
                return false;
            }
        }
        return true; 
    }
    
}
