package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ProductInf {
    ResponseEntity<?> saveProduct(ProductRequest productRequest);

    ResponseEntity<?> getAllProduct();
}
