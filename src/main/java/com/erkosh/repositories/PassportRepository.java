package com.erkosh.repositories;

import com.erkosh.entities.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<PassportEntity, Long> {
}
