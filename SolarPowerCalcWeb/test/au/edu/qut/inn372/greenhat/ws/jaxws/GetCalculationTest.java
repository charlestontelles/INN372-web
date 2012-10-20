package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GetCalculationTest {

	private GetCalculation getCalculation;

	@Before
	public void setUp() throws Exception {
		getCalculation = new GetCalculation();
	}

	@Test
	public void testSetGetCalculator() {
		String name = "Jay";
		getCalculation.setName(name);
		assertEquals(getCalculation.getName(), name);
	}

}
