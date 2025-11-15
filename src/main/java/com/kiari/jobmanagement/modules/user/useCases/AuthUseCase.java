package com.kiari.jobmanagement.modules.user.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.kiari.jobmanagement.exceptions.BadCredentialsException;
import com.kiari.jobmanagement.exceptions.ResourceNotFoundException;
import com.kiari.jobmanagement.modules.user.contracts.request.AuthRequest;
import com.kiari.jobmanagement.modules.user.contracts.response.AuthResponse;
import com.kiari.jobmanagement.modules.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthUseCase {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${security.token.secret}")
    private String secretKey;

    @Value("${security.token.issuer}")
    private String tokenIssuer;

    public AuthResponse execute(AuthRequest request) {

        var user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadCredentialsException(String.format("User with email %s not found", request.email())));

        var passwordMatches = passwordEncoder.matches(request.password(), user.getPassword());

        if (!passwordMatches) {
            throw new BadCredentialsException();
        }

        var algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer(tokenIssuer)
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(user.getId().toString())
                .sign(algorithm);

        return new AuthResponse(request.email(), token);
    }
}
