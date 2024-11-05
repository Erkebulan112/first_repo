package com.erkosh.mappers;

import com.erkosh.dto.UserAuthDTO;
import com.erkosh.entities.UserAuthEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAuthMapper {

    UserAuthDTO toDTO(UserAuthEntity userAuthEntity);
    UserAuthEntity toEntity(UserAuthDTO userAuthDTO);
}
