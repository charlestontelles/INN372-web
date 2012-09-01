package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;

public class CalcEnergyProductionTest {
	private CalcEnergyProduction calcEnergyProduction;
	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calcEnergyProduction = new CalcEnergyProduction();
		calculator = new Calculator();
	}

	@Test
	public void testSetGetCalculator() {
		calcEnergyProduction.setCalculator(calculator);
		assertEquals(calcEnergyProduction.getCalculator(), calculator);
	}
}
