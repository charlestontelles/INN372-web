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
		double newDailyAverageUsage = 2.3;
		electricityUsage.setDailyAverageUsage(newDailyAverageUsage);
		assertEquals(newDailyAverageUsage, electricityUsage.getDailyAverageUsage(), 0.1);
	}
	
	@Test
	public void testDailyAverageUsageOf0() {
		double newDailyAverageUsage = 0.0;
		electricityUsage.setDailyAverageUsage(newDailyAverageUsage);
		assertEquals(newDailyAverageUsage, electricityUsage.getDailyAverageUsage(), 0.1);
	}
	
	@Test
	public void testHighDailyAverageUsage() {
		double newDailyAverageUsage = 999.999;
		electricityUsage.setDailyAverageUsage(newDailyAverageUsage);
		assertEquals(newDailyAverageUsage, electricityUsage.getDailyAverageUsage(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.ElectricityUsage#getDayTimeHourlyUsage()}.
	 */
	@Test
	public void testSetGetDayTimeHourlyUsage() {
		double newDayTimeHourlyUsage = 1.2;
		electricityUsage.setDayTimeHourlyUsage(newDayTimeHourlyUsage);
		assertEquals(newDayTimeHourlyUsage, electricityUsage.getDayTimeHourlyUsage(), 0.1);
	}
	
	@Test
	public void testDayTimeHourlyUsageOf0() {
		double newDayTimeHourlyUsage = 0.0;
		electricityUsage.setDayTimeHourlyUsage(newDayTimeHourlyUsage);
		assertEquals(newDayTimeHourlyUsage, electricityUsage.getDayTimeHourlyUsage(), 0.1);
	}
	
	@Test
	public void testHighDayTimeHourlyUsage() {
		double newDayTimeHourlyUsage = 999.999;
		electricityUsage.setDayTimeHourlyUsage(newDayTimeHourlyUsage);
		assertEquals(newDayTimeHourlyUsage, electricityUsage.getDayTimeHourlyUsage(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.ElectricityUsage#getDayLightElectricityUsage()}.
	 */
	@Test
	public void testSetGetDayLightElectricityUsage() {
		double newDayLightElectricityUsage = 2.4;
		electricityUsage.setDayLightElectricityUsage(newDayLightElectricityUsage);
		assertEquals(newDayLightElectricityUsage, electricityUsage.getDayLightElectricityUsage(), 0.1);
	}
	
	@Test
	public void testDayLightElectricityUsageOf0() {
		double newDayLightElectricityUsage = 0.0;
		electricityUsage.setDayLightElectricityUsage(newDayLightElectricityUsage);
		assertEquals(newDayLightElectricityUsage, electricityUsage.getDayLightElectricityUsage(), 0.1);
	}
	
	@Test
	public void testHighDayLightElectricityUsage() {
		double newDayLightElectricityUsage = 999.999;
		electricityUsage.setDayLightElectricityUsage(newDayLightElectricityUsage);
		assertEquals(newDayLightElectricityUsage, electricityUsage.getDayLightElectricityUsage(), 0.1);
	}
}
