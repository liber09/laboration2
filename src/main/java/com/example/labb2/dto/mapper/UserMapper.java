package com.example.labb2.dto.mapper;

import com.example.labb2.dto.model.RoleDto;
import com.example.labb2.dto.model.UserDto;
import com.example.labb2.model.user.User;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return new UserDto()
                .setLastName(user.getLastName())
                .setFirstName(user.getFirstName())
                .setRoles(new HashSet<RoleDto>(user
                        .getRoles()
                        .stream()
                        .map(role -> new ModelMapper().map(role, RoleDto.class))
                        .collect(Collectors.toSet())));
    }
}
