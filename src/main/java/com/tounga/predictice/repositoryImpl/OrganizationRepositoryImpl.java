package com.tounga.predictice.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tounga.predictice.entity.OrganizationEntity;
import com.tounga.predictice.repository.OrganizationRepository;

@Transactional
@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<OrganizationEntity> findOrganizationById(int organizationId) {
		return Optional.ofNullable(entityManager.find(OrganizationEntity.class, organizationId));
	}

	@Override
	public void deleteOrganization(int organizationId) {
		entityManager.remove(findOrganizationById(organizationId));
	}

	@Override
	public void saveOrganizationEntity(OrganizationEntity organization) {
		entityManager.persist(organization);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationEntity> findAllOrganizationEntity() {
		String hql = "FROM OrganizationEntity as organization";
		return (List<OrganizationEntity>) entityManager.createQuery(hql).getResultList();
	}
}
