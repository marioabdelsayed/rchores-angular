package com.rchores.rchores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rchores.rchores.models.User;
import com.rchores.rchores.models.UserGroup;
import com.rchores.rchores.repository.UserGroupRepository;


@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    public List<UserGroup> getGroupsForUser(User user) {
        return userGroupRepository.findByUser(user);
    }

}
