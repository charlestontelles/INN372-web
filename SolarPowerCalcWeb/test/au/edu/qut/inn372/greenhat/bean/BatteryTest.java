/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Martin Daniel
 *
 */
public class BatteryTest {
	
	private Battery battery;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		battery = new Battery();
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Battery#getCost()}.
	 */
	@Test
	public void testSetGetCost() {
		battery.setCost(400.0);
		assertEquals(400.0, battery.getCost(), 0.1);
	}
}
