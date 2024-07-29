package com.bravuthon.skillmatrix.repository;

import com.bravuthon.skillmatrix.entity.ProductMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductMasterEntity, Object> {


}
