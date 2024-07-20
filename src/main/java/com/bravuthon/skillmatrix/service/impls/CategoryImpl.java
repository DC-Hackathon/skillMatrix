package com.bravuthon.skillmatrix.service.impls;

import com.bravuthon.skillmatrix.exception.NoDataFoundException;
import com.bravuthon.skillmatrix.mapper.CategoryMapper;
import com.bravuthon.skillmatrix.model.CategoryMasterDto;
import com.bravuthon.skillmatrix.repository.CategoryRepo;
import com.bravuthon.skillmatrix.service.CategoryInf;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class CategoryImpl implements CategoryInf {

    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    // this is only for learning purpose
    //todo: create custom errorhandler.
    Supplier<NoDataFoundException> supplier = () -> new NoDataFoundException("No data found in the DB.");

    public CategoryImpl(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryMasterDto getCategoryMaster(UUID id) {
        return categoryMapper.categoryEntityToCategoryDto(
            categoryRepo.findById(id)
                .orElseThrow(supplier)
        );
    }

    @Override
    public Set<CategoryMasterDto> getAllCategories() {
        Set<CategoryMasterDto> collect = categoryRepo.findAll()
            .stream()
            .map(categoryMapper::categoryEntityToCategoryDto)
            .collect(Collectors.toSet());

        if(collect.isEmpty())
            throw supplier.get();

        return collect;
    }
}
