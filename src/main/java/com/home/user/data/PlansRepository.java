package com.home.user.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.user.beans.Plans;

public interface PlansRepository extends JpaRepository<Plans, Integer>{
	
	String tableName = "plans";

}
