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


import com.home.user.beans.UserPlans;
import com.home.user.service.UserPlansService;

@RestController
@RequestMapping("/usersplans")
@CrossOrigin(origins = "*")
public class UserPlansController {

	@Autowired
	private UserPlansService service;

	// ----- FIND ALL --------
	@GetMapping(value = "/userplan")
	public ResponseEntity<List<UserPlans>> findAllPhoneInfo() {
		return new ResponseEntity<>(service.findAllUserPlans(), HttpStatus.OK);
	}

	// ----- GET USERS PLAN BY ID --------
	@GetMapping("/userplan/{userPlanId}")
	public ResponseEntity<UserPlans> getUserPlan(@PathVariable("userPlanId") Integer userPlanId) {
		return new ResponseEntity<>(service.findById(userPlanId), HttpStatus.OK);
	}

	// ----- ADD USERS PLAN --------
	@PostMapping("/userplan")
	public ResponseEntity<UserPlans> create(@RequestBody @Valid UserPlans userPlans) {
		return new ResponseEntity<>(service.save(userPlans), HttpStatus.CREATED);
	}

	// ----- UPDATE BY ID --------
	@PutMapping("/userplan/{userPlanId}")
	public ResponseEntity<Void> updateById(@PathVariable("userPlanId") Integer userplanId,
			@RequestBody @Valid UserPlans userPlans) {
		service.updateById(userplanId, userPlans);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// ----- DELETE USERS PLAN BY ID --------
	@DeleteMapping("/userplan/{userPlanId}")
	public ResponseEntity<Void> deleteUserPlan(@PathVariable("userPlanId") Integer userPlanId) {
		service.deleteUserPlan(userPlanId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	// ===========================
	
	// find userplan_id where user_info_user_id = ? & plans_plan_id = ?
	@GetMapping("/userplan/{userId}/{planId}")
	public ResponseEntity<Integer> getUserPlanId(@PathVariable("userId") Integer userId, @PathVariable("planId") Integer planId) {
		return new ResponseEntity<>(service.getThatId(userId, planId), HttpStatus.OK);
	}
	
	
	// check planId's user has
	@GetMapping("/userplan/checkPlans/{userId}")
	public ResponseEntity<List<Integer>> checkPlansUserHas(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<>(service.checkPlansUserHas(userId), HttpStatus.OK);
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







