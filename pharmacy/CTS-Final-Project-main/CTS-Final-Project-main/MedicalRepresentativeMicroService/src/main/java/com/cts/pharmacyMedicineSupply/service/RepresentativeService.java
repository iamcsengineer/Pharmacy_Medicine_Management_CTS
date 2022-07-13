package com.cts.pharmacyMedicineSupply.service;

import java.util.List;


import com.cts.pharmacyMedicineSupply.dto.RepSchedule;


public interface RepresentativeService {

	//List<RepSchedule> listschedule(LocalDate startDate);
	List<RepSchedule> listschedule(String startDate);

	boolean isSessionValid(String token);
}
