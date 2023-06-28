package com.mkdata.hrms.auth.domain.service;

import com.mkdata.hrms.auth.domain.dto.payload.request.LoginRequest;
import com.mkdata.hrms.auth.domain.dto.payload.request.SignupRequest;
import com.mkdata.hrms.auth.domain.dto.payload.response.JwtResponse;
import com.mkdata.hrms.auth.domain.dto.payload.response.MessageResponse;
import com.mkdata.hrms.auth.domain.models.ERole;
import com.mkdata.hrms.auth.domain.models.Role;
import com.mkdata.hrms.auth.domain.models.User;
import com.mkdata.hrms.auth.domain.repository.RoleRepository;
import com.mkdata.hrms.auth.domain.repository.UserRepository;
import com.mkdata.hrms.auth.infra.security.jwt.JwtUtils;
import com.mkdata.hrms.auth.infra.security.services.UserDetailsImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthService(
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    public ResponseEntity<MessageResponse> registerUser(SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.username())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.email())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User(
                signUpRequest.username(), signUpRequest.email(), passwordEncoder.encode(signUpRequest.password()));

        Set<Role> roles = determineRoles(signUpRequest.roles());
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    private Set<Role> determineRoles(Set<String> strRoles) {
        Set<Role> roles = new HashSet<>();
        if (strRoles == null || strRoles.isEmpty()) {
            roles.add(getRole(ERole.ROLE_USER));
        } else {
            strRoles.forEach(role -> roles.add(
                    switch (role) {
                        case "admin" -> getRole(ERole.ROLE_ADMIN);
                        case "mod" -> getRole(ERole.ROLE_MODERATOR);
                        default -> getRole(ERole.ROLE_USER);
                    }));
        }
        return roles;
    }

    private Role getRole(ERole roleName) {
        return roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {
        LOGGER.log(Level.INFO, "Starting user authentication...");

        Authentication authentication = authenticate(loginRequest);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        String jwt = jwtUtils.generateJwtToken(authentication);
        LOGGER.log(Level.INFO, "User authentication successful.");

        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    private Authentication authenticate(LoginRequest loginRequest) {
        LOGGER.log(Level.INFO, "Authenticating user {0}...", loginRequest.username());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }
}
