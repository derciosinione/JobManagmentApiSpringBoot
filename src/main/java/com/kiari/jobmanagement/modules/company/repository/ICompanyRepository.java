package com.kiari.jobmanagement.modules.company.repository;

import com.kiari.jobmanagement.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ICompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByNameOrEmail(String name, String email);
}
