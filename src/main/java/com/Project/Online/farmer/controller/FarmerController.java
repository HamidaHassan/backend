package com.Project.Online.farmer.controller;

import com.Project.Online.farmer.model.Farmer;
import com.Project.Online.farmer.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmer/")

public class FarmerController {
    @Autowired
    public FarmerService farmerService;
    @PostMapping("add")
    public ResponseEntity<Farmer> postFarmer(@RequestBody Farmer farmer){
        try {
            Farmer saveFarmer =farmerService.postFarmer(farmer);
            return ResponseEntity.ok(saveFarmer);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
//    public Student postStudent(@RequestBody Student student){
//        return studentService.postStudent(student);
    }
    @GetMapping("all")
    public ResponseEntity<List<Farmer>>getAllFarmers(){
        List<Farmer> fmr = farmerService.getAllFarmers();
        return new ResponseEntity<>(fmr, HttpStatus.OK);
    }
    @GetMapping("get/{id}")
    public Optional<Farmer> findById(@PathVariable Long id){
        return farmerService.findByFarmerId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable Long id, @RequestBody Farmer farmer) {
        farmer.setId(id);
        Farmer updateFarmer = farmerService.updateFarmer(farmer);
        return new ResponseEntity<>(updateFarmer, HttpStatus.OK);
    }

    @DeleteMapping("ById/{id}")
    public ResponseEntity<?>deleteFarmer(@PathVariable Long id){
        farmerService.deleteFarmer(id);
        return new ResponseEntity<>("Successful deleted",HttpStatus.OK);
    }
}
