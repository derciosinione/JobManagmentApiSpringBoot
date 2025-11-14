package com.kiari.jobmanagement.modules.user;

import com.kiari.jobmanagement.exceptions.ResourceAlreadyExistsException;
import com.kiari.jobmanagement.exceptions.UserNotFoundException;
import com.kiari.jobmanagement.models.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    final IUserRepository repository;

    @GetMapping({"", "/"})
    public ResponseEntity<List<UserEntity>> getAllUser() {
        var users = repository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable UUID id) {

        var user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %s not found", id)));

        return ResponseEntity.ok(user);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserEntity> CreateUser(@Valid @RequestBody UserEntity userEntity) {

       repository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail())
               .ifPresent(user -> {
                   throw new ResourceAlreadyExistsException();
               });

        var user = repository.save(userEntity);

        return ResponseEntity
                .created(URI.create("/users/" + user.getId()))
                .body(user);
    }

}
