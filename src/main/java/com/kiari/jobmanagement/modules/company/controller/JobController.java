package com.kiari.jobmanagement.modules.company.controller;

import com.kiari.jobmanagement.modules.company.entities.JobEntity;
import com.kiari.jobmanagement.modules.company.useCases.jobs.CreateJobUseCase;
import com.kiari.jobmanagement.modules.company.useCases.jobs.GetAllJobsUseCase;
import com.kiari.jobmanagement.modules.company.useCases.jobs.GetJobByIdUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final CreateJobUseCase createJobUseCase;
    private final GetAllJobsUseCase getAllJobsUseCase;
    private final GetJobByIdUseCase getJobByIdUseCase;

    @GetMapping({"", "/"})
    public ResponseEntity<List<JobEntity>> getAll() {
        var data = getAllJobsUseCase.execute();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobEntity> getById(@PathVariable UUID id) {
        var data = getJobByIdUseCase.execute(id);
        return ResponseEntity.ok(data);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<JobEntity> create(@Valid @RequestBody JobEntity request) {
        var response = createJobUseCase.execute(request);

        return ResponseEntity
                .created(URI.create("/job/" + response.getId()))
                .body(response);
    }
}
