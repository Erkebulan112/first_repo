package com.erkosh.mappers;

import com.erkosh.entities.StudentEntity;
import com.erkosh.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

//позволит Spring автоматически внедрять маппер через DI (Dependency Injection), что упростит работу с ним.
@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(StudentEntity studentEntity);

    StudentEntity toEntity(StudentDTO studentDTO);
}
