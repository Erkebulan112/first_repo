package com.erkosh.services;

import com.erkosh.entities.StudentEntity;
import com.erkosh.repositories.StudentRepository;
import com.erkosh.dto.StudentDTO;
import jakarta.persistence.EntityNotFoundException;
import com.erkosh.mappers.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(long id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found " + id));
        return studentMapper.toDTO(student);
    }

    @Transactional
    public StudentDTO addStudent(StudentDTO studentDTO) {
        StudentEntity student = studentMapper.toEntity(studentDTO);
        StudentEntity newStudent = studentRepository.save(student);
        return studentMapper.toDTO(newStudent);
    }

    @Transactional
    public StudentDTO updateStudent(long id, StudentDTO studentDTO) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found " + id));
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        StudentEntity updatedStudent = studentRepository.save(student);
        return studentMapper.toDTO(updatedStudent);
    }

    @Transactional
    public void deleteStudent(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else
            throw new EntityNotFoundException("Student not found " + id);
    }
}
