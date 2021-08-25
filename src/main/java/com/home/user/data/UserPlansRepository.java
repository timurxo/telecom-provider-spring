package com.home.user.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.home.user.beans.UserPlans;

@Repository
public interface UserPlansRepository extends JpaRepository<UserPlans, Integer>{
	
	@Query(value = "SELECT userplan_id FROM userplans WHERE user_info_user_id = ?1", nativeQuery = true)
	public Integer findUserplanIdByUIUI(Integer user_info_user_id); 

	
	

	
	
	
	
	@Query(value = "insert into phone_info(phone_name, phone_number, userplans_userplan_id) \n"
			+ " values(?1, ?2, ?3)", nativeQuery = true)
	public void addPhoneInfo(String phoneName, String phoneNumber, Integer id);
	
	
	// GET ID FROM USERPLANS TABLE BY 2 OTHER COLUMNS
	@Query(value = "select userplan_id from userplans\r\n"
				+ "where user_info_user_id = ?1 and plans_plan_id = ?2", nativeQuery = true)
	public Integer getThatId(Integer userId, Integer planId); 
	
	
	@Query(value="select plans_plan_id from userplans\r\n"
			+ "where user_info_user_id = ?1", nativeQuery = true)
	public List<Integer> checkPlansUserHas(Integer id);
	
	
	
}
