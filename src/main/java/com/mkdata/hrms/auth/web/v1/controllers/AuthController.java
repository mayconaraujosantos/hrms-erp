package com.mkdata.hrms.auth.web.v1.controllers;

import com.mkdata.hrms.auth.domain.dto.payload.request.LoginRequest;
import com.mkdata.hrms.auth.domain.dto.payload.request.SignupRequest;
import com.mkdata.hrms.auth.domain.dto.payload.response.JwtResponse;
import com.mkdata.hrms.auth.domain.dto.payload.response.MessageResponse;
import com.mkdata.hrms.auth.domain.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        return authService.registerUser(signupRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }
}
