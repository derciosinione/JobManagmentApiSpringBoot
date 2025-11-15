package com.kiari.jobmanagement.modules.user.controller;

import com.kiari.jobmanagement.modules.user.contracts.request.AuthRequest;
import com.kiari.jobmanagement.modules.user.contracts.response.AuthResponse;
import com.kiari.jobmanagement.modules.user.useCases.AuthUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> auth(@Valid @RequestBody AuthRequest request)  {
        var response = authUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
