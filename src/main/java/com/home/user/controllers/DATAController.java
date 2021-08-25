package com.home.user.controllers;

import java.util.ArrayList;
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

import com.home.user.beans.DATA;
import com.home.user.beans.PhoneInfo;
import com.home.user.beans.Plans;
import com.home.user.beans.User;
import com.home.user.beans.UserPlans;
import com.home.user.data.DATARepository;
import com.home.user.data.PhoneInfoRepository;
import com.home.user.data.UserPlansRepository;
import com.home.user.service.PhoneInfoService;
import com.home.user.service.PlansService;
import com.home.user.service.UserPlansService;
import com.home.user.service.UserService;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "*")
public class DATAController {

//	@Autowired
//	private User user;
//
//	@Autowired
//	private PhoneInfo phoneInfo;
//
//	@Autowired
//	private Plans plans;
//
//	@Autowired
//	private UserPlans userPlans;
//	
	// -------

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneInfoService phoneInfoService;

	@Autowired
	private PlansService plansService;

	@Autowired
	private UserPlansService userPlansService;
	
	@Autowired
	private PhoneInfoRepository phoneInfoRep;
	
	@Autowired
	private UserPlansRepository userPlansRep;
	
	

	// -------

	// ----- FIND ALL --------
	@GetMapping(value = "/getData")
	public ResponseEntity<List<Object>> findAll() {

		List<User> allUsers = userService.findAll();
		List<PhoneInfo> allPhoneInfo = phoneInfoService.findAllPhoneInfo();
		List<Plans> allPlans = plansService.findAllPlans();
		List<UserPlans> allUserPlans = userPlansService.findAllUserPlans();

		List<Object> dataList = new ArrayList<>();
		dataList.addAll(allUsers);
		dataList.add(allPhoneInfo);
		dataList.add(allPlans);
		dataList.add(allUserPlans);

		return new ResponseEntity<>(dataList, HttpStatus.OK);

	}

	// ----- RETRIEVE 1 USER'S INFORMATION BY ID ---------
	@GetMapping(value = "/getData/{id}")
	public ResponseEntity<DATA> findDataByUser(@PathVariable("id") Integer id) {

		User user = userService.findById(id);
		PhoneInfo phoneInfo = phoneInfoService.findById(id);
		Plans plans = plansService.findById(id);
		UserPlans userPlans = userPlansService.findById(id);

		DATA data = new DATA(user, phoneInfo, plans, userPlans);

		System.out.println("SENDING TO FRONT END: " + data);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/getData/user/{id}")
	public ResponseEntity<User> queryUserTable(@PathVariable("id") Integer id) {

		User user = userService.findById(id);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getData/email/{email}")
	public ResponseEntity<User> queryUserTableByName(@PathVariable("email") String email) {

		User user = userService.findByEmail(email);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	// ----------- ADDING NEW DEVICE -------- 2 steps
	
	// inside of UserPlans add id which will point to PhoneInfo for each user
//	@PostMapping(value = "/addingUserInfoUserId")
//	public void addUserInfoUserId(@RequestBody @Valid  Integer user_id) {		// @PathVariable("id") 
//		// add user's id into user_info_user_id column in userplans table
////		UserPlans addedId = 
//				userPlansRep.addUserInfoUserId1(12);
//
////	    return new ResponseEntity<>(addedId, HttpStatus.CREATED);
//	}
	
	
	// add PhoneInfo for each user depending on UserPlans id
	@PostMapping(value = "/addingPhoneInfoByUser/{user_id}")
	public void addPhoneInfoByUserId(@RequestBody @Valid PhoneInfo phoneInfo, @PathVariable("user_id") Integer user_id) {
		
		
		// get pk of that newly inserted row
		Integer pkOfUserplans = userPlansRep.findUserplanIdByUIUI(user_id);
		
		String phoneName = phoneInfo.getPhoneName();
		String phoneNumber = phoneInfo.getPhoneNumber();
		
//		phoneInfoRep.addPhoneInfo(phoneName, phoneNumber, pkOfUserplans);
		
		
		
	}
	

	
	// CALCULATE BILL
	@GetMapping(value = "/getData/totalBill")
	public ResponseEntity<Integer> calculateTotalBill() {
		
		
		
		
		return null;
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
*/