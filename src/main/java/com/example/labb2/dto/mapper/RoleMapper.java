package com.example.labb2.dto.mapper;

import com.example.labb2.dto.model.RoleDto;
import com.example.labb2.model.user.Role;

import java.util.Collection;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoleMapper {
    public static RoleDto toRoleDto(Role role) {
        return RoleDto
                .builder()
                .role(role.getRole().toString())
                .build();
    }

    public static Collection<RoleDto> toRoleDtos(Collection<Role> roles) {
        return roles
                .stream()
                .map(RoleMapper::toRoleDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
