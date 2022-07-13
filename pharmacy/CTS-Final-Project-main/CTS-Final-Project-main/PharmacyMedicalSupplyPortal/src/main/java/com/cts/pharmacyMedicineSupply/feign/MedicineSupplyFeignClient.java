package com.cts.pharmacyMedicineSupply.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pharmacyMedicineSupply.dto.PharmacyMedicineSupply;




@FeignClient(url="http://localhost:8083", name="medicineSupply")
public interface MedicineSupplyFeignClient {
	
	@GetMapping("/viewDemand")
	public String showSupplyHomePage(@RequestHeader("Authorization") String token);
	
	@GetMapping("/SupplyAvailed")
	public List<PharmacyMedicineSupply> showList(@RequestHeader("Authorization") String token,@RequestParam String name, @RequestParam int demand);
}
