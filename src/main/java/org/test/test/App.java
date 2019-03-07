package org.test.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws AddressException, MessagingException
    {
    	Properties prop = new Properties();
    	prop.put("mail.smtp.auth", "true");
    	prop.put("mail.smtp.starttls.enable", "true");
    	prop.put("mail.smtp.host", "smtp.gmail.com");
    	prop.put("mail.smtp.port", "587");
    	prop.put("mail.smtp.user", "mohamedelhadiboussada@gmail.com");
        prop.put("mail.smtp.password", "rOu7daydo2018");
        
        Session session = Session.getDefaultInstance(prop);
        MimeMessage message = new MimeMessage(session);
        
        message.setFrom(new InternetAddress("mohamedelhadiboussada@gmail.com"));
        
        InternetAddress toAddress = new InternetAddress("biservices010@gmail.com");
        message.addRecipient(Message.RecipientType.TO, toAddress);
        
        message.setSubject("mail test");
        message.setText("mail test body");
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", "mohamedelhadiboussada@gmail.com", "rOu7daydo2018");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println( "Hello World!" );
    }
}
