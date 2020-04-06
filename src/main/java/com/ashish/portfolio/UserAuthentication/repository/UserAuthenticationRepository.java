package com.ashish.portfolio.UserAuthentication.repository;

import com.ashish.portfolio.UserAuthentication.model.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Long> {
  Optional<UserAuthentication> findByUsername(String userName);
}
