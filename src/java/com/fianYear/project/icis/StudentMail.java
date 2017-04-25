package com.fianYear.project.icis;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Abdoulr
 */
public class StudentMail  {

     public static void main(String[] args) {

        final String username = "abdoulr29@gmail.com";
        final String password = "Abdoulr!@#";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("abdoul.Ruhr@outlook.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("abdoul.Ruhr@outlook.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"+ "\n\n No spam to my email, please!");
                

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
