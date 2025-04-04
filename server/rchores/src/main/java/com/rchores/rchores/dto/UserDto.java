package com.rchores.rchores.dto;

import com.rchores.rchores.models.User;

public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.enabled = user.isEnabled();
    }

    public UserDto(Long id, String email, String firstName, String lastName, boolean enabled) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
    }

    // Getters (no setters if you want it immutable)
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getEnabled() {
        return enabled;
    }
}
