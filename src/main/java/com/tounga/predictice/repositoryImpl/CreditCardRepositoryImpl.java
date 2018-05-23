package com.tounga.predictice.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tounga.predictice.entity.CreditCardEntity;
import com.tounga.predictice.repository.CreditCardRepository;

@Repository
public class CreditCardRepositoryImpl implements CreditCardRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<CreditCardEntity> findCreditCardById(int organizationId) {
		return Optional.ofNullable(entityManager.find(CreditCardEntity.class, organizationId));
	}

	@Override
	public void deleteCreditCard(int creditCardId) {
		entityManager.remove(findCreditCardById(creditCardId));		
	}

	@Override
	public void saveCreditCardEntity(CreditCardEntity creditCard) {
		entityManager.persist(creditCard);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditCardEntity> findAllCreditCardEntityEntity() {
		String hql = "FROM CreditCardEntity as creditCard";
		return (List<CreditCardEntity>) entityManager.createQuery(hql).getResultList();
	}

}
