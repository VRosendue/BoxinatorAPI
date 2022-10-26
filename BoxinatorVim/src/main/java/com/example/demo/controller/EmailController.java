package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmailModels;
import com.example.demo.services.EmailSenderService;

import static com.example.demo.controller.ControllerHelper.BASE_URI_V1;

@RestController
public class EmailController {

	@Autowired
	private EmailSenderService emailService;

	@PostMapping("/Email")
	public ResponseEntity<String> sendEmail(@RequestBody EmailModels emailMessage) {
		this.emailService.sendEmail(emailMessage);
		return ResponseEntity.ok("Email Sent");
	}
}
