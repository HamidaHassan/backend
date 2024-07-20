package com.Project.Online.farmer.repository;

import com.Project.Online.farmer.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer,Long> {

}