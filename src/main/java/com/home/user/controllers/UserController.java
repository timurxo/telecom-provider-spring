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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.home.user.beans.User;

import com.home.user.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService service;

	// ----- FIND ALL --------
	@GetMapping(value = "/user")
	public ResponseEntity<List<User>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	// ------- ADD USER -----
	@PostMapping(value = "/user")
	public ResponseEntity<User> save(@RequestBody @Valid User user) {
		User body = service.save(user);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	// ------ FIND BY ID -----
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);

	}

//	// ------ FIND BY USER NAME -----
//	@GetMapping("/user/name/{nameOfUser}")
//	public ResponseEntity<List<User>> findByUserName(@PathVariable("nameOfUser") String name) {
////		System.out.println(  new ResponseEntity<>(service.findByUserName(name), HttpStatus.OK)  );
//		return new ResponseEntity<>(service.findByUserName(name), HttpStatus.OK);
//	}

	// ------ DELETE BY ID -----
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
		service.deleteUserById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	// ------ GET COUNT BY USER NAME -----
//	@GetMapping("/user/count/{userName}")
//	public ResponseEntity<Integer> countByUserName(@PathVariable("userName") String name) {
//		return new ResponseEntity<>(service.entriesByUserName(name), HttpStatus.OK);
//
//	}

	// ------ GET PLANS BY USER NAME -----
	@GetMapping("/user/plans/{userName}")
	public ResponseEntity<List<String>> plansByUserName(@PathVariable("userName") String name) {
		return new ResponseEntity<>(service.plansByUserName(name), HttpStatus.OK);

	}
	
	
	// GET ID BY NAME
	@GetMapping("/user/getId/{email}")
	public ResponseEntity<Integer> getUsersId(@PathVariable("email") String email) {
		return new ResponseEntity<>(service.getUsersId(email), HttpStatus.OK);

	}
	
	
	// GET USER's DATA BY EMAIL AND PASSWORD
	@GetMapping(value = "/user/byEmailAndPassword/{email}/{password}")
	public ResponseEntity<User> queryUserTableByNameAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {

		User user = service.findByEmailAndPassword(email, password);

		return new ResponseEntity<>(user, HttpStatus.OK);

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
