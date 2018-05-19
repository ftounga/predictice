package com.tounga.predictice.repository;

import java.util.Optional;

import com.tounga.predictice.entity.PlanEntity;

public interface PlanRepository {

	public Optional<PlanEntity> findPlanById(int planId);
	public void deletePlanEntity(int planId);
	public void savePlanEntity(PlanEntity plan);
}
