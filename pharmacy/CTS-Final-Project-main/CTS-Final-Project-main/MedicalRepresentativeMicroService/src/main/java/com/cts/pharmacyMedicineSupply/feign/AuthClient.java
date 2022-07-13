package com.cts.pharmacyMedicineSupply.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pharmacyMedicineSupply.model.AuthResponse;

@FeignClient(name = "authorization-service", url = "http://localhost:9095")
public interface AuthClient {
	@GetMapping(value = "/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);
}
