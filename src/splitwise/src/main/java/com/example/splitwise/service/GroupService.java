package com.example.splitwise.service;

import com.example.splitwise.models.*;

import com.example.splitwise.repository.GroupRepository;
import com.example.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createGroup(String name, List<Long> userId) {
        List<User> users = userRepository.findAllById(userId);

        Group group = new Group();
        group.setName(name);
        group.setUsers(users);

        return groupRepository.save(group);
    }
}
