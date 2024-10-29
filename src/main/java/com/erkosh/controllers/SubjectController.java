package com.erkosh.controllers;

import com.erkosh.dto.SubjectDTO;
import com.erkosh.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    public SubjectDTO getSubjectById(@PathVariable("id") long id) {
        return subjectService.getSubjectById(id);
    }

    public SubjectDTO createSubject(@RequestBody SubjectDTO subject) {
        subjectService.createSubject(subject);
        return subject;
    }

    public SubjectDTO updateSubject(@PathVariable("id") long id, @RequestBody SubjectDTO subject) {
        subjectService.updateSubject(id, subject);
        return subject;
    }

    public void deleteSubject(@PathVariable("id") long id) {
        subjectService.deleteSubject(id);
    }
}
