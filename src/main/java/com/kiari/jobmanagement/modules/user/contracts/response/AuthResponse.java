package com.kiari.jobmanagement.modules.user.contracts.response;

import lombok.Builder;

@Builder
public record AuthResponse(String email, String token) {
}
