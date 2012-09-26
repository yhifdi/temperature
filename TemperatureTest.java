import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TemperatureTest {

	private        Temperature temperature;
	private        Temperature temperature2;
	private        Temperature temperature3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
    temperature = new Temperature(1, Temperature.Units.CELCIUS);
	temperature2 = new Temperature(33.8, Temperature.Units.FAHRENHEIT);
	temperature3 = new Temperature(274.15, Temperature.Units.KELVIN);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetValue() {
		//fail("Not yet implemented");
		double result = temperature.getValue();
		assertEquals(1,result, 0.00001);
		
	}

	@Test
	public void testGetUnits() {
		//fail("Not yet implemented");
		// checking that it return the right unit for CELCIUS/FAHRENHEIT/KELVIN
		Temperature.Units result = temperature.getUnits();
	    assertEquals(Temperature.Units.CELCIUS, result);
	    
		result = temperature2.getUnits();
		assertEquals(Temperature.Units.FAHRENHEIT, result);
		
		result = temperature3.getUnits();
		assertEquals(Temperature.Units.KELVIN, result);
		// i used 3 test to check that it works for the 3 units
	}

	@Test
	public void testChangeUnits() {
		//fail("Not yet implemented");
		//from CELCIUS to FAHRENHEIT
		temperature.changeUnits(Temperature.Units.FAHRENHEIT);
		double resultValue = temperature.getValue();
		Temperature.Units resultUnit = temperature.getUnits();
		assertEquals(Temperature.Units.FAHRENHEIT,resultUnit);
		assertEquals(33.8,resultValue,0.00001);
		
		// from FAHRENHEIT to KELVIN
		temperature.changeUnits(Temperature.Units.KELVIN);
		resultValue = temperature.getValue();
		resultUnit = temperature.getUnits();
		assertEquals(Temperature.Units.KELVIN,resultUnit);
		assertEquals(274.15,resultValue,0.00001);
		
		// From KELVIN to CELCIUS
		temperature.changeUnits(Temperature.Units.CELCIUS);
		resultValue = temperature.getValue();
		resultUnit = temperature.getUnits();
		assertEquals(Temperature.Units.CELCIUS,resultUnit);
		assertEquals(1,resultValue,0.00001);
		
		// from CELCIUS to KELVIN
		temperature.changeUnits(Temperature.Units.KELVIN);
		resultValue = temperature.getValue();
		resultUnit = temperature.getUnits();
		assertEquals(Temperature.Units.KELVIN,resultUnit);
		assertEquals(274.15,resultValue,0.00001);
		 
		// from KELVIN to FAHRENHEIT
		temperature.changeUnits(Temperature.Units.FAHRENHEIT);
		resultValue = temperature.getValue();
		resultUnit = temperature.getUnits();
		assertEquals(Temperature.Units.FAHRENHEIT,resultUnit);
		assertEquals(33.8,resultValue,0.00001);
		
		// from FAHRENHEIT to CELCIUS
		temperature.changeUnits(Temperature.Units.CELCIUS);
		resultValue = temperature.getValue();
		resultUnit = temperature.getUnits();
		assertEquals(Temperature.Units.CELCIUS,resultUnit);
		assertEquals(1,resultValue,0.00001);
		
		// for all the conversion ( the 6 combinations ) i used the 1 test  to check that the conversion unit is correct
		// and an other one to test that the the conversion value is correct
		
		
		
		
	}

	@Test
	public void testEqualsObject() {
		//fail("Not yet implemented");

		 Temperature temperature4;
		 temperature4 = new Temperature(0, Temperature.Units.FAHRENHEIT);
		 
		 // testing equality and inequality between celcius and Fahrenheit
		assertTrue(temperature.equals(temperature2));
		assertFalse(temperature.equals(temperature4));
		//testing equality and inequality between celcius and KELVIN
		
		 temperature4.changeUnits(Temperature.Units.KELVIN);
		 assertTrue(temperature.equals(temperature3));
		 assertFalse(temperature.equals(temperature4));
		 //testing equality and inequality between FAHRENHEIT and KELVIN
		 
		 assertTrue(temperature2.equals(temperature3));
		 assertFalse(temperature2.equals(temperature4));
		 
		 // testing that the equals method is reflexive for celcius/Fahrenheit and kelvin
		 
		 assertTrue(temperature.equals(temperature));
		 assertTrue(temperature2.equals(temperature2));
		 assertTrue(temperature3.equals(temperature3));
		 // for checking equality is used 2 tests for each unit. one for the equality
		 // and one for checking that it is not equal in case it always returns true
		 // finally i checked the equality for the same objects for the 3 units
	}

}
