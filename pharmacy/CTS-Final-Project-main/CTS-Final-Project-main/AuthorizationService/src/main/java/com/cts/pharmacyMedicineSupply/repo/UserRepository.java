package com.cts.pharmacyMedicineSupply.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pharmacyMedicineSupply.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {

}