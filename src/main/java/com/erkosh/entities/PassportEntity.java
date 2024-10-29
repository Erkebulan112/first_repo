package com.erkosh.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passport")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "passport_number")
    @NonNull
    private long passportNumber;

    @OneToOne(mappedBy = "passport")
    private StudentEntity student;
}
