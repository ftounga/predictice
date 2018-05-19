package com.tounga.predictice.service;

import java.util.Optional;

public interface SubscriptionService {

	public void subscribe(int organizationId, int planId);
	public void unsubscribe(int organizationId);
	public Optional<String> getFeaturesByUserId(int userID);
}
