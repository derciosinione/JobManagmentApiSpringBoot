package com.kiari.jobmanagement.modules.user.controller;

import com.kiari.jobmanagement.modules.user.entities.UserEntity;
import com.kiari.jobmanagement.modules.user.useCases.CreateUserUseCase;
import com.kiari.jobmanagement.modules.user.useCases.GetAllUsersUseCase;
import com.kiari.jobmanagement.modules.user.useCases.GetUserByIdUseCase;
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
public class UserController {

    final CreateUserUseCase createUserUseCase;
    final GetAllUsersUseCase getAllUsersUseCase;
    final GetUserByIdUseCase getUserByIdUseCase;

    @GetMapping({"", "/"})
    public ResponseEntity<List<UserEntity>> getAllUser() {
        var data = getAllUsersUseCase.execute();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable UUID id) {
        var data = getUserByIdUseCase.execute(id);
        return ResponseEntity.ok(data);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserEntity> CreateUser(@Valid @RequestBody UserEntity request) {

        var response = createUserUseCase.execute(request);

        return ResponseEntity
                .created(URI.create("/users/" + response.getId()))
                .body(response);
    }

}
