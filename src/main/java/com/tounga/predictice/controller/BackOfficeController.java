package com.tounga.predictice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tounga.predictice.bean.GenericResponse;
import com.tounga.predictice.dto.CreditCardDTO;
import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.dto.PlanDTO;
import com.tounga.predictice.dto.UserDTO;
import com.tounga.predictice.service.BackOfficeService;

@RestController
public class BackOfficeController {

	@Autowired
	private BackOfficeService backOffice;
	
	@RequestMapping(value = "/createplan", consumes="application/json",method = RequestMethod.POST)
	public ResponseEntity<GenericResponse<PlanDTO>> createPlan(@Valid @RequestBody PlanDTO plan){
		
		backOffice.createPlan(plan);
		GenericResponse<PlanDTO> response = new GenericResponse<>();
		response.setData(plan);
		response.setMessge("The plan has been created successfully");
		ResponseEntity<GenericResponse<PlanDTO>> result = new ResponseEntity<>(response,HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/createcreditcard", consumes="application/json",method = RequestMethod.POST)
	public ResponseEntity<GenericResponse<CreditCardDTO>> createCreditCard(@Valid @RequestBody CreditCardDTO creditCard){
		
		backOffice.createCreditCard(creditCard);
		GenericResponse<CreditCardDTO> response = new GenericResponse<>();
		response.setData(creditCard);
		response.setMessge("The Credit card has been created successfully");
		ResponseEntity<GenericResponse<CreditCardDTO>> result = new ResponseEntity<>(response,HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/createorganization", consumes="application/json",method = RequestMethod.POST)
	public ResponseEntity<GenericResponse<OrganizationDTO>> createOrganization(@Valid @RequestBody OrganizationDTO organization, @RequestParam(value="planid", required=false) Integer planid, @RequestParam("creditcardid") int creditcardid){
		
		backOffice.createOrganization(organization, planid, creditcardid);
		GenericResponse<OrganizationDTO> response = new GenericResponse<>();
		response.setData(organization);
		response.setMessge("The Organization has been created successfully");
		ResponseEntity<GenericResponse<OrganizationDTO>> result = new ResponseEntity<>(response,HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/createuser", consumes="application/json",method = RequestMethod.POST)
	public ResponseEntity<GenericResponse<UserDTO>> createUser(@Valid @RequestBody UserDTO user){
		
		backOffice.createUser(user);
		GenericResponse<UserDTO> response = new GenericResponse<>();
		response.setData(user);
		response.setMessge("The User has been created successfully");
		ResponseEntity<GenericResponse<UserDTO>> result = new ResponseEntity<>(response,HttpStatus.OK);
		return result;
	}
}
