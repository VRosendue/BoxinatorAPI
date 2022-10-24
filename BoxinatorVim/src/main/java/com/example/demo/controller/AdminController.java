package com.example.demo.controller;

import static com.example.demo.controller.ControllerHelper.BASE_URI_V1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;
import com.example.demo.models.Shipments;
import com.example.demo.models.Users;
import com.example.demo.services.CountryService;
import com.example.demo.services.ShipmentService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(path = BASE_URI_V1 + "Admin")
public class AdminController {
	
	@Autowired
	private ShipmentService shipmentService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	UserService userService;
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole(ADMIN)")
	public ResponseEntity<Shipments> deleteShipment(@PathVariable(value="id")Long id){
		return shipmentService.deleteShipment(id);
		}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole(ADMIN)")
	public ResponseEntity<Country> deleteCountry(@PathVariable(value="id")Long id){
		return countryService.deleteCountry(id);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole(ADMIN)")
	public ResponseEntity<Users> deleteUser(@PathVariable(value="id")Long id){
		return userService.deleteUser(id);
	}
	
	
	

}
