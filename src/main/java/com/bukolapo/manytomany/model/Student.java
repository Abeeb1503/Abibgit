package com.bukolapo.manytomany.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Student implements Serializable{
    @Id
    @GeneratedValue
    int id;
    String studentName;

    @ManyToMany
    @JoinTable(name = "subject_student" ,joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns =@JoinColumn(name = "subject_id"))
     private Set<Subject>subjects;

    public Student() {
    }

    public Student(String name) {
        this.studentName = name;
    }

    public Student(String name, Set<Subject> subjects) {
        this.studentName = name;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
