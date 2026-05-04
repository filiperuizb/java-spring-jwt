package com.boligon.jwt_test.repository;

import com.boligon.jwt_test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String role);
}
