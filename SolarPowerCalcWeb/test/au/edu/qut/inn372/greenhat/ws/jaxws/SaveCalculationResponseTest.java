package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SaveCalculationResponseTest {
	private SaveCalculationResponse saveCalculationResponse;

	@Before
	public void setUp() throws Exception {
		saveCalculationResponse = new SaveCalculationResponse();
	}

	@Test
	public void testSetGetResult() {
		saveCalculationResponse.setResult("result");
		assertEquals(saveCalculationResponse.getResult(), "result");
	}
}
