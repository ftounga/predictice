package com.tounga.predictice.bean;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.tounga.predictice.dto.CreditCardDTO;

public class StripeClient {

	public StripeClient(String stripeKey) {
		Stripe.apiKey = stripeKey;
	}

	public Charge chargeCreditCard(StripeRequest stripeRequest) throws Exception {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", (int) (stripeRequest.getAmount() * 100));
		chargeParams.put("currency", stripeRequest.getCurrency());
		chargeParams.put("source", createToken(stripeRequest.getCreditCard()).getId());
		Charge charge = Charge.create(chargeParams);
		return charge;
	}

	private Token createToken(CreditCardDTO creditCard) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {

		Map<String, Object> tokenParams = new HashMap<String, Object>();
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.put("number", creditCard.getCardNumber());
		cardParams.put("exp_month", creditCard.getExp_month());
		cardParams.put("exp_year", creditCard.getExp_year());
		cardParams.put("cvc", creditCard.getCvc());
		tokenParams.put("card", cardParams);
		return Token.create(tokenParams);
	}
}