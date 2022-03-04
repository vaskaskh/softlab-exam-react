package com.example.softlabexam.service;

import com.example.softlabexam.model.Student;
import com.example.softlabexam.model.Teacher;
import com.example.softlabexam.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }
    public Teacher postTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    public Teacher get(int id) {
        return teacherRepository.findById(id).orElseThrow();
    }
    public void deleteTeacher(int id) {
        teacherRepository.delete(get(id));
    }
    public Teacher updateTeacher(Teacher teacher) {
        get(teacher.getId());
        return teacherRepository.save(teacher);
    }
}
