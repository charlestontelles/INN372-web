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
		tariff.setAnnualTariffIncrease(0.6);
		tariff.setFeedInFee(0.5);
		tariff.setTariff11Fee(0.2);
		tariff.setTariffFeePerYear(1.5);
	}

	@Test
	public void testSetGetTariff11Fee() {
		assertEquals(0.2, tariff.getTariff11Fee(), 0.0);
		tariff.setTariff11Fee(0.1941);
		assertEquals(0.1941, tariff.getTariff11Fee(), 0.1);
	}

	@Test
	public void testSetGetAnnualTariffIncrease() {
		assertEquals(0.6, tariff.getAnnualTariffIncrease(), 0.0);
		tariff.setAnnualTariffIncrease(0.5);
		assertEquals(0.5, tariff.getAnnualTariffIncrease(), 0.1);
	}

	@Test
	public void testSetGetFeedInFee() {
		assertEquals(0.5, tariff.getFeedInFee(), 0.0);
		tariff.setFeedInFee(0.3);
		assertEquals(0.3, tariff.getFeedInFee(), 0.1);
	}
	
	@Test
	public void testGetTariffFeePerYear() {
		assertEquals(1.5, tariff.getTariffFeePerYear(), 0.0);
		tariff.setTariffFeePerYear(1.2);
		assertEquals(1.2, tariff.getTariffFeePerYear(), 0.1);
	}
}
