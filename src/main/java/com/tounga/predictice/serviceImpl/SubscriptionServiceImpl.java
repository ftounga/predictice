package com.tounga.predictice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tounga.predictice.entity.OrganizationEntity;
import com.tounga.predictice.entity.PlanEntity;
import com.tounga.predictice.entity.UserEntity;
import com.tounga.predictice.repository.OrganizationRepository;
import com.tounga.predictice.repository.PlanRepository;
import com.tounga.predictice.repository.UserRepository;
import com.tounga.predictice.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public void subscribe(int organizationId, int planId) {		
		Optional<OrganizationEntity> organization = organizationRepository.findOrganizationById(organizationId);
		Optional<PlanEntity> plan = planRepository.findPlanById(planId);
		if (organization.isPresent() && plan.isPresent()){
			organizationRepository.saveOrganizationEntity(organization.get());			
		}
	}

	@Override
	public void unsubscribe(int organizationId) {
		Optional<OrganizationEntity> organization = organizationRepository.findOrganizationById(organizationId);
		organization.ifPresent(o -> {
			o.setPlan(null);
			organizationRepository.saveOrganizationEntity(o);
		});
	}

	@Override
	public Optional<String> getFeaturesByUserId(int userID) {
		Optional<UserEntity> user = userRepository.findUserById(userID);
		Optional<OrganizationEntity> organization = user.map(u ->u.getOrganization());
		return organization.map(o -> o.getPlan().getFeatures());
	}

}
