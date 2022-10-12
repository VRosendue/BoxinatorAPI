package com.example.demo.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity <Set<Users>> getAllUsers(){
        Set<Users> returnUser = null;
        HttpStatus httpStatus = null;

        try {
            returnUser = (Set<Users>) userRepository.findAll();
            if (returnUser.isEmpty()) {
                httpStatus = HttpStatus.NOT_FOUND;
            }else {
                httpStatus = HttpStatus.OK;
            }
        } catch (Exception e) {
            System.out.println("The house is on fire...");
            System.out.println(e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(returnUser, httpStatus);
    }

}
