package com.example.softlabexam.controller;

import com.example.softlabexam.model.Student;
import com.example.softlabexam.model.Teacher;
import com.example.softlabexam.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }
    @PostMapping
    public ResponseEntity<Teacher> postTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.status(201).body(teacherService.postTeacher(teacher));
    }

    @PutMapping("{id}")
    public ResponseEntity<Teacher> updatePerson(@PathVariable int  id,
                                                @RequestBody Teacher teacher) {
        try {
            teacher.setId(id);
            Teacher dbteacher = teacherService.updateTeacher(teacher);
            return ResponseEntity.ok(dbteacher);


        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        try {
            teacherService.deleteTeacher(id);
            return ResponseEntity.noContent().build();
        }


        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int id) {
        try {
            return ResponseEntity.ok(teacherService.get(id));


        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
