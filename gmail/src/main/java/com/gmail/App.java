package com.gmail;


import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "preparing to send message" );
        Scanner scan = new Scanner(System.in);
        System.out.println( "Enter Message : " );
        String message=scan.nextLine();
        String subject = "CodersArea : Configuration";
        System.out.println( "Enter Recipient Email : " );
        String to=scan.nextLine();
        String from = "pankaj.11806946@gmail.com";
        
        sendEmail(message,subject,to,from);
    }

	private static void sendEmail(String message, String subject, String to, String from) {
		
		String host="smtp.gmail.com";
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" +properties);
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		Session session = Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("pankaj.11806946@gmail.com","*******");
			}
			
		});
		
		session.setDebug(true);
		
		
		MimeMessage m = new MimeMessage(session);
		try {
		m.setFrom(from);
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		m.setSubject(subject);
		m.setText(message);
		
		
		Transport.send(m);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
