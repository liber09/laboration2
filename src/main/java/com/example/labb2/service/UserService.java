package com.example.labb2.service;

import com.example.labb2.dto.model.UserDto;
import com.example.labb2.model.user.User;
import com.example.labb2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public Optional<User> getUserById(long id){

        return repository.findById(id);
    }

    static Optional<UserDto> map(Optional<User> user) {
        if(user.isEmpty()){
            return Optional.empty();
        }
        var mapUser = user.get();
        return Optional.of(
                new UserDto(mapUser.getUserId(), mapUser.getFirstName(), mapUser.getLastName())
        );
    }
}
