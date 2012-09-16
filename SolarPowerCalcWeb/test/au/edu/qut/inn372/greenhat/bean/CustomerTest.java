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
public class CustomerTest {
	private Customer customer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Customer#getLocation()}.
	 */
	@Test
	public void testSetGetLocation() {
		Location location = new Location();
		customer.setLocation(location);
		assertEquals(location, customer.getLocation());
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Customer#getTariff()}.
	 */
	@Test
	public void testSetGetTariff() {
		Tariff tariff = new Tariff();
		customer.setTariff(tariff);
		assertEquals(tariff, customer.getTariff());
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Customer#getElectricityUsage()}.
	 */
	@Test
	public void testSetGetElectricityUsage() {
		ElectricityUsage electricityUsage = new ElectricityUsage();
		customer.setElectricityUsage(electricityUsage);
		assertEquals(electricityUsage, customer.getElectricityUsage());
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Customer#getDayLightElectricityUsage()}.
	 */
	@Test
	public void testSetGetDayLightElectricityUsage() {
		customer.setDayLightElectricityUsage(1.45);
		assertEquals(1.45, customer.getDayLightElectricityUsage(), 0.1);
	}
}
