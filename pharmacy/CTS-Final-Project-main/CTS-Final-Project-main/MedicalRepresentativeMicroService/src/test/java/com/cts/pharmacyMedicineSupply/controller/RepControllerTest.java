package com.cts.pharmacyMedicineSupply.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.pharmacyMedicineSupply.service.RepresentativeServiceImpl;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class RepControllerTest {

	@InjectMocks
	private RepController repController;
	
	@Mock
	private RepresentativeServiceImpl repService;
	
	/**
	 * @throws Exception  Tests the showschedule method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testshowschedule() throws Exception{
	when(repService.isSessionValid("token")).thenReturn(true);
	ResponseEntity<?> responseEntity = repController.getSchedule("token","11-03-2021");
	HttpStatus status = responseEntity.getStatusCode();
	assertNotNull(status);
	assertEquals(HttpStatus.OK,status);
	}

}
