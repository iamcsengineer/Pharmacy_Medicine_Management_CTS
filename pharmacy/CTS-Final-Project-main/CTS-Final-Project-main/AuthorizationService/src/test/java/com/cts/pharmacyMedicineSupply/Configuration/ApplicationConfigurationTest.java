package com.cts.pharmacyMedicineSupply.Configuration;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cts.pharmacyMedicineSupply.model.UserData;
import com.cts.pharmacyMedicineSupply.service.AdminDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationConfigurationTest {


	@Autowired(required = true)
	AdminDetailsService adminDetailsService;

	@Test
	public void contextLoads() {

		assertNotNull(adminDetailsService);

	}

	@Test
	public void loadUserByUsernameTestSuccess() {

		assertEquals("admin", adminDetailsService.loadUserByUsername("admin").getUsername());
	}

	@Test(expected = UsernameNotFoundException.class)
	public void loadUserByUsernameTestFail() {

		assertEquals("randomUser", adminDetailsService.loadUserByUsername("randomUser").getUsername());
	}
}
