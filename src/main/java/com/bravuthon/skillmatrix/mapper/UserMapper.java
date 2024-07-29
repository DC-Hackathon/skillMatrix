package com.bravuthon.skillmatrix.mapper;

import com.bravuthon.skillmatrix.entity.UserEntity;
import com.bravuthon.skillmatrix.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userSkillEntities", target = "userSkillDto")
    UserDto userEntityToDto(UserEntity userEntity);
}
