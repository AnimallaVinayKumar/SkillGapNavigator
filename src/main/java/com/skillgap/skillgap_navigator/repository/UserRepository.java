package com.skillgap.skillgap_navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillgap.skillgap_navigator.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
