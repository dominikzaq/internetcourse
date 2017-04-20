package com.pkproject.internetcourse.application.mail;

import com.pkproject.internetcourse.application.controller.mail.MessageController;

import java.util.ArrayList;

/**
 * Created by dominikzaq on 14.01.2017.
 */
public class Mail {
    private String subject;
    private String textMessage;
    private String email;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
