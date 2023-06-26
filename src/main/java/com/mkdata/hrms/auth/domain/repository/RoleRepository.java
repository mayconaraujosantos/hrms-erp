package com.mkdata.hrms.auth.domain.repository;

import com.mkdata.hrms.auth.domain.models.ERole;
import com.mkdata.hrms.auth.domain.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
