package com.demoapp.util;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {
	
	static void sendRegisterOTP(String to, String userName, int OTP) {
		String senderEmail = "test.duck.mail@gmail.com";
		String senderPassword = "yvffdtkjddaaqfbc";
		
		Properties emailProperties = new Properties();
		emailProperties.put("smtp.mail.host", "smtp.gmail.com");
		emailProperties.put("smtp.mail.port", "587");
		emailProperties.put("smtp.mail.auth", "true");
		emailProperties.put("smtp.mail.starttls.enable", "true");
		
		Authenticator emailAuth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		};
		
		Session emailSession = Session.getInstance(emailProperties, emailAuth);
		
		Message emailMsg = new MimeMessage(emailSession);
		try {
			emailMsg.setFrom(new InternetAddress(senderEmail));
			emailMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			emailMsg.setSubject("Welcome Onboard! ❤️");
			emailMsg.setText("Namaskar, "+userName+" 🙏 . \n\n"
							+"Your account has been created successfully. \n\n"
							+"Please use One Time Password (OTP) : " +OTP+". \n\n"
							+"Note : Please do not share this OTP with anyone. \n\n"
							+"If you did not request this OTP, kindly ignore this mail. \n\n"
							+"Best Regards, \n"
							+"Team Sec-B.");
			Transport.send(emailMsg);
			System.out.println("Email sent success");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Email sent failed");
		}
	}

	public static void main(String[] args) {
		int OTP =  (int)(Math.random() * 900000 ) + 100000;
		sendRegisterOTP("piebytwo014@gmail.com", "Rakesh", OTP);
	}

}
