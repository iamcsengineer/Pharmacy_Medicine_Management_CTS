package com.cts.pharmacyMedicineSupply.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "userdata")
public class UserData {

	@Id
	//@Column(name = "user_id")
	private String userid;

	//@Column(name = "user_password")
	private String upassword;

	//@Column(name = "user_name")
	private String uname;

	private String authToken;
}*/

@Component
@Entity
@Table(name = "userdata")
public class UserData {

	@Id
	//@Column(name = "userId")
	private String userid;

	//@Column(name = "userPassword")
	private String upassword;

	//@Column(name = "userName")
	private String uname;

	private String authToken;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public UserData(String userid, String upassword, String uname, String authToken) {
		super();
		this.userid = userid;
		this.upassword = upassword;
		this.uname = uname;
		this.authToken = authToken;
	}

	public UserData() {

	}

}