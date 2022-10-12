package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;
import com.example.demo.repository.CountryRepository;

@RestController
@RequestMapping(path = "/api/v1/")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping("country")
	public List<Country> getAllList() {
		return this.countryRepository.findAll();

	}
}
