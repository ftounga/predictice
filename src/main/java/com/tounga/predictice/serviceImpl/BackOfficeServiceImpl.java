package com.tounga.predictice.serviceImpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tounga.predictice.dto.CreditCardDTO;
import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.dto.PlanDTO;
import com.tounga.predictice.dto.UserDTO;
import com.tounga.predictice.entity.CreditCardEntity;
import com.tounga.predictice.entity.OrganizationEntity;
import com.tounga.predictice.entity.PlanEntity;
import com.tounga.predictice.entity.UserEntity;
import com.tounga.predictice.enumeration.BusinessErrorCode;
import com.tounga.predictice.exception.BusinessException;
import com.tounga.predictice.mapper.CreditCardMapper;
import com.tounga.predictice.mapper.OrganizationMapper;
import com.tounga.predictice.mapper.PlanMapper;
import com.tounga.predictice.mapper.UserMapper;
import com.tounga.predictice.repository.CreditCardRepository;
import com.tounga.predictice.repository.OrganizationRepository;
import com.tounga.predictice.repository.PlanRepository;
import com.tounga.predictice.repository.UserRepository;
import com.tounga.predictice.service.BackOfficeService;

@Service
@Transactional
public class BackOfficeServiceImpl implements BackOfficeService{

	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void createPlan(PlanDTO dto) {
		PlanEntity entity = PlanMapper.buildPlanEntityFromDto(dto);
		planRepository.savePlanEntity(entity);
		dto.setPlanId(entity.getPlanId());
		
	}

	@Override
	public void createCreditCard(CreditCardDTO dto) {
		CreditCardEntity entity = CreditCardMapper.buildCreditCardEntityFromDTO(dto);
		creditCardRepository.saveCreditCardEntity(entity);
		dto.setCreditCardId(entity.getCreditCardId());
	}

	@Override
	public void createOrganization(OrganizationDTO organization, Integer planId, int creditCardId) {
		
		OrganizationEntity entity = OrganizationMapper.buildOrganizationEntityFromDTOWithNoPlanAndCreditCard(organization);
		if (planId !=null){
			PlanEntity plan = planRepository.findPlanById(planId).orElseThrow(()-> new BusinessException(BusinessErrorCode.PLAN_NOT_FOUND, HttpStatus.NOT_FOUND));
			entity.setPlan(plan);
			organization.setPlan(PlanMapper.buildPlanDTOFromPlanEntity(plan));
		}
		CreditCardEntity creditCard = creditCardRepository.findCreditCardById(creditCardId).orElseThrow(()-> new BusinessException(BusinessErrorCode.CREDIT_CARD_NOT_FOUND, HttpStatus.NOT_FOUND));
		entity.setCreditCard(creditCard);
		organization.setCreditCard(CreditCardMapper.buildCreditCardDTOFromEntity(creditCard));
		organizationRepository.saveOrganizationEntity(entity);
		organization.setOrganizationId(entity.getOrganizationID());
		
	}

	@Override
	public void createUser(UserDTO user) {
		OrganizationEntity organizationEntity = organizationRepository.findOrganizationById(user.getOrganizationId()).orElseThrow(()-> new BusinessException(BusinessErrorCode.ORGANIZATION_NOT_FOUND, HttpStatus.NOT_FOUND));
		if(organizationEntity.getPlan() == null){
			throw new BusinessException(BusinessErrorCode.PLAN_REQUIRED_FIRST, HttpStatus.BAD_REQUEST);
		}
		if (organizationEntity.getUsers().size()>=organizationEntity.getPlan().getMaxUsers()){
			throw new BusinessException(BusinessErrorCode.TOO_MUCH_USERS, HttpStatus.NOT_FOUND);
		}
		UserEntity entity = UserMapper.buildUserEntityFromDTOWithoutOrganization(user);
		entity.setOrganization(organizationEntity);
		userRepository.saveUserEntity(entity);
		user.setUserId(entity.getUserId());
	}

}
