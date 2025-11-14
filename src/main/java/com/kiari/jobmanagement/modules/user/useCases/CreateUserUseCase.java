package com.kiari.jobmanagement.modules.user.useCases;

import com.kiari.jobmanagement.exceptions.ResourceAlreadyExistsException;
import com.kiari.jobmanagement.models.UserEntity;
import com.kiari.jobmanagement.modules.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    final IUserRepository repository;

    public UserEntity execute(UserEntity userEntity) {

//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        repository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail())
                .ifPresent(user -> {
                    throw new ResourceAlreadyExistsException();
                });

        return repository.save(userEntity);
    }
}
