package com.erkosh.services;

import com.erkosh.dto.SubjectDTO;
import com.erkosh.entities.SubjectEntity;
import com.erkosh.mappers.SubjectMapper;
import com.erkosh.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.Subject;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    public List<SubjectDTO> getAllSubjects() {
        List<SubjectEntity> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(subjectMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SubjectDTO getSubjectById(long id) {
        SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found" + id));
        return subjectMapper.toDTO(subject);
    }

    @Transactional
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        SubjectEntity subject = subjectMapper.toEntity(subjectDTO);
        SubjectEntity newSubject = subjectRepository.save(subject);
        return subjectMapper.toDTO(newSubject);
    }

    @Transactional
    public SubjectDTO updateSubject(long id, SubjectDTO subjectDTO) {
        SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found" + id));
        subject.setSubjectName(subjectDTO.getSubjectName());
        subject.setTeacher(subjectDTO.getTeacher());
        SubjectEntity updatedEntity = subjectRepository.save(subject);
        return subjectMapper.toDTO(updatedEntity);
    }

    @Transactional
    public String deleteSubject(long id) {
        subjectRepository.deleteById(id);
        return "Subject with id + " + id + " deleted";
    }
}
