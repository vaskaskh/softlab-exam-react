package com.example.softlabexam.service;

import com.example.softlabexam.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudent();
    Student postStudent(Student student);
    Student get(int id);
    void deleteStudent(int id);
    Student updateStudent(Student student);

}
