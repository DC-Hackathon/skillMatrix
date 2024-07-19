package com.bravuthon.skillmatrix.repository;

import com.bravuthon.skillmatrix.entity.CategoryMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryMasterEntity, Object> {

    CategoryMasterEntity findById(UUID id);

}
