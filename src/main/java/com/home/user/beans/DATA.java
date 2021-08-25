package com.home.user.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class DATA {

	@Autowired
	private User user;

	@Autowired
	private PhoneInfo phoneInfo;

	@Autowired
	private Plans plans;

	@Autowired
	private UserPlans userPlans;

	public DATA() {
		super();
	}

	public DATA(User user, PhoneInfo phoneInfo, Plans plans) {
		super();
		this.user = user;
		this.phoneInfo = phoneInfo;
		this.plans = plans;
	}

	public DATA(User user, PhoneInfo phoneInfo, Plans plans, UserPlans userPlans) {
		super();
		this.user = user;
		this.phoneInfo = phoneInfo;
		this.plans = plans;
		this.userPlans = userPlans;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PhoneInfo getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(PhoneInfo phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public Plans getPlans() {
		return plans;
	}

	public void setPlans(Plans plans) {
		this.plans = plans;
	}

	public UserPlans getUserPlans() {
		return userPlans;
	}

	public void setUserPlans(UserPlans userPlans) {
		this.userPlans = userPlans;
	}

	@Override
	public String toString() {
		return "DATA [user=" + user + ", phoneInfo=" + phoneInfo + ", plans=" + plans + ", userPlans=" + userPlans
				+ "]";
	}

	
	
}
