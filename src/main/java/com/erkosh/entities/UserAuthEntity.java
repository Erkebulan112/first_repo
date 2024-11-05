package com.erkosh.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_auth")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserAuthEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "password")
    @NonNull
    private String password;
}
