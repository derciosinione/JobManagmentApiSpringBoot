package com.kiari.jobmanagement.modules.company.useCases.jobs;

import com.kiari.jobmanagement.exceptions.ResourceNotFoundException;
import com.kiari.jobmanagement.modules.company.entities.JobEntity;
import com.kiari.jobmanagement.modules.company.repository.IJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetJobByIdUseCase {
    final IJobRepository repository;

    public JobEntity execute(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Job with id %s not found", id)));
    }
}
