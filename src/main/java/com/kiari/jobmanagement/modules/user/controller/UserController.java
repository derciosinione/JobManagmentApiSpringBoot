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
        var users = getAllUsersUseCase.execute();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable UUID id) {
        var user = getUserByIdUseCase.execute(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserEntity> CreateUser(@Valid @RequestBody UserEntity userEntity) {

        var user = createUserUseCase.execute(userEntity);

        return ResponseEntity
                .created(URI.create("/users/" + user.getId()))
                .body(user);
    }

}
