package com.tounga.predictice.bean;

import com.tounga.predictice.dto.CreditCardDTO;

public class StripeRequest {
private float amount;
private String currency;
private CreditCardDTO creditCard;


public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public CreditCardDTO getCreditCard() {
	return creditCard;
}
public void setCreditCard(CreditCardDTO creditCard) {
	this.creditCard = creditCard;
}

}
