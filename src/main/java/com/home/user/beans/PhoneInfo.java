package com.home.user.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "phone_info")
public class PhoneInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private int phone_id;

	@Column(name = "phone_name")
	private String phoneName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@JsonBackReference // used to mark child objects
	@ManyToOne
	@JoinColumn(name = "userplans_userplan_id", insertable = false, updatable = false)
	private UserPlans userPlans;

	
	
	
	@Column(name = "userplans_userplan_id")
	private int userPlanId;
	
	
	
	
	
	public PhoneInfo() {
		super();
	}

	public PhoneInfo(int phone_id, String phoneName, String phoneNumber) {
		super();
		this.phone_id = phone_id;
		this.phoneName = phoneName;
		this.phoneNumber = phoneNumber;
	}

	public PhoneInfo(String phoneName, String phoneNumber) {
		super();
		this.phoneName = phoneName;
		this.phoneNumber = phoneNumber;
	}

	// delete?
	public PhoneInfo(String phoneName, String phoneNumber, UserPlans userPlans) {
		super();
		this.phoneName = phoneName;
		this.phoneNumber = phoneNumber;
		this.userPlans = userPlans;
	}

	// delete?
	public PhoneInfo(int phone_id, String phoneName, String phoneNumber, UserPlans userPlans) {
		super();
		this.phone_id = phone_id;
		this.phoneName = phoneName;
		this.phoneNumber = phoneNumber;
		this.userPlans = userPlans;
	}

	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserPlans getUserPlans() {
		return userPlans;
	}

	public void setUserPlans(UserPlans userPlans) {
		this.userPlans = userPlans;
	}

	public int getUserPlanId() {
		return userPlanId;
	}

	public void setUserPlanId(int userPlanId) {
		this.userPlanId = userPlanId;
	}

	
	

}
