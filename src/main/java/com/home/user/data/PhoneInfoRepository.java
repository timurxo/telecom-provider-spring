package com.home.user.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.home.user.beans.PhoneInfo;


public interface PhoneInfoRepository extends JpaRepository<PhoneInfo, Integer> {

	String tableName = "phone_info";

	@Query(value = "INSERT INTO phone_info(phone_name, phone_number, userplans_userplan_id)\n"
			+ "SELECT ?1, ?2, up.userplan_id\n"
			+ "FROM userplans up\n"
			+ "WHERE up.user_info_user_id = ?3", nativeQuery = true)
	public void addDeviceNOTWORKING(String phoneName, String phoneNumber, Integer user_id);
	
	
	
	@Query(value = "select count(*) from phone_info\n"
			+ "JOIN userplans ON (phone_info.userplans_userplan_id = userplans.userplan_id)\n"
			+ "JOIN user_info ON (userplans.user_info_user_id = user_info.user_id)\n"
			+ "where user_info.user_id = ?1", nativeQuery = true)
	public Integer getNumberOfDevicesByUserId(Integer id);
	
	
	// get number of devices for each user id and plan id
	@Query(value="select count(*) from phone_info\n"
			+ "JOIN userplans ON (phone_info.userplans_userplan_id = userplans.userplan_id)\n"
			+ "JOIN user_info ON (userplans.user_info_user_id = user_info.user_id)\n"
			+ "where user_info.user_id = ?1  and userplans.plans_plan_id = ?2", nativeQuery = true)
	public Integer getNumberOfDevicesForEachPlan(Integer user_id, Integer plan_id);
	
	
	// change FK of phone_info table (change plan for phone)
	@Query(value = "update phone_info set userplans_userplan_id = ?1 where phone_id = ?2", nativeQuery = true)
	public void changePlanForPhoneInfo(Integer userPlanId, Integer phone_id);
	
	
}
