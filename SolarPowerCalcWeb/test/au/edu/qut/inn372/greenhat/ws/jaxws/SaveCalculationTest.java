package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;

public class SaveCalculationTest {
	
	private CalcEnergyProduction SaveCalculation;
	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		SaveCalculation = new CalcEnergyProduction();
		calculator = new Calculator();
	}

	@Test
	public void testSetGetCalculator() {
		SaveCalculation.setCalculator(calculator);
		assertEquals(SaveCalculation.getCalculator(), calculator);
	}

}
