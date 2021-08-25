package com.home.user.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.user.beans.Plans;
import com.home.user.service.PlansService;

@RestController
@RequestMapping("/plans")
@CrossOrigin(origins = "*")
public class PlansController {

	@Autowired
	private PlansService service;

	// ----- FIND ALL --------
	@GetMapping(value = "/plan")
	public ResponseEntity<List<Plans>> findAllPhoneInfo() {
		return new ResponseEntity<>(service.findAllPlans(), HttpStatus.OK);
	}

	// ------- ADD PLAN -----
	@PostMapping(value = "/plan")
	public ResponseEntity<Plans> save(@RequestBody @Valid Plans plan) {
		return new ResponseEntity<>(service.save(plan), HttpStatus.CREATED);
	}

	// ------ FIND BY ID -----
	@GetMapping("/plan/{id}")
	public ResponseEntity<Plans> findById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);

	}

	// ------ DELETE BY ID -----
	@DeleteMapping("/plan/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
		service.deletePhoneInfoById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// -------- UPDATE BY ID -----------
	@PutMapping(value = "/plan/{id}")
	public ResponseEntity<Void> updateById(@RequestBody Plans plans, @PathVariable("id") Integer id) {

		service.updateById(plans, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}



/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
