package com.example.labb2.dto.mapper;

import com.example.labb2.dto.model.RoleDto;
import com.example.labb2.dto.model.UserDto;
import com.example.labb2.model.user.User;

import java.util.HashSet;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
