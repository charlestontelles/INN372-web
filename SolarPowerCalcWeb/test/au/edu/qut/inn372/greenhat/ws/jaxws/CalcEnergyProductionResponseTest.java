package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;

public class CalcEnergyProductionResponseTest {
	private CalcEnergyProductionResponse calcEnergyProductionResponse;
	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calcEnergyProductionResponse = new CalcEnergyProductionResponse();
		calculator = new Calculator();
	}

	@Test
	public void testSetGetCalculator() {
		calcEnergyProductionResponse.setCalculator(calculator);
		assertEquals(calcEnergyProductionResponse.getCalculator(), calculator);
	}
}
