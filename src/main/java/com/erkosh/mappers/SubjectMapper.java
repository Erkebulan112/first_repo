package com.erkosh.mappers;

import com.erkosh.dto.SubjectDTO;
import com.erkosh.entities.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

//    @Mapping(target = "subjectName", source = "subjectName")
//    @Mapping(target = "teacher", source = "teacher")
    SubjectDTO toDTO(SubjectEntity subject);

    SubjectEntity toEntity(SubjectDTO dto);
}
