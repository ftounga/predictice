package com.tounga.predictice.repository;

import com.tounga.predictice.entity.PlanEntity;

public interface PlanRepository {

	public PlanEntity findPlanById(int planId);
	public void deletePlanEntity(int planId);
	public void savePlanEntity(PlanEntity plan);
}
