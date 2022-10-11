package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Users;


@Service
public class NewUserServiceImpl implements NewUserService {

	@Override
	public Users getById(int user_id) {
		
	return null;
	}

	@Override
	public List<Users> getUsersByFirstName(String first_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getUsersByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAllUsers(String Users) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private List<Users> getUsersList() {
		return null;
	}

}
