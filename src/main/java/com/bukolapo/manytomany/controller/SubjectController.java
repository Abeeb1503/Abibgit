package com.bukolapo.manytomany.controller;

import com.bukolapo.manytomany.dto.SaveRequest;
import com.bukolapo.manytomany.model.Student;
import com.bukolapo.manytomany.model.Subject;
import com.bukolapo.manytomany.repositories.StudentRepository;
import com.bukolapo.manytomany.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class SubjectController implements Serializable {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @GetMapping("/subjects")
    public List<Subject> getSubjects( )
    {
        return subjectRepository.getAllSubjects();
    }
    @GetMapping("/subjects/{id}")
    public Subject getSubjectById(@PathVariable int id)
    {
        return subjectRepository.getSubjectById(id);
    }
    @PostMapping("/addsubjects")
    public String PostSubject(@RequestBody SaveRequest request)

    {

        Set<Student> studentSet=new HashSet<>();
        Set<Subject> subjectSet=new HashSet<>();

        Subject subject=new Subject();
        Student student=new Student();

        subject.setName(request.getName());
        subjectSet.add(subject);

        student.setName(request.getName());
        studentSet.add(student);


        subject.setStudents(studentSet);
        student.setSubjects(subjectSet);

        subjectRepository.save(subject);
        studentRepository.save(student);
        return " Student and Subject Created";
    }
    public void UpdateSubject(Subject sub)
    {
        subjectRepository.save(sub);
    }
    public void DeleteSubject(int id)
    {
        Subject s=subjectRepository.getSubjectById(id);
        subjectRepository.delete(s);
    }
}
