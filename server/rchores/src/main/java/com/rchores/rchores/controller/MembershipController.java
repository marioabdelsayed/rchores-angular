package com.rchores.rchores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rchores.rchores.dto.UserGroupDto;
import com.rchores.rchores.models.User;
import com.rchores.rchores.models.UserGroup;
import com.rchores.rchores.security.CustomUserDetails;
import com.rchores.rchores.service.UserGroupService;
import org.springframework.web.bind.annotation.GetMapping;
 
@RestController
@RequestMapping("/api/memberships")
public class MembershipController {
    @Autowired
    UserGroupService userGroupService;

    @GetMapping("/groups")
    public ResponseEntity<?> getUserGroups(@AuthenticationPrincipal CustomUserDetails userDetails) {
        System.out.println("hello");
        User user = userDetails.getUser();
        List<UserGroup> userGroups = userGroupService.getGroupsForUser(user);
        List<UserGroupDto> dtos = userGroups.stream()
                .map(ug -> new UserGroupDto(ug.getGroup().getId(), ug.getGroup().getName(),
                        ug.getGroup().getImageUrl()))
                .toList();
        return ResponseEntity.ok(dtos);
    }
    
}
