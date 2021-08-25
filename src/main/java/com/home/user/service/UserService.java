package com.home.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.user.beans.User;
import com.home.user.data.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRep;

	// ------- FIND ALL -----
	public List<User> findAll() {
		return userRep.findAll();
	}

	// ------- ADD ----------
	public User save(User user) {
		return userRep.save(user);
	}

	// ------- FIND BY ID ------
	public User findById(Integer id) {
		Optional<User> optional = userRep.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	// ------- FIND BY EMAIL------
	public User findByEmail(String email) {
		Optional<User> optional = userRep.findById(userRep.findIdByEmail(email));
		return optional.isPresent() ? optional.get() : null;
	}

	// ------- FIND BY EMAIL AND PASSWORD ------
	public User findByEmailAndPassword(String email, String password) {
		Optional<User> optional = userRep.findById(userRep.findIdByEmailAndPassword(email, password));
		return optional.isPresent() ? optional.get() : null;
	}

	// ------- DELETE USER BY ID------
	public void deleteUserById(Integer id) {
		userRep.deleteById(id);
	}

//	// ------- GET COUNT BY USER NAME ------
//	public Integer entriesByUserName(String name) {
//		return userRep.entriesByUserName(name);
//	}

	// ------- GET PLANS BY USER NAME ------
	public List<String> plansByUserName(String name) {
		return null;
	}

	// user_info . userplans . plans -> max_devices

	// get User's id
	public Integer getUsersId(String email) {

		return userRep.findIdByEmail(email);
	}

	// FIND BY EMAIL AND PASSWORD

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
