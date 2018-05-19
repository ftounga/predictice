package com.tounga.predictice.repositoryImpl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tounga.predictice.entity.PlanEntity;
import com.tounga.predictice.repository.PlanRepository;

@Transactional
@Repository
public class PlanRepositoryImpl implements PlanRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<PlanEntity> findPlanById(int planId) {
		return Optional.ofNullable(entityManager.find(PlanEntity.class, planId));
	}

	@Override
	public void deletePlanEntity(int planId) {
		entityManager.remove(findPlanById(planId));
	}

	@Override
	public void savePlanEntity(PlanEntity plan) {
		entityManager.persist(plan);
	}

}
