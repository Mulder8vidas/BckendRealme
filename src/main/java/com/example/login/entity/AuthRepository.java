package com.example.login.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository  extends JpaRepository<AuthEntity,Integer> {


    Optional<AuthEntity> findByUsername(String username);
}
