package com.cts.pharmacyMedicineSupply.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.pharmacyMedicineSupply.model.MedicalRep;
@Service

public class MedicalRepService {
	
	public MedicalRepService() {
		// TODO Auto-generated constructor stub
	}
	public List<MedicalRep> sendRep(){
		List<MedicalRep> medicalRep=new ArrayList<>();
		medicalRep.add(new MedicalRep("R1","9874563210"));
		medicalRep.add(new MedicalRep("R2","9874563210"));
		medicalRep.add(new MedicalRep("R3","9874563210"));		
		return medicalRep;
	}
}
