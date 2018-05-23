package com.tounga.predictice.repository;

import java.util.List;
import java.util.Optional;

import com.tounga.predictice.entity.CreditCardEntity;

public interface CreditCardRepository {

	public Optional<CreditCardEntity> findCreditCardById(int organizationId);
	public void deleteCreditCard(int creditCardId);
	public void saveCreditCardEntity(CreditCardEntity creditCard);
	public List<CreditCardEntity> findAllCreditCardEntityEntity();
}
