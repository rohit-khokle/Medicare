/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Messages;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author rohit
 */
public class Messages {
        UserAccount sender;
        UserAccount reciever;
        String subject;
        String message;
        Date date;

    public Messages(UserAccount sender, UserAccount reciever, String subject, String message, Date date) {
        this.sender = sender;
        this.reciever = reciever;
        this.subject = subject;
        this.message = message;
        this.date = date;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReciever() {
        return reciever;
    }

    public void setReciever(UserAccount reciever) {
        this.reciever = reciever;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "sender=" + sender;
    }
        
}
