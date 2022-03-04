package com.example.softlabexam.service;

import com.example.softlabexam.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeacher();
    Teacher postTeacher(Teacher teacher);
    Teacher get(int id);
    void deleteTeacher(int id);
    Teacher updateTeacher(Teacher teacher);
}
