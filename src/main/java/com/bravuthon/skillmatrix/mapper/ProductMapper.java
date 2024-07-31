package com.bravuthon.skillmatrix.mapper;

import com.bravuthon.skillmatrix.entity.CategoryMasterEntity;
import com.bravuthon.skillmatrix.entity.ProductMasterEntity;
import com.bravuthon.skillmatrix.entity.UserEntity;
import com.bravuthon.skillmatrix.model.CategoryMasterDto;
import com.bravuthon.skillmatrix.model.ProductMasterDto;
import com.bravuthon.skillmatrix.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "functionMasterEntity.id", target = "functionMaster")
    ProductMasterDto productMasterEntityToDto(ProductMasterEntity productMasterEntity);

    @Mapping(source = "skillMasterEntitySet", target = "skillMasterSet")
    CategoryMasterDto categoryEntityToCategoryDto(CategoryMasterEntity categoryMasterEntity);

    @Mapping(source = "userSkillEntity", target = "userSkillDto")
    UserDto userEntityToDto(UserEntity userEntity);


}
