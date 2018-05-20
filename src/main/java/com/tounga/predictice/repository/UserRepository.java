package com.tounga.predictice.repository;

import java.util.List;
import java.util.Optional;

import com.tounga.predictice.entity.UserEntity;

public interface UserRepository {

	public Optional<UserEntity> findUserById(int userId);
	public void saveUserEntity(UserEntity user);
	public void deleteUserEntity(int userId);
	public List<UserEntity> findAllUserEntity();
}
