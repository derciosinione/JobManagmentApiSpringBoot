package com.kiari.jobmanagement.modules.user.controller;

import com.kiari.jobmanagement.modules.user.entities.UserEntity;
import com.kiari.jobmanagement.modules.user.useCases.CreateUserUseCase;
import com.kiari.jobmanagement.modules.user.useCases.GetAllUsersUseCase;
import com.kiari.jobmanagement.modules.user.useCases.GetUserByIdUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
//@SecurityRequirement(name = "jwt_auth")
public class UserController {

    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @GetMapping("")
    public ResponseEntity<List<UserEntity>> getAllUser() {
        var data = getAllUsersUseCase.execute();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable UUID id) {
        var data = getUserByIdUseCase.execute(id);
        return ResponseEntity.ok(data);
    }
}
