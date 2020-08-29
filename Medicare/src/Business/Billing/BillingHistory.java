/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Billing;

import java.util.ArrayList;

/**
 *
 * @author Sudhanshu Gangele
 */
public class BillingHistory {

     private ArrayList<Bill> billingHistory;   
    
    public BillingHistory() {
        this.billingHistory = new ArrayList<>();
    }
    


    public ArrayList<Bill> getBillingHistory() {
        return billingHistory;
    }

    public void setBillingHistory(ArrayList<Bill> billingHistory) {
        this.billingHistory = billingHistory;
    }
    
        
     public Bill createNewBill(){
        Bill patDocRec = new Bill();
        billingHistory.add(patDocRec);
        return patDocRec;
    }
    
//    public ArrayList<Bill> getPaidBills(){
//    
//        return 
//    }
//    
        public   ArrayList<Bill> getUnpaidBills(){
                ArrayList<Bill> bills = new ArrayList<>();
        return bills;
    }
}
