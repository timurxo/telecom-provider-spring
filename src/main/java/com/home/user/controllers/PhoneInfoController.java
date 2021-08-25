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

import com.home.user.beans.PhoneInfo;
import com.home.user.service.PhoneInfoService;

// , produces = MediaType.APPLICATION_JSON_VALUE

@RestController
@RequestMapping("/phoneInfo")
@CrossOrigin(origins = "*")
public class PhoneInfoController {

	// phone info
	@Autowired
	private PhoneInfoService service;

	// ----- FIND ALL --------
	@GetMapping(value = "/phone_info")
	public ResponseEntity<List<PhoneInfo>> findAllPhoneInfo() {
		return new ResponseEntity<>(service.findAllPhoneInfo(), HttpStatus.OK);
	}

	// ------ FIND BY ID -----
	@GetMapping("/phone_info/{id}")
	public ResponseEntity<PhoneInfo> findById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);

	}

	// ------ DELETE BY ID -----
	@DeleteMapping("/phone_info/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
		service.deletePhoneInfoById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// ------- ADD PHONE INFO -----
	@PostMapping(value = "/phone_info")
	public ResponseEntity<PhoneInfo> save(@RequestBody @Valid PhoneInfo phoneInfo) {
		return new ResponseEntity<>(service.save(phoneInfo), HttpStatus.CREATED);
	}
	
	

	// -------- UPDATE BY ID -----------
	@PutMapping(value = "/phone_info/{id}")
	public ResponseEntity<Void> updateById(@RequestBody PhoneInfo phoneInfo, @PathVariable("id") Integer id) {

		service.updateById(phoneInfo, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

	
	
	
	// ------- GET NUMBER OF DEVICES FOR EVERY USER ID------
	@GetMapping("/phone_info/numOfDevices/{id}")
	public ResponseEntity<Integer> getNumOfDevicesByUserId(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(service.getNumberOfDevicesByUserId(id), HttpStatus.OK);

	}
	
	// ------- GET NUMBER OF DEVICES FOR EACH PLAN------ 
	@GetMapping("/phone_info/numOfDevicesForEachPlan/{user_id}/{plan_id}")
	public ResponseEntity<Integer> getNumOfDevicesForEachPlan(@PathVariable("user_id") Integer user_id, @PathVariable("plan_id") Integer plan_id) {
		return new ResponseEntity<>(service.getNumberOfDevicesForEachPlan(user_id, plan_id), HttpStatus.OK);

	}

	
	// ------- GET TOTAL PRICE ------
	@GetMapping("/phone_info/totalPrice/{id}")
	public ResponseEntity<Double> getTotalBill(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(service.getTotalBill(id), HttpStatus.OK);

	}
	
	// ----- UPDATE FOREIGN KEY BY PHONE_ID (PICKS NEW PLAN FOR A PHONE) -----
	@PutMapping(value = "/phone_info/changePlan/{phone_id}/{plan_id}")
	public ResponseEntity<Void> updatePlanByPhoneId(@PathVariable("plan_id") Integer plan_id, @PathVariable("phone_id") Integer phone_id) {

		service.changePlanForPhoneInfo(plan_id, phone_id);
		return new ResponseEntity<>(HttpStatus.OK);
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
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
