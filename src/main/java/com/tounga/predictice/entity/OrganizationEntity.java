package com.tounga.predictice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Organization")
public class OrganizationEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="organizationID")
	private int organizationID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;	
	
	@Column(name="billingContact")
	private String billingContact;
	
	@OneToMany(mappedBy = "organization")
    private List<UserEntity> users;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "planId")
	private PlanEntity plan;

	public int getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBillingContact() {
		return billingContact;
	}
	public void setBillingContact(String billingContact) {
		this.billingContact = billingContact;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	public PlanEntity getPlan() {
		return plan;
	}
	public void setPlan(PlanEntity plan) {
		this.plan = plan;
	}	
	
	
}
