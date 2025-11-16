package com.kiari.jobmanagement.modules.user.controller;

import com.kiari.jobmanagement.modules.user.contracts.request.AuthRequest;
import com.kiari.jobmanagement.modules.user.contracts.response.AuthResponse;
import com.kiari.jobmanagement.modules.user.entities.UserEntity;
import com.kiari.jobmanagement.modules.user.useCases.AuthUseCase;
import com.kiari.jobmanagement.modules.user.useCases.CreateUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Authentication Endpoints")
public class AuthController {

    private final AuthUseCase authUseCase;
    private final CreateUserUseCase createUserUseCase;


    @PostMapping("/sign-in")
    @Operation(summary = "Authenticate user", description = "Validates the user's email and password and returns a JWT token if the credentials are correct.")
    public ResponseEntity<AuthResponse> auth(@Valid @RequestBody AuthRequest request)  {
        var response = authUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> CreateUser(@Valid @RequestBody UserEntity request) {

        var response = createUserUseCase.execute(request);

        return ResponseEntity
                .created(URI.create("/users/" + response.getId()))
                .body(response);
    }
}
