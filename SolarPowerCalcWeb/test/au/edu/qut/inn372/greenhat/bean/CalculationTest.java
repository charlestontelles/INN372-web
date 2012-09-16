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
public class CalculationTest {
	
	private Calculation calculation;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		calculation = new Calculation();
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getYear()}.
	 */
	@Test
	public void testSetGetYear() {
		calculation.setYear(2012);
		assertEquals(2012, calculation.getYear(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getTariff11Fee()}.
	 */
	@Test
	public void testSetGetTariff11Fee() {
		calculation.setTariff11Fee(0.1941);
		assertEquals(0.1941, calculation.getTariff11Fee(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getDailySolarPower()}.
	 */
	@Test
	public void testSetGetDailySolarPower() {
		calculation.setDailySolarPower(12.3);
		assertEquals(12.3, calculation.getDailySolarPower(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getAnnualSolarPower()}.
	 */
	@Test
	public void testSetGetAnnualSolarPower() {
		calculation.setAnnualSolarPower(12.3 * 365);
		assertEquals(12.3*365, calculation.getAnnualSolarPower(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getReplacementGeneration()}.
	 */
	@Test
	public void testSetGetReplacementGeneration() {
		calculation.setReplacementGeneration(2.3);
		assertEquals(2.3, calculation.getReplacementGeneration(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getExportedGeneration()}.
	 */
	@Test
	public void testSetGetExportedGeneration() {
		calculation.setExportedGeneration(1.3);
		assertEquals(1.3, calculation.getExportedGeneration(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getDailySaving()}.
	 */
	@Test
	public void testSetGetDailySaving() {
		calculation.setDailySaving(8.3);
		assertEquals(8.3, calculation.getDailySaving(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getAnnualSaving()}.
	 */
	@Test
	public void testSetGetAnnualSaving() {
		calculation.setAnnualSaving(8.3 * 365);
		assertEquals(8.3*365, calculation.getAnnualSaving(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getCumulativeSaving()}.
	 */
	@Test
	public void testSetGetCumulativeSaving() {
		calculation.setCumulativeSaving(16.6*365);
		assertEquals(16.6*365, calculation.getCumulativeSaving(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getMoneySaved()}.
	 */
	@Test
	public void testSetGetMoneySaved() {
		calculation.setMoneySaved(4.3);
		assertEquals(4.3, calculation.getMoneySaved(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getPanelEfficiency()}.
	 */
	@Test
	public void testSetGetPanelEfficiency() {
		calculation.setPanelEfficiency(83.5);
		assertEquals(83.5, calculation.getPanelEfficiency(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank1Efficiency()}.
	 */
	@Test
	public void testSetGetBank1Efficiency() {
		calculation.setBank1Efficiency(98.7);
		assertEquals(98.7, calculation.getBank1Efficiency(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank2Efficiency()}.
	 */
	@Test
	public void testSetGetBank2Efficiency() {
		calculation.setBank2Efficiency(98.7);
		assertEquals(98.7, calculation.getBank2Efficiency(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank1DailySolarPower()}.
	 */
	@Test
	public void testSetGetBank1DailySolarPower() {
		calculation.setBank1DailySolarPower(2.3);
		assertEquals(2.3, calculation.getBank1DailySolarPower(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank2DailySolarPower()}.
	 */
	@Test
	public void testSetGetBank2DailySolarPower() {
		calculation.setBank2DailySolarPower(2.3);
		assertEquals(2.3, calculation.getBank2DailySolarPower(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getMoneyEarned()}.
	 */
	@Test
	public void testSetGetMoneyEarned() {
		calculation.setMoneyEarned(4.3);
		assertEquals(4.3, calculation.getMoneyEarned(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getReturnOnInvestment()}.
	 */
	@Test
	public void testSetGetReturnOnInvestment() {
		calculation.setReturnOnInvestment(1.6);
		assertEquals(1.6, calculation.getReturnOnInvestment(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getPaybackPeriod()}.
	 */
	@Test
	public void testGetPaybackPeriod() {
		calculation.setPaybackPeriod(6);
		assertEquals(6, calculation.getPaybackPeriod(), 0.1);
	}
}
