package com.kiari.jobmanagement.modules.company.controller;

import com.kiari.jobmanagement.modules.company.entities.CompanyEntity;
import com.kiari.jobmanagement.modules.company.useCases.CreateCompanyUseCase;
import com.kiari.jobmanagement.modules.company.useCases.GetAllCompanyUseCase;
import com.kiari.jobmanagement.modules.company.useCases.GetCompanyByIdUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CreateCompanyUseCase createCompanyUseCase;
    private final GetAllCompanyUseCase getAllCompanyUseCase;
    private final GetCompanyByIdUseCase getCompanyByIdUseCase;

    @GetMapping({"", "/"})
    public ResponseEntity<List<CompanyEntity>> getAllUser() {
        var data = getAllCompanyUseCase.execute();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntity> getUserById(@PathVariable UUID id) {
        var data = getCompanyByIdUseCase.execute(id);
        return ResponseEntity.ok(data);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<CompanyEntity> CreateUser(@Valid @RequestBody CompanyEntity entity) {

        var user = createCompanyUseCase.execute(entity);

        return ResponseEntity
                .created(URI.create("/company/" + user.getId()))
                .body(user);
    }
}
