package com.home.user.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.user.beans.Plans;
import com.home.user.data.PlansRepository;

@Service
public class PlansService {

	@Autowired
	private PlansRepository plansRep;

	public List<Plans> findAllPlans() {
		return plansRep.findAll();
	}

	// ------- ADD ----------
	public Plans save(Plans plan) {
		return plansRep.save(plan);
	}

	// ------- FIND BY ID ------
	public Plans findById(Integer id) {
		Optional<Plans> optional = plansRep.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	// ------- DELETE BY ID------
	public void deletePhoneInfoById(Integer id) {
		plansRep.deleteById(id);
	}

	// -------- UPDATE BY ID --------
	public void updateById(Plans plans, Integer id) {
		if ((plans.getPlan_id() == id) && plansRep.findById(plans.getPlan_id()).isPresent()) {
			plansRep.save(plans);
		} else {
			throw new ValidationException();
		}
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
 */
