package com.tounga.predictice.service;

import java.util.List;
import java.util.Optional;
import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.dto.UserDTO;

public interface SubscriptionService {

	public void subscribe(int organizationId, int planId);
	public void unsubscribe(int organizationId);
	public Optional<String> getFeaturesByUserId(int userID);
	public List<UserDTO> findAllUsers();
	public List<OrganizationDTO> findAllOrganizations();
}
