package com.rchores.rchores.repository;

import com.rchores.rchores.models.UserGroup;
import com.rchores.rchores.models.UserGroupId;
import com.rchores.rchores.models.User;
import com.rchores.rchores.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, UserGroupId> {

    // Get all UserGroup relationships for a given user
    List<UserGroup> findByUser(User user);

    // Get all UserGroup relationships for a given group
    List<UserGroup> findByGroup(Group group);

    // Check if a specific user is in a specific group
    Optional<UserGroup> findByUserAndGroup(User user, Group group);

}