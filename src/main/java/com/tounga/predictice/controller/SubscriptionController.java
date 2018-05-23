package com.tounga.predictice.controller;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.tounga.predictice.service.SubscriptionService;

@RestController
public class SubscriptionController {

	/*@Autowired
	private UserRepository userRepository;*/
	
	@Autowired
	private BackOfficeService backOffice;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@RequestMapping(value = "/getalluser", method = RequestMethod.GET)	
	public List<UserDTO> getAllUsers (){	
		return subscriptionService.findAllUsers();
	}
	
	@RequestMapping(value = "/getallorganizations", method = RequestMethod.GET)	
	public ResponseEntity<List<OrganizationDTO>> getAllOrganization(){
		List<OrganizationDTO> organizations = subscriptionService.findAllOrganizations();
		ResponseEntity<List<OrganizationDTO>> response = new ResponseEntity<>(organizations, HttpStatus.OK);		
		return response;
	}
	@RequestMapping(value = "/organization/{organizationId}/unsubscribe", method = RequestMethod.GET)	
	public ResponseEntity<GenericResponse<String>> unsubscribe(@PathVariable("organizationId") int organizationId){
		
		subscriptionService.unsubscribe(organizationId);
		GenericResponse<String> response = new GenericResponse<>();
		response.setMessge("The unsubscription succed");
		ResponseEntity<GenericResponse<String>> result = new ResponseEntity<>(response,HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/organization/{organizationId}/subscribeplan/{planId}", method = RequestMethod.GET)	
	public ResponseEntity<GenericResponse<String>> subscribe(@PathVariable("organizationId") int organizationId, @PathVariable("planId") int planId){
		
		subscriptionService.subscribe(organizationId, planId);
		GenericResponse<String> response = new GenericResponse<>();
		response.setMessge("The subscription succed");
		ResponseEntity<GenericResponse<String>> result = new ResponseEntity<>(response,HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/user/{userId}/getfeatures", method = RequestMethod.GET)	
	public ResponseEntity<GenericResponse<String>> getFeaturesByUsers(@PathVariable("userId") int userId){
		
		Optional<String> features = subscriptionService.getFeaturesByUserId(userId);
		GenericResponse<String> response = new GenericResponse<>();
		if(features.isPresent()){
			response.setMessge("The features availables for this user");
			response.setData(features.get());
			ResponseEntity<GenericResponse<String>> result = new ResponseEntity<>(response,HttpStatus.OK);
			return result;
		}
		response.setMessge("The User has no plan");
		ResponseEntity<GenericResponse<String>> result = new ResponseEntity<>(response,HttpStatus.OK);
		
		return result;
	}
}
