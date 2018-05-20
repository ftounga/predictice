package com.tounga.predictice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tounga.predictice.entity.OrganizationEntity;
import com.tounga.predictice.entity.PlanEntity;
import com.tounga.predictice.entity.UserEntity;
import com.tounga.predictice.repository.UserRepository;

@RestController
public class SubscriptionController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)	
	public String test (){		
		return "OK";
	}
	
	/*@RequestMapping(value = "/inituser", method = RequestMethod.GET)	
	public String initUsers (){	
		PlanEntity plan = new PlanEntity();
		plan.setEngagement("Year");
		plan.setName("Plan A");
		plan.setFeatures("F1");
		plan.setMaxUsers(10);
		plan.setPrice(500);
		OrganizationEntity organization = new OrganizationEntity();
		organization.setBillingContact("ifacture");
		organization.setDescription("Professional football club");
		organization.setName("Real Madrid");
		organization.setPlan(plan);
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
		return "OK";
	}*/
}
