package com.kpvala.userrestapi.mapper;

import com.kpvala.userrestapi.dto.UserDto;
import com.kpvala.userrestapi.entity.User;

public class UserMapper {
	public static UserDto mapTOUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
