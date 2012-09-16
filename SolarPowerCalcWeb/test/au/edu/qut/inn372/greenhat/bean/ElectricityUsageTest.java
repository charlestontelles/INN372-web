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
public class ElectricityUsageTest {
	private ElectricityUsage electricityUsage;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		electricityUsage = new ElectricityUsage();
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.ElectricityUsage#getDailyAverageUsage()}.
	 */
	@Test
	public void testSetGetDailyAverageUsage() {
		electricityUsage.setDailyAverageUsage(2.3);
		assertEquals(2.3, electricityUsage.getDailyAverageUsage(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.ElectricityUsage#getDayTimeHourlyUsage()}.
	 */
	@Test
	public void testSetGetDayTimeHourlyUsage() {
		electricityUsage.setDayTimeHourlyUsage(1.2);
		assertEquals(1.2, electricityUsage.getDayTimeHourlyUsage(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.ElectricityUsage#getDayLightElectricityUsage()}.
	 */
	@Test
	public void testSetGetDayLightElectricityUsage() {
		electricityUsage.setDayLightElectricityUsage(2.4);
		assertEquals(2.4, electricityUsage.getDayLightElectricityUsage(), 0.1);
	}
}
