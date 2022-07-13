package com.cts.pharmacyMedicineSupply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pharmacyMedicineSupply.dto.RepSchedule;
import com.cts.pharmacyMedicineSupply.dto.UserData;
import com.cts.pharmacyMedicineSupply.service.RepresentativeService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RepController {
	
	@Autowired
	UserData admin;
	//This reference is connected to service class 
	@Autowired
	RepresentativeService repService;
	
	
	
	@GetMapping("/RepSchedule")
	//public List<RepSchedule> getSchedule(@RequestHeader("Authorization") String token,@RequestParam String date) {
	public ResponseEntity<?> getSchedule(@RequestHeader("Authorization") String token,@RequestParam String date) {
		log.info("In Progress to get the schedule");
		if (repService.isSessionValid(token)) {
			log.info("TOKEN IS ACCEPTED NOW TAKING LIST");
			List<RepSchedule> schedule=repService.listschedule(date);
			//return repService.listschedule(date);
			for(int i=0;i<schedule.size();i++) {
				System.out.println(i+":"+schedule.get(i).getDoctorName());
			}
			return new ResponseEntity<>(repService.listschedule(date), HttpStatus.OK);
		}
		log.info("///////////////////////////////////not accepted token///");
		log.info("Got the schedule");
		return null;
	}
}
