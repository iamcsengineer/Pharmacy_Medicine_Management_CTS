package com.cognizant.stockMedicineService.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.stockMedicineService.dao.MedicineStockDAO;
import com.cognizant.stockMedicineService.model.Medicine;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineStockServiceImplTest {


    @InjectMocks
    private MedicineStockServiceImpl medicineServiceImpl;

    @Mock
    private MedicineStockDAO medicineDAO;

    @Mock
    private Medicine medicine;
        
    /**
	 * @throws Exception  Tests the getMedicineStockInformation method and checks if
	 *  						the returned value is null or not
	 */
    @Test
    public void testGetMedicineStockInformationNotNull() {
        assertNotNull(medicineServiceImpl.getMedicineStockInformation());
    }
    
     /**
  	 * @throws Exception  Tests the getMedicineStockInformation method and checks if
  	 *  						the returned value is equal or not
  	 */
      @Test
      public void testGetMedicineStockInformation() {
    	  medicineDAO = mock(MedicineStockDAO.class);
    	  when(medicineDAO.findAll()).thenReturn(new LinkedList()); 	  
    	  assertEquals(medicineServiceImpl.getMedicineStockInformation(),new LinkedList());
      }

    
    /**
     * @throws Exception  Tests the getMedicineByTargetAilment method and checks if
     *  						the returned value is equal or not
     */
    @Test
    public void testGetMedicineByTargetAilment() {
    	medicineDAO = mock(MedicineStockDAO.class);
    	when(medicineDAO.getMedicineByTargetAilment(Mockito.anyString())).thenReturn(new LinkedList()); 	  
    	assertEquals(medicineServiceImpl.getMedicineByTargetAilment(Mockito.anyString()),new LinkedList());
    }
    
    /**
	 * @throws Exception  Tests the getNumberOfTabletsInStockByName method and checks if
	 *  						the returned value is null or not
	 */
    @Test
    public void testGetNumberOfTabletsInStockByNameNotNull() {
    	//medicineDAO = mock(MedicineStockDAO.class);
    	when(medicineDAO.getNumberOfTabletsInStockByName(Mockito.anyString())).thenReturn(new Medicine()); 	  
    	assertNotNull(medicineServiceImpl.getNumberOfTabletsInStockByName(Mockito.anyString()));
    }
    
    /**
	 * @throws Exception  Tests the getNumberOfTabletsInStockByName method and checks if
	 *  						the returned value is equal or not
	 */
    @Test
    public void testGetNumberOfTabletsInStockByName() {
    	//medicineDAO = mock(MedicineStockDAO.class);
    	when(medicineDAO.getNumberOfTabletsInStockByName(Mockito.anyString())).thenReturn(new Medicine()); 
    	assertEquals(medicineServiceImpl.getNumberOfTabletsInStockByName(Mockito.anyString()),Mockito.anyInt());
    }

}
