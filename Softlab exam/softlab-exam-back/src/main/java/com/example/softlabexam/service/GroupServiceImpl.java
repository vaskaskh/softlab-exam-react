package com.example.softlabexam.service;

import com.example.softlabexam.model.Group;
import com.example.softlabexam.model.Student;
import com.example.softlabexam.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;

    public List<Group> getGroup() {
        return groupRepository.findAll();
    }
    public Group postGroup(Group group) {
        return groupRepository.save(group);
    }
    public Group get(int id) {
        return groupRepository.findById(id).orElseThrow();
    }
    public void deleteGroup(int id) {
        groupRepository.delete(get(id));
    }
    public Group updateGroup(Group group) {
        get(group.getId());
        return groupRepository.save(group);
    }
}
