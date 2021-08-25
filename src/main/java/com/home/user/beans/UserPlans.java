package com.home.user.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "userplans")
public class UserPlans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userplan_id")
	private int userplan_id;

	/*
	@JsonBackReference	
	@ManyToOne
	@JoinColumn(name = "user_info_user_id", referencedColumnName = "user_id")
	private User user;

//	@JsonBackReference	// delete?
	@ManyToOne
	@JoinColumn(name = "plans_plan_id", referencedColumnName = "plan_id", insertable = false, updatable = false)
	private Plans plans;
	
	*/
	
	
	@JsonBackReference	
	@ManyToOne
	@JoinColumn(name = "user_info_user_id", insertable = false, updatable = false)
	private User user;
	
	@Column(name = "user_info_user_id")
	private int user_info_user_id;
	
	
	
		// PLANS TABLE
	@Column(name = "plans_plan_id")
	private int plans_plan_id;

//	@JsonBackReference	// delete?
	@ManyToOne
	@JoinColumn(name = "plans_plan_id", referencedColumnName = "plan_id",insertable = false, updatable = false)
	private Plans plans;
	
	

	
	
	
	
	

	@JsonManagedReference	
//	@JsonIgnore		// ********
	@OneToMany(mappedBy = "userPlanId", cascade = CascadeType.ALL)
	private Set<PhoneInfo> phoneInfo;

	
	
	
	
	
	
	
	public UserPlans() {
		super();
	}

	public UserPlans(User user, Plans plans) {
		super();
		this.user = user;
		this.plans = plans;
	}

	public UserPlans(int userplan_id, User user, Plans plans) {
		super();
		this.userplan_id = userplan_id;
		this.user = user;
		this.plans = plans;
	}

	public UserPlans(User user, Plans plans, Set<PhoneInfo> phoneInfo) {
		super();
		this.user = user;
		this.plans = plans;
		this.phoneInfo = phoneInfo;
	}

	public UserPlans(int userplan_id, User user, Plans plans, Set<PhoneInfo> phoneInfo) {
		super();
		this.userplan_id = userplan_id;
		this.user = user;
		this.plans = plans;
		this.phoneInfo = phoneInfo;
	}

	public int getUserplan_id() {
		return userplan_id;
	}

	public void setUserplan_id(int userplan_id) {
		this.userplan_id = userplan_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Plans getPlans() {
		return plans;
	}

	public void setPlans(Plans plans) {
		this.plans = plans;
	}

	public Set<PhoneInfo> getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(Set<PhoneInfo> phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public int getUser_info_user_id() {
		return user_info_user_id;
	}

	public void setUser_info_user_id(int user_info_user_id) {
		this.user_info_user_id = user_info_user_id;
	}

	public int getPlans_plan_id() {
		return plans_plan_id;
	}

	public void setPlans_plan_id(int plans_plan_id) {
		this.plans_plan_id = plans_plan_id;
	}
	
	

}
