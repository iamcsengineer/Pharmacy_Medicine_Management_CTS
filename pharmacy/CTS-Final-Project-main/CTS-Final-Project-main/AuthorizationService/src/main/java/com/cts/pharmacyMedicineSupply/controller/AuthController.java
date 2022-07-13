package com.cts.pharmacyMedicineSupply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pharmacyMedicineSupply.dto.AuthResponse;
import com.cts.pharmacyMedicineSupply.model.UserData;
import com.cts.pharmacyMedicineSupply.service.AdminDetailsService;
import com.cts.pharmacyMedicineSupply.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthController {
	/**
	 * This is a private field of type JwtUtil class which provides the
	 * utilities for the token like get token, validate token, expiration time etc.
	 */
	@Autowired
	private JwtUtil jwtutil;
	
	/**
	 * This is a private field of type AdminDetailsService class which is
	 * used to fetch the user credentials from the database
	 */	
	@Autowired
	private AdminDetailsService adminDetailService;

	/**
	 * This method is used to check the login credentials, if there are valid,
	 * by checking against the database.
	 */		

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserData userlogincredentials) {
		log.info("START");
		log.info(userlogincredentials.getUserid()+","+userlogincredentials.getUname()+","+userlogincredentials.getUpassword());
		final UserDetails userdetails = adminDetailService.loadUserByUsername(userlogincredentials.getUserid());
		log.info(userdetails.getUsername());
		String uid = "";
		String generateToken = "";
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			uid = userlogincredentials.getUserid();
			generateToken = jwtutil.generateToken(userdetails);
			log.info(generateToken);
			log.info("END");
			return new ResponseEntity<>(new UserData(uid, null, null, generateToken), HttpStatus.OK);
		} else {
			log.info("END - Wrong credentials");
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * This method validates the token {see @JwtUtils}
	 * @param token
	 * @return
	 */

	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
		log.info("START");

		AuthResponse res = new AuthResponse();
		if (token == null) {
			res.setValid(false);
			log.info("END - Null Token");

			return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
		} else {
			String token1 = token;
			if (jwtutil.validateToken(token1)) {
				res.setUid(jwtutil.extractUsername(token1));
				res.setValid(true);
				res.setName("admin");
			} else {
				res.setValid(false);
				log.info("END - Token expired");
				return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
			}
		}
		log.info("END - Token accepted");

		return new ResponseEntity<>(res, HttpStatus.OK);

	}

}