package com.pfm.controller;

import com.pfm.dto.response.UserResponse;
import com.pfm.entity.User;
import com.pfm.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/me")
    public UserResponse me(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        User user = userDetails.getUser();

        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName()
        );
    }
}
