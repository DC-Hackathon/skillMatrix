package com.bravuthon.skillmatrix.repository;

import com.bravuthon.skillmatrix.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Object> {
    UserEntity findById(UUID userId);
}
