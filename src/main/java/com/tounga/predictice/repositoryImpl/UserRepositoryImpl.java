package com.tounga.predictice.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tounga.predictice.entity.UserEntity;
import com.tounga.predictice.repository.UserRepository;

@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public UserEntity findUserById(int userId) {
		return entityManager.find(UserEntity.class, userId);
	}

	@Override
	public void saveUserEntity(UserEntity user) {
		 entityManager.persist(user);
	}

	@Override
	public void deleteUserEntity(int userId) {
		entityManager.remove(findUserById(userId));
		
	}

}
