package com.tounga.predictice.repositoryImpl;

import java.util.List;
import java.util.Optional;

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
	public Optional<UserEntity> findUserById(int userId) {
		return Optional.ofNullable(entityManager.find(UserEntity.class, userId));
	}

	@Override
	public void saveUserEntity(UserEntity user) {
		 entityManager.persist(user);
	}

	@Override
	public void deleteUserEntity(int userId) {
		entityManager.remove(findUserById(userId));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findAllUserEntity() {
		String hql = "FROM UserEntity as user";
		return (List<UserEntity>) entityManager.createQuery(hql).getResultList();
	}

}
