package com.mkdata.hrms.auth.domain.dto.payload.request;

import java.util.Set;

public record SignupRequest(String username, String email, String password, Set<String> roles) {}
