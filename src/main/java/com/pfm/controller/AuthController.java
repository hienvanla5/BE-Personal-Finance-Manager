package com.pfm.controller;

import com.pfm.dto.request.LoginRequest;
import com.pfm.dto.request.RegisterRequest;
import com.pfm.dto.response.ApiResponse;
import com.pfm.dto.response.AuthResponse;
import com.pfm.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth Controller", description = "Auth manager")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(
            @Valid @RequestBody RegisterRequest request
    ) {
        String result = authService.register(request);

        ApiResponse<String> response = ApiResponse.<String>builder()
                .status(HttpStatus.CREATED.value())
                .message("Register successful")
                .data(result)
                .errors(null)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @Valid @RequestBody LoginRequest request
    ) {
        String token = authService.login(request);

        ApiResponse<AuthResponse> response = ApiResponse.<AuthResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Login successful")
                .data(new AuthResponse(token))
                .errors(null)
                .build();

        return ResponseEntity.ok(response);
    }
}
