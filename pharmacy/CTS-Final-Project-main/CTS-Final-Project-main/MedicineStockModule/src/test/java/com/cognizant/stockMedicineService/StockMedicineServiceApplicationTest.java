package com.cognizant.stockMedicineService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.stockMedicineService.controller.StockController;
import com.cognizant.stockMedicineService.dao.MedicineStockDAO;
import com.cognizant.stockMedicineService.model.Medicine;
import com.cognizant.stockMedicineService.service.MedicineStockService;

@RunWith(SpringRunner.class)
public class StockMedicineServiceApplicationTest {

	@InjectMocks
	private StockController stockController;//=new StockController();
	
	@Mock
	private MedicineStockDAO medicineDAO;
	
	@Mock
	private Medicine medicineStock;
	
	@Mock
	private MedicineStockService medicineStockService;
	
	
	
	@Test
	public void testGetMedicineStockInformation() {
		ResponseEntity<?> responseEntity = stockController.getMedicineStockInformation();
		HttpStatus status = responseEntity.getStatusCode();
		assertNotNull(status);
		assertEquals(HttpStatus.OK,status);
	}
	@Test
	public void testGetMedicineByTreatingAilment() {
		ResponseEntity<?> responseEntity = stockController.getMedicineByTreatingAilment("Gynaecology");
		HttpStatus status = responseEntity.getStatusCode();
		assertNotNull(status);
		assertEquals(HttpStatus.OK,status);
	}
	@Test
	public void testGetStockCountForMedicine() {
		ResponseEntity<?> responseEntity = stockController.getStockCountForMedicine("Orthoherb");
		HttpStatus status = responseEntity.getStatusCode();
		assertNotNull(status);
		assertEquals(HttpStatus.OK,status);
	}
}
