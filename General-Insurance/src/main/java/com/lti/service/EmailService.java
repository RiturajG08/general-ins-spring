package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	 @Autowired
	    private MailSender mailSender;
	    public void sendEmailForNewRegistration(String email,String text,String subject) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("harshitsingh0608@gmail.com");
	        message.setTo(email);
	        message.setSubject(subject);
	        message.setText(text);
	        mailSender.send(message);
}
}
