package com.example.recipe.repository;

import com.example.recipe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByusername(String username);  // findByUsername 메서드: UserSecurityService는 사용자 ID를 조회하는 기능이 필요 -> 사용자 ID로 User 엔티티를 조회
}
