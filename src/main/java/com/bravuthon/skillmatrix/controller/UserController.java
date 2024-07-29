package com.bravuthon.skillmatrix.controller;

import com.bravuthon.skillmatrix.model.UserDto;
import com.bravuthon.skillmatrix.service.UserInf;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserInf userInf;

    public UserController(UserInf userInf) {
        this.userInf = userInf;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(UUID useId){
        return userInf.getUser(useId);
    }

    @GetMapping(value = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getAllUser(){
        return userInf.getAllUser();
    }

}
