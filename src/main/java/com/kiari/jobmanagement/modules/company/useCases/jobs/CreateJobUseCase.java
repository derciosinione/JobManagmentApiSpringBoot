package com.kiari.jobmanagement.modules.company.useCases.jobs;

import com.kiari.jobmanagement.modules.company.entities.JobEntity;
import com.kiari.jobmanagement.modules.company.repository.IJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateJobUseCase {

    private final IJobRepository repository;

    public JobEntity execute(JobEntity entity) {
        return repository.save(entity);
    }
}
