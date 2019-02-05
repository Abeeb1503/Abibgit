package com.bukolapo.manytomany.service;

import com.bukolapo.manytomany.model.Subject;
import com.bukolapo.manytomany.repositories.StudentRepository;
import com.bukolapo.manytomany.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SubjectService implements Serializable{
    @Autowired
    SubjectRepository subjectRepository;
    public List<Subject> getSubjects( )
    {
        return subjectRepository.getAllSubjects();
    }
    public Subject getSubjectById( int id)
    {
        return subjectRepository.getSubjectById(id);
    }
    public Subject PostSubject(Subject sub)
    {
        return subjectRepository.save(sub);
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
