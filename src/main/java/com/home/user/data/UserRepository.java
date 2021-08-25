package com.home.user.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.home.user.beans.User;

@Repository // manages transaction processing
public interface UserRepository extends JpaRepository<User, Integer> {

	String tableName = "user_info";

	@Query(value = "SELECT user_id FROM " + tableName + " WHERE email = ?1", nativeQuery = true)
	public Integer findIdByEmail(String email);

	// get User's id from 'user_info' table
	@Query(value = "select user_id from user_info \n" + "where email = ?1", nativeQuery = true)
	public Integer getUsersId(String email);
	
	@Query(value = "SELECT user_id FROM " + tableName + " WHERE email = ?1 and password = ?2", nativeQuery = true)
	public Integer findIdByEmailAndPassword(String email, String password);

	/*
	 * 
	 * // CRUD methods
	 * 
	 * @Query(value = "SELECT user_id FROM " + tableName + " WHERE email = ?1",
	 * nativeQuery = true) public User findByEmail(String email);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Query(value = "INSERT INTO  " + tableName + " VALUES(?1, ?2, ?3, ?4)",
	 * nativeQuery = true) public void addDevice(String userName, String device,
	 * String number, String plan);
	 * 
	 * @Query(value = "SELECT count(*) FROM " + tableName + " WHERE userName =?1",
	 * nativeQuery = true) public Integer entriesByUserName(String userName);
	 * 
	 * // plans by user
	 * 
	 * @Query(value = "SELECT plan FROM " + tableName + " WHERE userName =?1",
	 * nativeQuery = true) public List<String> getPlansByUserName(String userName);
	 * 
	 * 
	 * 
	 * 
	 */

}
