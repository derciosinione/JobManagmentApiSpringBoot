package com.kiari.jobmanagement.modules.company.useCases;

import com.kiari.jobmanagement.exceptions.ResourceAlreadyExistsException;
import com.kiari.jobmanagement.modules.company.entities.CompanyEntity;
import com.kiari.jobmanagement.modules.company.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCompanyUseCase {

    private final ICompanyRepository repository;

    public CompanyEntity execute(CompanyEntity entity) {

        repository.findByNameOrEmail(entity.getName(), entity.getEmail())
                .ifPresent(x -> {
                    throw new ResourceAlreadyExistsException();
                });

        return repository.save(entity);
    }
}
