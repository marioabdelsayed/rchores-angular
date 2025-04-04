package com.rchores.rchores.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserGroupId implements Serializable {
    private Long userId;
    private Long groupId;

    // ========= Constructors =========
    public UserGroupId() {
    }

    public UserGroupId(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
    // ========= Getters and Setters =========

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserGroupId))
            return false;
        UserGroupId that = (UserGroupId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, groupId);
    }

}
