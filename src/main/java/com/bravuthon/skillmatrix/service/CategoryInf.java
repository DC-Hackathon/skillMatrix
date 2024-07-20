package com.bravuthon.skillmatrix.service;

import com.bravuthon.skillmatrix.model.CategoryMasterDto;

import java.util.Set;
import java.util.UUID;

public interface CategoryInf {

    CategoryMasterDto getCategoryMaster(UUID id);

    Set<CategoryMasterDto> getAllCategories();

}
