package com.kiari.jobmanagement.modules.user.useCases;

import com.kiari.jobmanagement.exceptions.ResourceNotFoundException;
import com.kiari.jobmanagement.modules.user.entities.UserEntity;
import com.kiari.jobmanagement.modules.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase {
    final IUserRepository repository;

    public UserEntity execute(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with id %s not found", id)));
    }
}
