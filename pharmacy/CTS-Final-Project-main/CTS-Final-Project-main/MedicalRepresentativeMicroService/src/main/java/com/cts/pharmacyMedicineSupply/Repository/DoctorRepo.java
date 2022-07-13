package com.cts.pharmacyMedicineSupply.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pharmacyMedicineSupply.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

}
