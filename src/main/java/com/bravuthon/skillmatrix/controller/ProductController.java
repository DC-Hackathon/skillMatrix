package com.bravuthon.skillmatrix.controller;

import com.bravuthon.skillmatrix.model.ProductRequest;
import com.bravuthon.skillmatrix.service.ProductInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pub/product")
public class ProductController {
    private final ProductInf productInf;

    @Autowired
    public ProductController(ProductInf productInf) {
        this.productInf = productInf;
    }

    @PostMapping(value = "/saveProduct",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequest productRequest){
        return productInf.saveProduct(productRequest);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<?> getAllProduct() {
        return productInf.getAllProduct();
    }
}
