package com.tounga.predictice.service;

import javax.validation.Valid;

import com.tounga.predictice.dto.CreditCardDTO;
import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.dto.PlanDTO;
import com.tounga.predictice.dto.UserDTO;

public interface BackOfficeService {

	public void createPlan(PlanDTO plan);

	public void createCreditCard(CreditCardDTO creditCard);

	public void createOrganization(OrganizationDTO organization, Integer planId, int creditCardId);

	public void createUser(UserDTO user);
}
