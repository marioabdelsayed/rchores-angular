package com.rchores.rchores.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rchores.rchores.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
