package com.example.softlabexam.service;

import com.example.softlabexam.model.Student;
import com.example.softlabexam.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    public Student postStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student get(int id) {
        return studentRepository.findById(id).orElseThrow();
    }
    public void deleteStudent(int id) {
         studentRepository.delete(get(id));
    }
    public Student updateStudent(Student student) {
        get(student.getId());
        return studentRepository.save(student);
    }
}
