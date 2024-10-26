package com.mahesh.eureka.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahesh.eureka.Entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}