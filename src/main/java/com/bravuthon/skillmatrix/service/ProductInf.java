package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

public interface ProductInf {
    ResponseEntity<?> saveProduct(ProductRequest productRequest);

    ResponseEntity<?> getAllProduct();
    ResponseEntity<?> updateProduct(UUID id);
}
