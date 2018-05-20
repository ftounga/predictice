package com.tounga.predictice.mapper;

import com.tounga.predictice.dto.PlanDTO;
import com.tounga.predictice.entity.PlanEntity;

public class PlanMapper {

	public static PlanDTO buildPlanDTOFromPlanEntity(PlanEntity entity){
		PlanDTO dto = new PlanDTO();
		dto.setEngagement(entity.getEngagement());
		dto.setFeatures(entity.getFeatures());
		dto.setMaxUsers(entity.getMaxUsers());
		dto.setName(entity.getName());
		dto.setPlanId(entity.getPlanId());
		dto.setPrice(entity.getPrice());
		return dto;
	}
}
