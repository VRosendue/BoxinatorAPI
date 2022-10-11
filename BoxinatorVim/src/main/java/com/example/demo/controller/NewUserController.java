package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(path = "/test")
public class NewUserController {

	
	private UserService userService;
	
	@Autowired
	public void findAllUsers(UserService userService) {
		this.userService = userService;
	}

	/*
	 * @RequestMapping("/") public String index() { return "start";
	 }*/

	@GetMapping("/newUser")
	public ResponseEntity<Users> findAll() {
		return new ResponseEntity<Users>(HttpStatus.OK);
	}

	@GetMapping("/newAllUsers")
	public ResponseEntity<Set<Users>> getAllUsers() {
		return userService.getAllUsers();
	}

}
