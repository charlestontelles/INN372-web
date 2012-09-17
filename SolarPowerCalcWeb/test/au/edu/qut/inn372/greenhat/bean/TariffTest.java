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
public class TariffTest {
	private Tariff tariff;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tariff = new Tariff();
	}

	@Test
	public void testSetGetTariff11Fee() {
		tariff.setTariff11Fee(0.1941);
		assertEquals(0.1941, tariff.getTariff11Fee(), 0.1);
	}

	@Test
	public void testSetGetAnnualTariffIncrease() {
		tariff.setAnnualTariffIncrease(0.5);
		assertEquals(0.5, tariff.getAnnualTariffIncrease(), 0.1);
	}

	@Test
	public void testSetGetFeedInFee() {
		tariff.setFeedInFee(0.3);
		assertEquals(0.3, tariff.getFeedInFee(), 0.1);
	}
	
	@Test
	public void testGetTariffFeePerYear() {
		tariff.setTariffFeePerYear(1.2);
		assertEquals(1.2, tariff.getTariffFeePerYear(), 0.1);
	}
}
