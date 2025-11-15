package com.kiari.jobmanagement.modules.company.repository;

import com.kiari.jobmanagement.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IJobRepository extends JpaRepository<JobEntity, UUID> {

    @EntityGraph(attributePaths = {"company"})
    List<JobEntity> findAll();
}
