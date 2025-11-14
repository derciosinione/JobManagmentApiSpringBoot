package com.kiari.jobmanagement.modules.user.useCases;

import com.kiari.jobmanagement.models.UserEntity;
import com.kiari.jobmanagement.modules.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersUseCase {
    final IUserRepository repository;

    public List<UserEntity> execute() {
        return repository.findAll();
    }
}
