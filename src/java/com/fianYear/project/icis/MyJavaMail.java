/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Abdoulr
 */
public class MyJavaMail {

    public static void main(String[] args) {
        String to = "abdoulr29@gmail.com";
        String from = "abdoulr29@gmail.com";
        String host = "localhost";
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(prop);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress());
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("this my subject");
            message.setText("unidentified flying objects");
            Transport.send(message);
            System.out.println("message sent successfuly");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
