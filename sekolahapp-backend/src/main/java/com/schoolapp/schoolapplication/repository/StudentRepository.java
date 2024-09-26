package com.schoolapp.schoolapplication.repository;

import com.schoolapp.schoolapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Student entities.
 */
@EnableJpaRepositories
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
