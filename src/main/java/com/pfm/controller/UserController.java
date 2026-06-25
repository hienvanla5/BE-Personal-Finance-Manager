package com.pfm.controller;

import com.pfm.dto.response.ApiResponse;
import com.pfm.dto.response.UserResponse;
import com.pfm.entity.User;
import com.pfm.security.CustomUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User Controller", description = "User manager")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Operation(summary = "Create a new user")
    @PostMapping
    public String createUser() {
        return "ok";
    }

    @Operation(summary = "Get list user")
    @GetMapping
    public String getUsers() {
        return "ok";
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserResponse>> me(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        User user = userDetails.getUser();
        UserResponse response = new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName()
        );

        return ResponseEntity.ok(
                ApiResponse.<UserResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("User retrieved successfully")
                        .data(response)
                        .build()
        );
    }
}
