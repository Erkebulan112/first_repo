package com.erkosh.mappers;

import com.erkosh.dto.PassportDTO;
import com.erkosh.entities.PassportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    PassportMapper INSTANCE = Mappers.getMapper(PassportMapper.class);

    PassportDTO toDTO(PassportEntity passportEntity);

    PassportEntity toEntity(PassportDTO passportDTO);
}
