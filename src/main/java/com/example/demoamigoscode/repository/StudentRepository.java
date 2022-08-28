package com.example.demoamigoscode.repository;

import com.example.demoamigoscode.classes.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {
    @Query("SELECT s from Student s WHERE s.name=?1")
    Optional<Student> findStudentByName(String name);
}
