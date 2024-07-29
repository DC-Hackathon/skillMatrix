package com.bravuthon.skillmatrix.repository;

import com.bravuthon.skillmatrix.entity.FunctionMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FunctionRepo extends JpaRepository<FunctionMasterEntity, Object> {
//    List<FunctionMasterEntity> getAllFunction();

    Optional<FunctionMasterEntity> findById(UUID fId);
}
