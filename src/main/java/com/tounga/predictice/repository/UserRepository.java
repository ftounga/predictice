package com.tounga.predictice.repository;

import com.tounga.predictice.entity.UserEntity;

public interface UserRepository {

	public UserEntity findUserById(int userId);
	public void saveUserEntity(UserEntity user);
	public void deleteUserEntity(int userId);
}
