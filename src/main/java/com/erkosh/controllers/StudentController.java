package com.erkosh.controllers;

import com.erkosh.services.StudentService;
import com.erkosh.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable("id") long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("new-student")
    public StudentDTO newStudent(@RequestBody StudentDTO student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}/edit")
    public StudentDTO updateStudent(@PathVariable("id") long id, @RequestBody StudentDTO student) {
        studentService.updateStudent(id, student);
        return student;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return "Student deleted with id: " + id;
    }
}
