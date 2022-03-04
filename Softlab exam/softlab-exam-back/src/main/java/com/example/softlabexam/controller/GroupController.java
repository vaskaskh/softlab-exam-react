package com.example.softlabexam.controller;

import com.example.softlabexam.model.Group;
import com.example.softlabexam.model.Student;
import com.example.softlabexam.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public List<Group> getGroup() {
        return groupService.getGroup();
    }
    @PostMapping
    public ResponseEntity<Group> postGroup(@RequestBody Group group) {
        return ResponseEntity.status(201).body(groupService.postGroup(group));
    }

    @PutMapping("{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable int  id,
                                                 @RequestBody Group group) {
        try {
            group.setId(id);
            Group    dbgroup = groupService.updateGroup(group);
            return ResponseEntity.ok(dbgroup);


        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable int id) {
        try {
            groupService.deleteGroup(id);
            return ResponseEntity.noContent().build();
        }


        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<Group> getGroup(@PathVariable int id) {
        try {
            return ResponseEntity.ok(groupService.get(id));


        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
