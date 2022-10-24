package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	private final JavaMailSender mailSender;

	public EmailSenderService(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}
	
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		
		this.mailSender.send(simpleMailMessage);
	}
	
	
}