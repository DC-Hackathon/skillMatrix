package com.bravuthon.skillmatrix.mapper;

import com.bravuthon.skillmatrix.entity.CategoryMasterEntity;
import com.bravuthon.skillmatrix.model.CategoryMasterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "skillMasterEntitySet", target = "skillMasterSet")
    CategoryMasterDto categoryEntityToCategoryDto(CategoryMasterEntity categoryMasterEntity);
}
