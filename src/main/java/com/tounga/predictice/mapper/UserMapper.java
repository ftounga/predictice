package com.tounga.predictice.mapper;

import com.tounga.predictice.dto.UserDTO;
import com.tounga.predictice.entity.UserEntity;

public class UserMapper {

	public static UserDTO buildUserDTOFromUserEntity(UserEntity entity){
		
		UserDTO user = new UserDTO();
		user.setFirstName(entity.getFirstName());
		user.setLastName(entity.getLastName());
		user.setUserId(entity.getUserId());
		user.setOrganizationName(entity.getOrganization().getName());
		return user;
	}
}
