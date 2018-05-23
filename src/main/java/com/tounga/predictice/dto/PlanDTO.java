package com.tounga.predictice.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PlanDTO {

	private int planId;
	
	@NotBlank
	private String name;
	
	@NotNull
	private float price;
	
	@NotBlank
	private String engagement;
	
	@NotBlank
	private String features;
	
	@NotNull
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
