package com.hacktiv8.transportation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacktiv8.transportation.models.Role;
import com.hacktiv8.transportation.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
  Boolean existsByEmail(String email);
  List<User> findByRoles(Role roles);
}
