package com.erkosh.mappers;

import com.erkosh.entities.UniverEntity;
import com.erkosh.dto.UniverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UniverMapper {

    UniverMapper INSTANCE = Mappers.getMapper(UniverMapper.class);

    UniverDTO toDTO(UniverEntity univerEntity);

    UniverEntity toEntity(UniverDTO univerDTO);
}
