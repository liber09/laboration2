package com.example.labb2.dto.mapper;

import com.example.labb2.dto.model.UserDto;
import com.example.labb2.model.User;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return new UserDto()
                .setUserId(user.getUserId())
                .setLastName(user.getLastName())
                .setFirstName(user.getFirstName());
    }
}
