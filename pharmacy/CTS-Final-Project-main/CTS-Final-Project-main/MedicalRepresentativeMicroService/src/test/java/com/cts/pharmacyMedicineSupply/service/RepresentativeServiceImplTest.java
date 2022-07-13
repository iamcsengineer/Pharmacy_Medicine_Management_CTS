package com.cts.pharmacyMedicineSupply.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.pharmacyMedicineSupply.Repository.DoctorRepo;
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
@ExtendWith(MockitoExtension.class)
class RepresentativeServiceImplTest {

	
	 @InjectMocks RepresentativeServiceImpl representativeServiceImpl;
	 
	//@Autowired
	//RepresentativeServiceImpl representativeServiceImpl;
	
	@Mock
	DoctorRepo doctorRepo;
	
	@Mock
	MedicalRepService medicalRepService;
	
	/*@Test
	public void TestlistSchedule() {
		Doctor d=new Doctor(1,"D1","9884122113","Orthopaedics");
		List<MedicalRep> medicalRep=new ArrayList<>();
		medicalRep.add(new MedicalRep("R1","9874563210"));
		//when(doctorRepo.getOne(1)).thenReturn(" Hello Everyone ");
		when(doctorRepo.getOne(1)).thenReturn(d);
		when(doctorRepo.count()).thenReturn(1);
		when(medicalRepService.sendRep()).thenReturn(medicalRep);
		assertNotNull(representativeServiceImpl.listschedule("2021-07-21"));
	}
	*/
	@Test
	public void TestStringtoDate() {
		LocalDate dt=LocalDate.parse("2021-07-19");
		assertEquals(dt,representativeServiceImpl.stringToDate("2021-07-19"));
	}
	
	@Test
	public void TestListOfDate() {
		LocalDate dt=LocalDate.parse("2021-07-19");
		String date[]= {"2021-07-19","2021-07-20","2021-07-21","2021-07-22","2021-07-23"};
		assertArrayEquals(date,representativeServiceImpl.getListOfDates(dt));
	}
}
