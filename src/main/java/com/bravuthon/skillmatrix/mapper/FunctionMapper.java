package com.bravuthon.skillmatrix.mapper;

import com.bravuthon.skillmatrix.entity.FunctionMasterEntity;
import com.bravuthon.skillmatrix.model.FunctionMasterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FunctionMapper {
    FunctionMapper MAPPER = Mappers.getMapper(FunctionMapper.class);

    @Mapping(source = "productMasterEntity", target = "productMasterDtos")
    FunctionMasterDto functionEntityToDto(FunctionMasterEntity functionMasterEntity);
}
