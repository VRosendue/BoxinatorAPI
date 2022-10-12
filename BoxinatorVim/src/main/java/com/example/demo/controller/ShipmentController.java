package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Shipments;
import com.example.demo.repository.ShipmentRepository;

import com.example.demo.services.ShipmentService;

import static com.example.demo.controller.ControllerHelper.BASE_URI_V1;



@RestController
@RequestMapping(path = BASE_URI_V1 + "Shipments")
public class ShipmentController {


	@Autowired
	private ShipmentService shipmentService;

	@GetMapping
	public ResponseEntity<List<Shipments>> getAllShipments() {
		return shipmentService.getAllShipments();
	}
	
	@GetMapping("/{ShipmentId}")
	public ResponseEntity<Shipments> getShipmentById(@PathVariable long shipmentId) {
		return shipmentService.getShipmentById(shipmentId);
	}

	@PostMapping
	public ResponseEntity<Shipments> createShipment(@RequestBody Shipments newShipment){
		return shipmentService.createShipment(newShipment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Shipments> deleteShipment(@PathVariable(value="id")Long id){
		return shipmentService.deleteShipment(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Shipments>updateShipment(@PathVariable(value="id")Long id, @Validated @RequestBody Shipments newShipment){
		return shipmentService.updateShipment(newShipment, id);
	}
	

}
