package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeleteCalculationReponseResponseTest {
	private DeleteCalculationResponse deleteCalculationResponse;

	@Before
	public void setUp() throws Exception {
		deleteCalculationResponse = new DeleteCalculationResponse();
	}

	@Test
	public void testSetGetResult() {
		String result = "test";
		deleteCalculationResponse.setResult(result);
		assertEquals(deleteCalculationResponse.getResult(), result);
	}
}
