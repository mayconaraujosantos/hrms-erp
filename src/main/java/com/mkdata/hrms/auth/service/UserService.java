package com.mkdata.hrms.auth.service;

import com.mkdata.hrms.auth.models.ERole;
import com.mkdata.hrms.auth.models.Role;
import com.mkdata.hrms.auth.models.User;
import com.mkdata.hrms.auth.payload.request.SignupRequest;
import com.mkdata.hrms.auth.payload.response.MessageResponse;
import com.mkdata.hrms.auth.repository.RoleRepository;
import com.mkdata.hrms.auth.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> registerUser(SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = createUser(signupRequest);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    private User createUser(SignupRequest signupRequest) {
        String username = signupRequest.getUsername();
        String email = signupRequest.getEmail();
        String password = signupRequest.getPassword();
        Set<String> strRoles = signupRequest.getRole();

        Set<Role> roles = new HashSet<>();

        if (strRoles == null || strRoles.isEmpty()) {
            Role userRole = getRoleByName(String.valueOf(ERole.ROLE_USER));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                Role useRole = getRoleByName(role);
                roles.add(useRole);
            });
        }

        return new User(username, email, encodePassword(password), roles);
    }

    private Role getRoleByName(String roleName) {
        return roleRepository
                .findByName(ERole.valueOf(roleName))
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
