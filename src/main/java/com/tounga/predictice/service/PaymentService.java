package com.tounga.predictice.service;

public interface PaymentService<T> {

	public void makePayment(T paymentRequest) throws Exception;
}
