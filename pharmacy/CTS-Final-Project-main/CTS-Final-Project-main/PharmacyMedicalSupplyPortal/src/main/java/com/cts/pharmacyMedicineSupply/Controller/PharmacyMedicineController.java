package com.cts.pharmacyMedicineSupply.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pharmacyMedicineSupply.dto.Datedto;
import com.cts.pharmacyMedicineSupply.dto.PharmacyMedicineSupply;
import com.cts.pharmacyMedicineSupply.dto.RepSchedule;
import com.cts.pharmacyMedicineSupply.dto.UserData;
import com.cts.pharmacyMedicineSupply.feign.MedicalRepMicroServiceFeign;
import com.cts.pharmacyMedicineSupply.feign.MedicineSupplyFeignClient;
import com.cts.pharmacyMedicineSupply.service.PharmacyMedicalSupplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PharmacyMedicineController {
	
	//@Autowired
	//UserData admin;
	
	private static List<String> revokedTokens=new ArrayList<String>();
	
	@Autowired
	PharmacyMedicalSupplyService pharmacyMedicalSupplyService;
	
	@Autowired
	MedicalRepMicroServiceFeign medicalRepMicroServiceFeign;
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ModelAndView getLogout(HttpSession session) {
		if (session != null && (String) session.getAttribute("token") != null
				&& pharmacyMedicalSupplyService.isSessionValid((String) session.getAttribute("token"))) {
			revokedTokens.add((String) session.getAttribute("token"));
			return new ModelAndView("login");
		}
		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView getLogin(HttpSession session) {
		log.info("Starting getLogin");
		if (session != null && (String) session.getAttribute("token") != null
				&& pharmacyMedicalSupplyService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending getLogin");
			return new ModelAndView("home");
		}
		log.info("Ending getLogin");
		return new ModelAndView("login");
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public <user> ModelAndView postLogin(HttpSession session, ModelMap model, @ModelAttribute UserData user, ModelMap warning) {
		log.info("Starting postLogin");
		log.info("Ending postLogin");
		return new ModelAndView(pharmacyMedicalSupplyService.postLogin(user, session, warning));
	}
	
	@GetMapping("/home")
	public ModelAndView homepage(HttpSession session) {
		log.info("Starting getHomePage");
		if (pharmacyMedicalSupplyService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending getHomePage");
			return new ModelAndView("home");
		}
		log.info("Ending getHomePage");
		return new ModelAndView("login");
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/checkSchedule")
	public ModelAndView checkmeeting(HttpSession session) {
		log.info("Starting showRepSch");
		if (pharmacyMedicalSupplyService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showRepSch");
			return new ModelAndView("datepage");
		}
		log.info("Ending showRepSch");
		return new ModelAndView("login");
	}
	
	@GetMapping("/checkSchedules")
	public ModelAndView showDate(HttpSession session,@ModelAttribute Datedto Date,ModelMap map) {
		ModelAndView mv=new ModelAndView("RepSchedule");
		if (pharmacyMedicalSupplyService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showRepSch");
			List<RepSchedule> schedule=medicalRepMicroServiceFeign.getSchedule((String) session.getAttribute("token"),Date.getDate());
			for(int i=0;i<schedule.size();i++) {
				System.out.println(i+":"+schedule.get(i).getDoctorName());
			}
			map.addAttribute("schedule",schedule);
			mv.addObject(schedule);
			return mv;
		}
		log.info("Ending showRepSch");
		mv.setViewName("login");
		return mv;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private MedicineSupplyFeignClient medicineSupplyFeign;
	
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public ModelAndView showSupplyPage(HttpSession session){
		log.info("Starting showSupplyPage");
		if (pharmacyMedicalSupplyService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			return new ModelAndView(medicineSupplyFeign.showSupplyHomePage((String) session.getAttribute("token")));
		}
		log.info("Ending showSupplyPage");
		return new ModelAndView("login");
	}
	@GetMapping(value="/SupplyAvailed")
	public ModelAndView showList(HttpSession session, @RequestParam String name, @RequestParam int demand,ModelMap model){
		log.info("Starting showList");
		if (pharmacyMedicalSupplyService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			List<PharmacyMedicineSupply> list=medicineSupplyFeign.showList((String) session.getAttribute("token"),name, demand);
			if(list==null) {
				model.put("errorMessage", "PAGE EXPIRED");
				log.info("Ending showList");
				return new ModelAndView ("viewDemand");				
			}
			if(demand<5) {
				model.put("errorMessage", "Invalid Input!");
				log.info("Ending showList");
				return new ModelAndView ("viewDemand");
			}
			if(list.isEmpty()) {
				model.put("errorMessage", "Stock not available!");
				log.info("Ending showList");
				return new ModelAndView ("viewDemand");
			}
			model.put("pharmacyList", list);
			log.info("Ending showList");
			return new ModelAndView ("SupplyAvailed");
		}
		log.info("Ending showList");
		return new ModelAndView("login");
	}
}
