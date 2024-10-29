package com.erkosh.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "univer")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UniverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "university_name")
    @NonNull
    private String univerName;

    @Column(name = "location")
    @NonNull
    private String location;

//    @OneToMany(mappedBy = "univer")
//    private List<StudentEntity> students;
}
