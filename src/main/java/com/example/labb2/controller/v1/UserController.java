package com.example.labb2.controller.v1;

import com.example.labb2.dto.model.UserDto;
import com.example.labb2.model.user.User;
import com.example.labb2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService userService){
        this.service = userService;
    }

    @GetMapping("{id}")
    public Optional<UserDto> getLocation(@PathVariable long id){
        return service.getUserById(id);
    }
}
