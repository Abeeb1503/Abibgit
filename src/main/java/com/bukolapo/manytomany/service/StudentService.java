package com.bukolapo.manytomany.service;

import com.bukolapo.manytomany.model.Student;
import com.bukolapo.manytomany.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int id)
    {
        return studentRepository.getStudentById(id);
    }
    public Student addStudent( Student student)
    {
        return studentRepository.save(student);
    }
    public void UpdateStudent(Student student)
    {
        studentRepository.save(student);
    }
    public void DeleteStudent(int id)
    {
        Student student=studentRepository.getStudentById(id);
        studentRepository.delete(student);
    }
}
