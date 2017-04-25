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
public class Tester {

    public static void main(String[] args) {
        String to = "";
        String from = "";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("this is my announcement to all students");
            message.setText("this is me writting my first java mail class Bitches!!");
            Transport.send(message);
            System.out.println("message sent!!");
            
        } catch (MessagingException mess) {
            mess.printStackTrace();
        }

    }

}
