package com.rchores.rchores.dto;

public class UserGroupDto {
    private Long id;

    private String name;
    private String imageUrl;

    public UserGroupDto(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Long getGroupId() {
        return id;
    }

    public String getGroupName() {
        return name;
    }

    public String getRole() {
        return imageUrl;
    }

}
