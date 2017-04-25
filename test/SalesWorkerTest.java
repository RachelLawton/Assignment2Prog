import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesWorkerTest {
	private SalesWorker salNormal1, salNormal2;
	private SalesWorker salValidation1,salValidation2, salValidation3;
	private TempWorker temp1;
	private Manager Man1;
	
	/**
	 * Method to set up data for testing. 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		salNormal1 = new SalesWorker("Daisy", "Flower", 20, 12);
		salNormal2 = new SalesWorker("lizze", "Mcguire", 10, 20);
		temp1 = new TempWorker("Jace", "Hunter", 10);
		
		salValidation1 = new SalesWorker ("Poppy", "Moore", -1, -1);
		salValidation2 = new SalesWorker ("Jamie", "Bower", 0, 0);
		salValidation3 = new SalesWorker ("Grant ", "Gustin", 1, 1);
    }

	/**
	 * Test method for Manager constructor using valid data
	 */
	@Test
	public void testGettersValidData() {
		assertEquals("Daisy", salNormal1.getFirstName());
		assertEquals("Flower", salNormal1.getSecondName());
        assertEquals(12, salNormal1.getSalesPerformanceBonus(), 0.01);
		assertEquals(20, salNormal1.getHourlyRate(), 0.01);	
	}


	/**
	 * Test method for Manager constructor using Invalid data
	 */
	@Test
	public void testSalesWorkerInvalidData() {
		assertEquals(0, salValidation1.getSalesPerformanceBonus(), 0.01);
		assertEquals(0, salValidation1.getHourlyRate(), 0.01);
		assertEquals(0, salValidation2.getSalesPerformanceBonus(), 0.01);
		assertEquals(0, salValidation2.getHourlyRate(), 0.01);
		assertEquals(1, salValidation3.getSalesPerformanceBonus(), 0.01);
		assertEquals(1, salValidation3.getHourlyRate(), 0.01);
	}

	
	
	/**
	 * Test method for first name getter and setter (No validation on this field)
	 */
	@Test
	public void testGetSetFirstName() {
		assertEquals(salNormal1.getFirstName(), "Daisy");
		salNormal1.setFirstName("lizze");
		assertEquals(salNormal1.getFirstName(),"lizze");
	}



	/**
	 * Test method for second name getter and setter. (No validation on this field)
	 */
	@Test
	public void testGetSetSecondName() {
		assertEquals(salNormal1.getSecondName(), "Flower");
		salNormal1.setSecondName("Mcguire");
		assertEquals(salNormal1.getSecondName(),"Mcguire");
	}


	

	/**
	 * Test method for getBonus and setBonus. (Validation on this field)
	 */
	@Test
	public void testGetSetsalesPerformanceBonus() {
		assertEquals(12, salNormal1.getSalesPerformanceBonus(), 0.01);
        salNormal1.setsalesPerformanceBonus(-1);
		assertEquals(12, salNormal1.getSalesPerformanceBonus(), 0.01);
        salNormal1.setsalesPerformanceBonus(0);
        assertEquals(0, salNormal1.getSalesPerformanceBonus(), 0.01);
        salNormal1.setsalesPerformanceBonus(12);
        assertEquals(12, salNormal1.getSalesPerformanceBonus(), 0.01);
	}



	/**
	 * Test method for getBonus and setBonus. (Validation on this field)
	 */
	@Test
	public void testGetSetHourlyRate() {
		assertEquals(20, salNormal1.getHourlyRate(), 0.01);
        salNormal1.setHourlyRate(-1);
		assertEquals(20, salNormal1.getHourlyRate(), 0.01);
        salNormal1.setHourlyRate(0);
        assertEquals(0, salNormal1.getHourlyRate(), 0.01);
        salNormal1.setHourlyRate(20);
        assertEquals(20, salNormal1.getHourlyRate(), 0.01);
	}
	
	/**
	 * Test method for calculateSalary()
	 */
	@Test
	public void testCalculateSalary() {
		// SalesWorker with no employees
		assertEquals(828.8, salNormal1.calculateSalary(37), 0.01);
		assertEquals(840.0, salNormal1.calculateSalary(37.5), 0.01);
		assertEquals(862.4, salNormal1.calculateSalary(38), 0.01);
		assertEquals(887.81952, salNormal1.calculateSalary(38.5674), 0.01);
		
		//SalesWorker with employees
		assertEquals(444.0, salNormal2.calculateSalary(37), 0.01);
		assertEquals(450.0, salNormal2.calculateSalary(37.5), 0.01);
		assertEquals(470.016, salNormal2.calculateSalary(38.334), 0.01);	
	
	}
}
	
	