package com.Project.Online.farmer.repository;
import com.Project.Online.farmer.model.Farmer;
import com.Project.Online.farmer.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login, Long> {
    Optional<Login> findByUsername(String username);

}
