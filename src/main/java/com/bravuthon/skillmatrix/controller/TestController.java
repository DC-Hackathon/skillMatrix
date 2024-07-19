package com.bravuthon.skillmatrix.controller;

import com.bravuthon.skillmatrix.entity.CategoryMasterEntity;
import com.bravuthon.skillmatrix.model.CategoryMapper;
import com.bravuthon.skillmatrix.model.CategoryMasterDto;
import com.bravuthon.skillmatrix.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/pub/test")
public class TestController {

    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    @Autowired
    public TestController(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/getTest/{id}")
    public ResponseEntity<CategoryMasterDto> getTest(@PathVariable String id) {
        CategoryMasterEntity byId = categoryRepo.findById(UUID.fromString(id));
        CategoryMasterDto categoryMasterDto = categoryMapper.categoryEntityToCategoryDto(byId);
        return ResponseEntity.ok(categoryMasterDto);
    }
}
