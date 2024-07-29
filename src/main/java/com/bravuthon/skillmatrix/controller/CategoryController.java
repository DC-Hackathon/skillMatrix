package com.bravuthon.skillmatrix.controller;

import com.bravuthon.skillmatrix.model.CategoryMasterDto;
import com.bravuthon.skillmatrix.service.CategoryInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController()
@RequestMapping("/pub/category")
public class CategoryController {

    private final CategoryInf categoryInf;

    @Autowired
    public CategoryController (CategoryInf categoryInf) {
        this.categoryInf = categoryInf;
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<CategoryMasterDto> getCategory(@PathVariable String id) {
        return ResponseEntity.ok(categoryInf.getCategoryMaster(UUID.fromString(id)));
    }

    @GetMapping(value = "/allCategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CategoryMasterDto>> getAllCategory() {
        return ResponseEntity.ok(categoryInf.getAllCategories());
    }
}
