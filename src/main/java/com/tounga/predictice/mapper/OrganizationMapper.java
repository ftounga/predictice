package com.tounga.predictice.mapper;

import java.util.stream.Collectors;

import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.entity.OrganizationEntity;

public class OrganizationMapper {

	public static OrganizationDTO buildOrganizationDTOFromOrganizationEntity(OrganizationEntity entity){
		OrganizationDTO dto = new OrganizationDTO();
		dto.setOrganizationId(entity.getOrganizationID());
		dto.setBillingContact(entity.getBillingContact());
		dto.setDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setUsers(entity.getUsers().stream().map(UserMapper:: buildUserDTOFromUserEntity).collect(Collectors.toList()));
		if (entity.getPlan() != null){
			dto.setPlan(PlanMapper.buildPlanDTOFromPlanEntity(entity.getPlan()));			
		}
		dto.setCreditCard(CreditCardMapper.buildCreditCardDTOFromEntity(entity.getCreditCard()));
		return dto;	
	}
}
