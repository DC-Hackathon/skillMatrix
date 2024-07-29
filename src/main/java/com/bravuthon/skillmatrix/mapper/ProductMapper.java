package com.bravuthon.skillmatrix.mapper;

import com.bravuthon.skillmatrix.entity.ProductMasterEntity;
import com.bravuthon.skillmatrix.model.ProductMasterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    FunctionMapper MAPPER = Mappers.getMapper(FunctionMapper.class);

    @Mapping(source = "functionMasterEntity.id", target = "functionMaster")
    ProductMasterDto productMasterEntityToDto(ProductMasterEntity productMasterEntity);

}
