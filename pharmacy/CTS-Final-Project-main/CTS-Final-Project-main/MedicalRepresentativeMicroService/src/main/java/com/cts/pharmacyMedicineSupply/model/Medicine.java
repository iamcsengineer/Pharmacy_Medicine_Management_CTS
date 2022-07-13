package com.cts.pharmacyMedicineSupply.model;


//import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
	private String medicineName;
	private String[] chemicalComposition;
	private String targetAilment;
	//to be in LOCALDATE FORMAT
	private String dateOfExpiry;
	private int numberOfTabletsInStocks;
	
}