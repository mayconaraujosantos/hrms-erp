package com.mkdata.hrms.auth.repository;

import com.mkdata.hrms.auth.models.ERole;
import com.mkdata.hrms.auth.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
