package com.kiari.jobmanagement.modules.company.useCases.jobs;

import com.kiari.jobmanagement.modules.company.entities.CompanyEntity;
import com.kiari.jobmanagement.modules.company.entities.JobEntity;
import com.kiari.jobmanagement.modules.company.repository.ICompanyRepository;
import com.kiari.jobmanagement.modules.company.repository.IJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllJobsUseCase {
    final IJobRepository repository;

    public List<JobEntity> execute() {
        return repository.findAll();
    }
}
