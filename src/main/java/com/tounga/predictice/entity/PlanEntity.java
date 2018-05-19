package com.tounga.predictice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plan")
public class PlanEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="planId")
	private int planId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private float price;
	
	@Column(name="engagement")
	private String engagement;
	
	@Column(name="features")
	private String features;
	
	@Column(name="maxUsers")
	private int maxUsers;
	
	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEngagement() {
		return engagement;
	}

	public void setEngagement(String engagement) {
		this.engagement = engagement;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public int getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(int maxUsers) {
		this.maxUsers = maxUsers;
	}	
	
	
}
