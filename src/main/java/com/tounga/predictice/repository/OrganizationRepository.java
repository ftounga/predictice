package com.tounga.predictice.repository;

import java.util.Optional;

import com.tounga.predictice.entity.OrganizationEntity;

public interface OrganizationRepository {

	public Optional<OrganizationEntity> findOrganizationById(int organizationId);
	public void deleteOrganization(int organizationId);
	public void saveOrganizationEntity(OrganizationEntity organization);
}
