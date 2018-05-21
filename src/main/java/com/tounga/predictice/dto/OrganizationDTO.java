package com.tounga.predictice.dto;

import java.util.List;

public class OrganizationDTO {

	private int organizationId;
	private String name;
	private String billingContact;
	private String description;
	private List<UserDTO> users;
	private PlanDTO plan;
	private CreditCardDTO creditCard;
	
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBillingContact() {
		return billingContact;
	}
	public void setBillingContact(String billingContact) {
		this.billingContact = billingContact;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	public PlanDTO getPlan() {
		return plan;
	}
	public void setPlan(PlanDTO plan) {
		this.plan = plan;
	}
	public CreditCardDTO getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCardDTO creditCard) {
		this.creditCard = creditCard;
	}	
	
}
