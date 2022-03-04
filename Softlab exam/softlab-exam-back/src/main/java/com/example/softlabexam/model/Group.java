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
@Table(name = "groups")
@SequenceGenerator(name = "groupIdGenerator", sequenceName = "groups_id_seq", allocationSize = 1)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupIdGenerator")
    public Integer id;
    @Column(name = "personal_no")
    public Integer personalNo;
    @Column(name = "group_no")
    public Integer groupNo;
}
