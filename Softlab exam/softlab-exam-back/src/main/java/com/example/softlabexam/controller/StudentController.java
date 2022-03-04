package com.example.softlabexam.controller;

import com.example.softlabexam.model.Student;
import com.example.softlabexam.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }
    @PostMapping
    public ResponseEntity<Student> postStudent(@RequestBody Student student) {
        return ResponseEntity.status(201).body(studentService.postStudent(student));
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int  id,
                                               @RequestBody Student student) {
        try {
            student.setId(id);
            Student dbstudent = studentService.updateStudent(student);
            return ResponseEntity.ok(dbstudent);


        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        }


        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        try {
            return ResponseEntity.ok(studentService.get(id));


        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
