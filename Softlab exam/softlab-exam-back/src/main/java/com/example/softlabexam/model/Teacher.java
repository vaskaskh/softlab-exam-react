package com.example.softlabexam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teachers")
@SequenceGenerator(name = "teachersIdGenerator", sequenceName = "teachers_id_seq", allocationSize = 1)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachersIdGenerator")
    public Integer id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
    @Column(name = "email")
    public String email;
    @Column(name = "personal_no")
    public Integer personalNo;
    @Column(name = "birth_date")
    public LocalDate birthDate;
}
