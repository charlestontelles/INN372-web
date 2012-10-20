package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;

public class GetCalculationsResponseTest {
	private GetCalculationsResponse getCalculationsResponse;
	 private List<Calculator> calculators;

	@Before
	public void setUp() throws Exception {
		getCalculationsResponse = new GetCalculationsResponse();
		calculators = new ArrayList<Calculator>();
	}

	@Test
	public void testSetGetCalculator() {
		getCalculationsResponse.setCalculators(calculators);
		assertEquals(getCalculationsResponse.getCalculators(), calculators);
	}
}
