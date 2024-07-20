package com.bravuthon.skillmatrix.repository;

import com.bravuthon.skillmatrix.entity.CategoryMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryMasterEntity, Object> {

    Optional<CategoryMasterEntity> findById(UUID id);

}
