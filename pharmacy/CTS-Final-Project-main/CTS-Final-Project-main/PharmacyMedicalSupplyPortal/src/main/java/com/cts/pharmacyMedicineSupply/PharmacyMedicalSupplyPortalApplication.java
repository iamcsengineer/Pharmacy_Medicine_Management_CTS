package com.cts.pharmacyMedicineSupply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cts.pharmacyMedicineSupply")
public class PharmacyMedicalSupplyPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyMedicalSupplyPortalApplication.class, args);
	}

}
