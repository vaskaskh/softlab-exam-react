package com.example.softlabexam.service;

import com.example.softlabexam.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getGroup();
    Group postGroup(Group group);
    Group get(int id);
    void deleteGroup(int id);
    Group updateGroup(Group group);
}
