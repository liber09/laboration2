package com.example.labb2.repository;

import com.example.labb2.dto.model.UserDto;
import com.example.labb2.model.user.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
