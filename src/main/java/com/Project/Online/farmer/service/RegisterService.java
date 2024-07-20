package com.Project.Online.farmer.service;

import com.Project.Online.farmer.model.Farmer;
import com.Project.Online.farmer.model.Register;
import com.Project.Online.farmer.repository.FarmerRepo;
import com.Project.Online.farmer.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private FarmerRepo farmerRepo;
    @Autowired
    private RegisterRepo registerRepo;

    public String registerUser(Register register, Farmer farmer) {
        if (registerRepo.existsByUsername(register.getUsername())) {
            return "Username already taken";
        }
        if (registerRepo.existsByEmail(register.getEmail())) {
            return "Email already registered";
        }
        Register registerSave = registerRepo.save(register);

        Farmer createFarmer = new Farmer();
        createFarmer.setFirstName(registerSave.getFirstName()+ " " + registerSave.getLastName());
        createFarmer.setId(registerSave.getId());
        createFarmer.setUsername(registerSave.getLastName());
        createFarmer.setEmail(registerSave.getEmail());
        createFarmer.setLastName(registerSave.getLastName());
        Farmer savedFarmer = farmerRepo.save(createFarmer);

        return "Registration successful";
    }
}
