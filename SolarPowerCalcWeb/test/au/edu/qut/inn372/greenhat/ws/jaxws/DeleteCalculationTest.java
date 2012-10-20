package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;

public class DeleteCalculationTest {
	
	private CalcEnergyProduction DeleteCalculation;
	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		DeleteCalculation = new CalcEnergyProduction();
		calculator = new Calculator();
	}

	@Test
	public void testSetGetCalculator() {
		DeleteCalculation.setCalculator(calculator);
		assertEquals(DeleteCalculation.getCalculator(), calculator);
	}

}
