package com.Project.Online.farmer.service;
import com.Project.Online.farmer.model.Login;
import com.Project.Online.farmer.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    public LoginRepo loginRepo;
    public Optional<Login> authenticate(String username, String password) {
        return loginRepo.findByUsername(username)
                .filter(login -> login.getPassword().equals(password));
    }
}