package com.tounga.predictice;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tounga.predictice.dto.OrganizationDTO;
import com.tounga.predictice.service.SubscriptionService;
import org.junit.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubscriptionServiceImplTest {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@Test
	public void findAllOrganizationTest() {
		List<OrganizationDTO> organizations = subscriptionService.findAllOrganizations();
		Assert.assertTrue(organizations.size() ==2);
	}
	
	@Test
	public void findAllFeaturesByUsersTest() {
		Optional<String> result = subscriptionService.getFeaturesByUserId(3);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals("F1&F2", result.get());
	}
	
	@Test
	public void unsubscritbeTest() {
		subscriptionService.unsubscribe(1);
		Optional<OrganizationDTO> organization = subscriptionService.findAllOrganizations().stream().filter(o -> o.getOrganizationId() == 1).findFirst();
		Assert.assertTrue(organization.isPresent());
		Assert.assertNull(organization.get().getPlan());
			}
	
	@Test
	public void subscritbeToPlanTest() {
		subscriptionService.subscribe(1,1);
		Optional<OrganizationDTO> organization = subscriptionService.findAllOrganizations().stream().filter(o -> o.getOrganizationId() == 1).findFirst();
		Assert.assertTrue(organization.isPresent());
		Assert.assertNotNull(organization.get().getPlan());
			}
}
