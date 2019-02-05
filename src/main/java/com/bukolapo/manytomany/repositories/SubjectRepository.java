package com.bukolapo.manytomany.repositories;

import com.bukolapo.manytomany.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query("select s from Subject s")
    List<Subject> getAllSubjects();
    @Query("select  s from Subject where s.id=:id")
    Subject getSubjectById(@Param("id") int id);
}
