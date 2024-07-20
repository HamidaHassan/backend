package com.Project.Online.farmer.repository;

import com.Project.Online.farmer.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<Register, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
