package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Shipments;
import com.example.demo.models.Users;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import static com.example.demo.controller.ControllerHelper.BASE_URI_V1;


@RestController
@RequestMapping(path = BASE_URI_V1 + "Users")
public class UsersController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	/*
	 * @GetMapping("AllUsers2") public List<User> getAllUsers2(){ return
	 * (List<User>) this.userRepo.findAll(); }
	 */

	@GetMapping("/{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping()
	public ResponseEntity<List<Users>> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping()
	public ResponseEntity<Users> addUser(@RequestBody Users newUser) {
		return userService.createUser(newUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable(value="id")Long id){
		return userService.deleteUser(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Users>updateUser(@PathVariable(value="id")Long id, @Validated @RequestBody Users newUser){
		return userService.updateUser(newUser, id);
	}
}

/*
 * @GetMapping("/hello") // GET: localhost:8080/api/v1/test/1 public
 * ResponseEntity<String> path(@RequestParam String first_name) { return
 * ResponseEntity.ok().body(String.valueOf(first_name)); }
 * 
 * // Extracting a query string
 * 
 * @GetMapping // GET: localhost:8080/api/v1/test?key=value public
 * ResponseEntity<String> query(@RequestParam String first_name) { return
 * ResponseEntity.ok().body(first_name); }
 * 
 * // Extracts the User-Agent header
 * 
 * @GetMapping("header") // GET: localhost:8080/api/v1/header public
 * ResponseEntity<String> headers(@RequestHeader("User-Agent") String agent) {
 * return ResponseEntity.ok().body(agent); }
 * 
 * // Extracts the body
 * 
 * @GetMapping("body") // GET: localhost:8080/api/v1/body public
 * ResponseEntity<String> body(@RequestBody String value) { return
 * ResponseEntity.ok().body(value); } }
 */
