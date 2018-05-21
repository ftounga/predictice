package com.tounga.predictice.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreditCardDTO {

	
	private int creditCardId;
	
	private String cardNumber;
	
	private int exp_month;
	
	private int exp_year;
	
	private String cvc;

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExp_month() {
		return exp_month;
	}

	public void setExp_month(int exp_month) {
		this.exp_month = exp_month;
	}

	public int getExp_year() {
		return exp_year;
	}

	public void setExp_year(int exp_year) {
		this.exp_year = exp_year;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	
	
}
