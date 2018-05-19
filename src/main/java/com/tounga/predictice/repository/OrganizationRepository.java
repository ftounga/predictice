package com.tounga.predictice.repository;

import com.tounga.predictice.entity.OrganizationEntity;

public interface OrganizationRepository {

	public OrganizationEntity findOrganizationById(int organizationId);
	public void deleteOrganization(int organizationId);
	public void saveOrganizationEntity(OrganizationEntity organization);
}
