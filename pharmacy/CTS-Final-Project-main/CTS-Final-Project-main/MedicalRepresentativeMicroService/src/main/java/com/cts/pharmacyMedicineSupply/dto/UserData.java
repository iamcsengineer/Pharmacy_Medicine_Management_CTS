package com.cts.pharmacyMedicineSupply.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserData {
	/**
	 * Id for user
	 */

	private String userid;
	/**
	 * Password for user
	 */
	private String upassword;
	/**
	 * Name for user
	 */
	private String uname;
	/**
	 * Generated authentication token for the user
	 */
	private String authToken;
}
