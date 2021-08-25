package com.home.user.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.user.beans.UserPlans;
import com.home.user.data.UserPlansRepository;


@Service
public class UserPlansService {

	@Autowired
	UserPlansRepository repository;
	
	public List<UserPlans> findAllUserPlans() {
		return repository.findAll();
	}

	// Create
	public UserPlans save(UserPlans userPlan) {
		return repository.save(userPlan);
	}

	// Retrieve by id
	public UserPlans findById(Integer id) {
		Optional<UserPlans> optional = repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}
	
	// Update
	public void updateById(Integer id, UserPlans userPlan) {
		if ((userPlan.getUserplan_id() == id) && repository.findById(userPlan.getUserplan_id()).isPresent()) {
			repository.save(userPlan);
		} else {
			throw new ValidationException(); 
		}
	}
	
	// Delete By Id
	public void deleteUserPlan(Integer userPlansId) {
		repository.deleteById(userPlansId);
	}
	
	public Integer getThatId(Integer userId, Integer planId) {
		return repository.getThatId(userId, planId);
	}
	
	
	// check pland_id user has
	public List<Integer> checkPlansUserHas(Integer id) {
		return repository.checkPlansUserHas(id);
	}
	
	
	
	
	
	
}



/*
 * 
 * 
 * 
 */




