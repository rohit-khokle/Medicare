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
public class SentMessages {
    ArrayList<Messages> sentMsgs;

    public SentMessages() {
        this.sentMsgs = new ArrayList<>();
    }

    public ArrayList<Messages> getSentMsgs() {
        return sentMsgs;
    }

    public void setSentMsgs(ArrayList<Messages> sentMsgs) {
        this.sentMsgs = sentMsgs;
    }
    
    
    
    
    
    
}
