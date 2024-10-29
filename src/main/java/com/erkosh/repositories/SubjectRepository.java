package com.erkosh.repositories;

import com.erkosh.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.security.auth.Subject;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
