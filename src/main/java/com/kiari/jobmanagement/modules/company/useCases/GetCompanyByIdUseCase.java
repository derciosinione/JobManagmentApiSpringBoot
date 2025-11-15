package com.kiari.jobmanagement.modules.company.useCases;

import com.kiari.jobmanagement.exceptions.ResourceNotFoundException;
import com.kiari.jobmanagement.modules.company.entities.CompanyEntity;
import com.kiari.jobmanagement.modules.company.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCompanyByIdUseCase {
    final ICompanyRepository repository;

    public CompanyEntity execute(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Company with id %s not found", id)));
    }
}
