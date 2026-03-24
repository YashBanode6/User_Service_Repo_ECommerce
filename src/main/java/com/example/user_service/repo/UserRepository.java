package com.example.user_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByEmail(String email);
}
