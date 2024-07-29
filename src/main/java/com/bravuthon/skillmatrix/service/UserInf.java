package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserInf {

    ResponseEntity<List<UserDto>> getAllUser();

    ResponseEntity<?> getUser(UUID userId);

}
