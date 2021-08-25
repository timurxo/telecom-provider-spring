package com.home.user.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.user.beans.PhoneInfo;
import com.home.user.data.PhoneInfoRepository;

@Service
public class PhoneInfoService {

	@Autowired
	private PhoneInfoRepository phoneInfoRep;

	public List<PhoneInfo> findAllPhoneInfo() {
		return phoneInfoRep.findAll();
	}

	// ------- ADD ----------
	public PhoneInfo save(PhoneInfo phoneInfo) {
		return phoneInfoRep.save(phoneInfo);
	}

	// ------- FIND BY ID ------
	public PhoneInfo findById(Integer id) {
		Optional<PhoneInfo> optional = phoneInfoRep.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	// ------- DELETE BY ID------
	public void deletePhoneInfoById(Integer id) {
		phoneInfoRep.deleteById(id);
	}

	// -------- UPDATE BY ID --------
	public void updateById(PhoneInfo phoneInfo, Integer id) {
		if ((phoneInfo.getPhone_id() == id) && phoneInfoRep.findById(phoneInfo.getPhone_id()).isPresent()) {
			phoneInfoRep.save(phoneInfo);
		} else {
			throw new ValidationException();
		}
	}


	// boolean check if number is already in user

	// ------- GET NUMBER OF DEVICES FOR EVERY USER ID------
	public Integer getNumberOfDevicesByUserId(Integer id) {
		Integer numOfDevices = phoneInfoRep.getNumberOfDevicesByUserId(id);
		return numOfDevices;
	}

	// ------- GET NUMBER OF DEVICES FOR EVERY USER ID------
	public Integer getNumberOfDevicesForEachPlan(Integer user_id, Integer planId) {
		Integer numOfDevices = phoneInfoRep.getNumberOfDevicesForEachPlan(user_id, planId);
		return numOfDevices;
	}

	// ------- GET TOTAL PRICE ------
	public Double getTotalBill(Integer user_id) {
		System.out.println("-------");

		Double totalBill = 0.0;

		Integer numOfDevicesPlanA = phoneInfoRep.getNumberOfDevicesForEachPlan(user_id, 1);
		System.out.println("Devices with plan A: " + numOfDevicesPlanA);

		totalBill += numOfDevicesPlanA * 30;

		// ------ plan B
		Integer numOfDevicesPlanB = phoneInfoRep.getNumberOfDevicesForEachPlan(user_id, 2);
		System.out.println("Devices with plan B: " + numOfDevicesPlanB);

		if (numOfDevicesPlanB <= 2 && numOfDevicesPlanB > 0) {
			totalBill += 50;
		} else {
			totalBill += Math.ceil(numOfDevicesPlanB / 2) * 50;
		}

		// ------ plan C
		Integer numOfDevicesPlanC = phoneInfoRep.getNumberOfDevicesForEachPlan(user_id, 3);
		System.out.println("Devices with plan C: " + numOfDevicesPlanC);

		if (numOfDevicesPlanC <= 5 && numOfDevicesPlanC > 0) {
			totalBill += 140;
		} else {
			totalBill += Math.ceil(numOfDevicesPlanC / 5) * 140;
		}


		return totalBill;
	}
	
	public void changePlanForPhoneInfo(Integer plan_id, Integer phone_id) {
		phoneInfoRep.changePlanForPhoneInfo(plan_id, phone_id);
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
