package com.tounga.predictice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tounga.predictice.bean.StripeRequest;
import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.dto.UserDTO;
import com.tounga.predictice.entity.OrganizationEntity;
import com.tounga.predictice.entity.PlanEntity;
import com.tounga.predictice.entity.UserEntity;
import com.tounga.predictice.enumeration.BusinessErrorCode;
import com.tounga.predictice.exception.BusinessException;
import com.tounga.predictice.mapper.CreditCardMapper;
import com.tounga.predictice.mapper.OrganizationMapper;
import com.tounga.predictice.mapper.UserMapper;
import com.tounga.predictice.repository.OrganizationRepository;
import com.tounga.predictice.repository.PlanRepository;
import com.tounga.predictice.repository.UserRepository;
import com.tounga.predictice.service.PaymentService;
import com.tounga.predictice.service.SubscriptionService;

@Transactional
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private PaymentService<StripeRequest> paymentService;

	@Override
	public void subscribe(int organizationId, int planId) {
		OrganizationEntity organization = organizationRepository.findOrganizationById(organizationId).orElseThrow(
				() -> new BusinessException(BusinessErrorCode.ORGANIZATION_NOT_FOUND, HttpStatus.NOT_FOUND));
		PlanEntity plan = planRepository.findPlanById(planId)
				.orElseThrow(() -> new BusinessException(BusinessErrorCode.PLAN_NOT_FOUND, HttpStatus.NOT_FOUND));
		if (organization.getPlan() != null && organization.getPlan().getPlanId() == plan.getPlanId()) {
			throw new BusinessException(BusinessErrorCode.ALREADY_ATTACHED_PLAN, HttpStatus.BAD_REQUEST);
		}
		
		StripeRequest stripeRequest = buildStripeRequestFromOrganizationPlan(organization, plan);
		
		 try {
			paymentService.makePayment(stripeRequest);
		} catch (Exception e) {			
			e.printStackTrace();
			throw new BusinessException(BusinessErrorCode.STRIPE_PAYMENT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		organization.setPlan(plan);
		organizationRepository.saveOrganizationEntity(organization);

	}

	private StripeRequest buildStripeRequestFromOrganizationPlan(OrganizationEntity organization, PlanEntity plan) {
		StripeRequest stripeRequest = new StripeRequest();
		stripeRequest.setAmount(plan.getPrice());
		stripeRequest.setCurrency("EUR");
		stripeRequest.setCreditCard(CreditCardMapper.buildCreditCardDTOFromEntity(organization.getCreditCard()));
		return stripeRequest;
	}

	@Override
	public void unsubscribe(int organizationId) {
		OrganizationEntity organization = organizationRepository.findOrganizationById(organizationId).orElseThrow(
				() -> new BusinessException(BusinessErrorCode.ORGANIZATION_NOT_FOUND, HttpStatus.NOT_FOUND));
		if (organization.getPlan() == null) {
			throw new BusinessException(BusinessErrorCode.NO_PLAN_ATTACHED, HttpStatus.BAD_REQUEST);
		}
		organization.setPlan(null);
		organizationRepository.saveOrganizationEntity(organization);
	}

	@Override
	public Optional<String> getFeaturesByUserId(int userID) {
		UserEntity user = userRepository.findUserById(userID)
				.orElseThrow(() -> new BusinessException(BusinessErrorCode.USER_NOT_FOUND, HttpStatus.NOT_FOUND));
		OrganizationEntity organization = user.getOrganization();
		if (organization.getPlan() != null) {
			return Optional.of(organization.getPlan().getFeatures());
		}
		return Optional.empty();
	}

	@Override
	public List<UserDTO> findAllUsers() {
		return userRepository.findAllUserEntity().stream().map(u -> UserMapper.buildUserDTOFromUserEntity(u))
				.collect(Collectors.toList());
	}

	@Override
	public List<OrganizationDTO> findAllOrganizations() {
		return organizationRepository.findAllOrganizationEntity().stream()
				.map(OrganizationMapper::buildOrganizationDTOFromOrganizationEntity).collect(Collectors.toList());
	}

}
