package com.Project.Online.farmer.controller;


import com.Project.Online.farmer.dto.RegistrationRequest;
import com.Project.Online.farmer.model.Farmer;
import com.Project.Online.farmer.model.Register;
import com.Project.Online.farmer.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/Register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegistrationRequest request) {
        Register register = new Register();
        register.setUsername(request.getUsername());
        register.setFirstName(request.getFirstName());
        register.setLastName(request.getLastName());
        register.setEmail(request.getEmail());
        register.setPassword(request.getPassword());

        Farmer farmer = new Farmer();
        farmer.setFirstName(request.getFirstName());
        farmer.setEmail(request.getEmail());
        farmer.setLastName(request.getLastName());
        farmer.setUsername(request.getUsername());

        String result = registerService.registerUser(register, farmer);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        return response;
    }
}
