/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Messages;

import java.util.ArrayList;

/**
 *
 * @author rohit
 */
public class RecievedMessages {
    ArrayList<Messages> recievedMsgsList;

    public RecievedMessages() {
        this.recievedMsgsList = new ArrayList<>();
    }


    public ArrayList<Messages> getRecievedMsgs() {
        return recievedMsgsList;
    }

    public ArrayList<Messages> getRecievedMsgsList() {
        return recievedMsgsList;
    }

    public void setRecievedMsgsList(ArrayList<Messages> recievedMsgsList) {
        this.recievedMsgsList = recievedMsgsList;
    }

    
    
    
}
