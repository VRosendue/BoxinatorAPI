package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Users;

public interface NewUserService {
	
	Users getById(int user_id);
	List<Users> getUsersByFirstName(String first_name);
	List<Users> getUsersByCountry(String country);
	List<Users> getAllUsers(String Users);

}
