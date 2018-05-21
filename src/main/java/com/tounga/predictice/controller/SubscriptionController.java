package com.tounga.predictice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tounga.predictice.bean.GenericResponse;
import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.dto.UserDTO;
import com.tounga.predictice.entity.CreditCardEntity;
import com.tounga.predictice.entity.OrganizationEntity;
import com.tounga.predictice.entity.PlanEntity;
import com.tounga.predictice.entity.UserEntity;
import com.tounga.predictice.repository.UserRepository;
import com.tounga.predictice.service.SubscriptionService;

@RestController
public class SubscriptionController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)	
	public String test (){		
		return "OK";
	}
	
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
	
	@RequestMapping(value = "/inituser", method = RequestMethod.GET)	
	public String initUsers (){	
		PlanEntity plan = new PlanEntity();
		plan.setEngagement("Year");
		plan.setName("Plan A");
		plan.setFeatures("F1");
		plan.setMaxUsers(10);
		plan.setPrice(500);
		CreditCardEntity creditCard = new CreditCardEntity();
		creditCard.setCardNumber("4242424242424242");
		creditCard.setCvc("314");
		creditCard.setExp_month(5);
		creditCard.setExp_year(2019);		
		
		PlanEntity plan1 = new PlanEntity();
		plan1.setEngagement("month");
		plan1.setName("Plan B");
		plan1.setFeatures("F1&F2");
		plan1.setMaxUsers(10);
		plan1.setPrice(500);
		
		OrganizationEntity organization = new OrganizationEntity();
		organization.setBillingContact("ifacture");
		organization.setDescription("Professional football club");
		organization.setName("Real Madrid");
		organization.setPlan(plan);
		organization.setCreditCard(creditCard);
		OrganizationEntity organization1 = new OrganizationEntity();
		organization1.setBillingContact("fast_facture");
		organization1.setDescription("Banque de détail");
		organization1.setName("Société générale");
		organization1.setPlan(plan1);
		organization1.setCreditCard(creditCard);
		UserEntity user1 = new UserEntity();
		user1.setFirstName("Alexandre");
		user1.setLastName("Legrand");
		user1.setOrganization(organization);
		userRepository.saveUserEntity(user1);
		UserEntity user2 = new UserEntity();
		user2.setFirstName("Thommasco");
		user2.setLastName("Gilbert");
		user2.setOrganization(organization);
		userRepository.saveUserEntity(user2);
		UserEntity user3 = new UserEntity();
		user3.setFirstName("Jimmy");
		user3.setLastName("Christ");
		user3.setOrganization(organization1);
		userRepository.saveUserEntity(user3);
		return "OK";
	}
}
