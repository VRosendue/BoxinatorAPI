package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Shipments;
import com.example.demo.models.Users;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.UserRepository;


@RestController
@RequestMapping(path = "/api/v1/")
public class ShipmentController {
		
		@Autowired
		private ShipmentRepository shipmentRepository;
		
		@GetMapping("shipments")
		public List<Shipments> getAllShipments() {
			return this.shipmentRepository.findAll();
		}
		
		
	}


