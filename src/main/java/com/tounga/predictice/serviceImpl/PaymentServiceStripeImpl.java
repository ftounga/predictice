package com.tounga.predictice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tounga.predictice.bean.StripeClient;
import com.tounga.predictice.bean.StripeRequest;
import com.tounga.predictice.service.PaymentService;

@Service
public class PaymentServiceStripeImpl implements PaymentService<StripeRequest>{

	@Autowired
	private StripeClient stripeClient;

	@Override
	public void makePayment(StripeRequest paymentRequest) throws Exception {
		stripeClient.chargeCreditCard(paymentRequest);
	}
	
	
}
