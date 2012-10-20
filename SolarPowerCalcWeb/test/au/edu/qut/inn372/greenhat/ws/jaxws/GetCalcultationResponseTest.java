package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;

public class GetCalcultationResponseTest {
	private GetCalculationResponse getCalculationResponse;
	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		getCalculationResponse = new GetCalculationResponse();
		calculator = new Calculator();
	}

	@Test
	public void testSetGetCalculator() {
		getCalculationResponse.setCalculator(calculator);
		assertEquals(getCalculationResponse.getCalculator(), calculator);
	}
}
