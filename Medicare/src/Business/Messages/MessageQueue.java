/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Messages;

/**
 *
 * @author rohit
 */
public class MessageQueue {
    RecievedMessages recievedMsgsList;
    SentMessages sentMsgsList;

    public MessageQueue() {
        recievedMsgsList = new RecievedMessages();
        sentMsgsList = new SentMessages();
        
    }

    public RecievedMessages getRecievedMsgsList() {
        return recievedMsgsList;
    }

    public void setRecievedMsgsList(RecievedMessages recievedMsgsList) {
        this.recievedMsgsList = recievedMsgsList;
    }

    public SentMessages getSentMsgsList() {
        return sentMsgsList;
    }

    public void setSentMsgsList(SentMessages sentMsgsList) {
        this.sentMsgsList = sentMsgsList;
    }
    
    
    
    
    
    
}
