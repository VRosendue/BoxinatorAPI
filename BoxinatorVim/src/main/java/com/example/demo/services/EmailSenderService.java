package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.models.EmailModels;

@Service
public class EmailSenderService {
	
	private final JavaMailSender mailSender;

	public EmailSenderService(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}
	
	public void sendEmail(EmailModels mail) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("");
		simpleMailMessage.setTo(mail.getTo());
		simpleMailMessage.setSubject(mail.getSubject());
		simpleMailMessage.setText(mail.getMessage());
		
		this.mailSender.send(simpleMailMessage);
	}
	
	
}
