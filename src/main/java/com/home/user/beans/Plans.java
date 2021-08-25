package com.home.user.beans;


import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plans")
public class Plans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_id")
	private int plan_id;

	@Column(name = "max_devices")
	private int maxDevices;

	@Column(name = "plan_cost")
	private int cost;

	@JsonIgnore
//	@JsonManagedReference	// delete?
	@OneToMany(mappedBy = "plans")							// ***** , cascade = CascadeType.ALL)
	private Set<UserPlans> userPlans; // = new HashSet<>();

	public Plans() {
		super();
	}

	public Plans(int maxDevices, int cost) {
		super();
		this.maxDevices = maxDevices;
		this.cost = cost;
	}

	public Plans(int plan_id, int maxDevices, int cost) {
		super();
		this.plan_id = plan_id;
		this.maxDevices = maxDevices;
		this.cost = cost;
	}

	public Plans(int maxDevices, int cost, Set<UserPlans> userPlans) {
		super();
		this.maxDevices = maxDevices;
		this.cost = cost;
		this.userPlans = userPlans;
	}

	public Plans(int plan_id, int maxDevices, int cost, Set<UserPlans> userPlans) {
		super();
		this.plan_id = plan_id;
		this.maxDevices = maxDevices;
		this.cost = cost;
		this.userPlans = userPlans;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getMaxDevices() {
		return maxDevices;
	}

	public void setMaxDevices(int maxDevices) {
		this.maxDevices = maxDevices;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Set<UserPlans> getUserPlans() {
		return userPlans;
	}

	public void setUserPlans(Set<UserPlans> userPlans) {
		this.userPlans = userPlans;
	}

	
}
