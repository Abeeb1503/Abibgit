package com.bukolapo.manytomany.repositories;

import com.bukolapo.manytomany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {




    @Query("select s from Student s")
    List<Student> getAllStudents();
    @Query("select s from Student s where s.id=:id")
    Student getStudentById(@Param("int") int id);
}
