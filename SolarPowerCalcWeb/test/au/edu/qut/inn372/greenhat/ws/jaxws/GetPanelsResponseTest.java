package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Panel;

public class GetPanelsResponseTest {
	private GetPanelsResponse getPanelsResponse;
	private Panel[] panels;

	@Before
	public void setUp() throws Exception {
		getPanelsResponse = new GetPanelsResponse();
		panels = new Panel[10];
	}

	@Test
	public void testSetGetCalculator() {
		getPanelsResponse.setPanels(panels);
		assertEquals(getPanelsResponse.getPanels(), panels);
	}
}
