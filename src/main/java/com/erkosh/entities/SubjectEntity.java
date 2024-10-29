package com.erkosh.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subject")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "subject_name")
    @NonNull
    private String subjectName;

    @Column(name = "teacher")
    @NonNull
    private String teacher;

    @ManyToMany(mappedBy = "subjects")
    private List<StudentEntity> students;
}
