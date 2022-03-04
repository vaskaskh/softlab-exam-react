package com.example.softlabexam.repository;

import com.example.softlabexam.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository <Teacher, Integer> {

}
