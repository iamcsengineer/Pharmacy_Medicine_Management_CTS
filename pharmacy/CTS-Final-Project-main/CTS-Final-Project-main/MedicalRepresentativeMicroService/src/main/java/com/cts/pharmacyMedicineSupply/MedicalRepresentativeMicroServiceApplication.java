package com.cts.pharmacyMedicineSupply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MedicalRepresentativeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalRepresentativeMicroServiceApplication.class, args);
	}

}
