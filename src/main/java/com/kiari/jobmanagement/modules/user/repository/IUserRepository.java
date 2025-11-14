package com.kiari.jobmanagement.modules.user.repository;

import com.kiari.jobmanagement.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsernameOrEmail(String username, String email);
}
