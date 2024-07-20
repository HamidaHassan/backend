package com.Project.Online.farmer.service;


import com.Project.Online.farmer.model.Farmer;
import com.Project.Online.farmer.repository.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {
    @Autowired
    private FarmerRepo farmerRepo;

    public Farmer postFarmer(Farmer farmer){
        return farmerRepo.save(farmer);
    }///

    public List<Farmer> getAllFarmers() {
        return  farmerRepo.findAll();
    }
    public Optional<Farmer> findByFarmerId(Long id){
        return farmerRepo.findById(id);
    }
    public Farmer updateFarmer(Farmer farmer) {
        Farmer farmer1 =farmerRepo.findById(farmer.getId())
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        farmer1.setFirstName(farmer1.getFirstName());
        farmer1.setEmail(farmer.getEmail());
        farmer1.setUsername(farmer.getUsername());
        farmer1.setLastName(farmer.getLastName());
        return farmerRepo.save(farmer);
    }
    public void deleteFarmer(Long id){
        farmerRepo.deleteById(id);
    }
}
