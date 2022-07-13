package com.cts.pharmacyMedicineSupply.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.pharmacyMedicineSupply.model.UserData;
import com.cts.pharmacyMedicineSupply.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;

@Service
@Slf4j
public class AdminDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	/*
	 * Get UserData using JpaRepository, to get data by username,
	 * throw exceptions if user not found
	 */
	@Override
	public UserDetails loadUserByUsername(String uid){
		log.info("START");
		try {
			UserData custuser = userRepository.findById(uid).orElse(null);
			List<UserData> u=userRepository.findAll();
			for(int i=0;i<u.size();i++) {
			System.out.println(u.get(i).getUserid());
			}
			System.out.println(userRepository.count());
			log.info("USER ID IS:"+uid);
			log.info("CUST NAME IS:"+custuser.getUname());
			if (custuser != null) {
				custuser.getUname();
				log.info("END - User found");
				return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
			} else {
				log.info("END - UsernameNotFound");
				throw new UsernameNotFoundException("UsernameNotFoundException");
			}
		} catch (Exception e) {
			log.info("EXCEPTION - UsernameNotFoundException");
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}

	}

}
