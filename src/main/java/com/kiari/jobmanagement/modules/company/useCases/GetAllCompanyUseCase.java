package com.kiari.jobmanagement.modules.company.useCases;

import com.kiari.jobmanagement.modules.company.entities.CompanyEntity;
import com.kiari.jobmanagement.modules.company.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCompanyUseCase {
    final ICompanyRepository repository;

    public List<CompanyEntity> execute() {
        return repository.findAll();
    }
}
