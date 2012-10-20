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
		int newYear = 2012;
		calculation.setYear(newYear);
		assertEquals(newYear, calculation.getYear(), 0.1);
	}
	
	public void testYearOf0(){
		int newYear = 0;
		calculation.setYear(newYear);
		assertEquals(newYear, calculation.getYear(), 0.0);
	}
	
	public void testExceptionalYear(){
		int newYear = 9999;
		calculation.setYear(newYear);
		assertEquals(newYear, calculation.getYear(), 0.0);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getTariff11Fee()}.
	 */
	@Test
	public void testSetGetTariff11Fee() {
		double tariff = 0.1941;
		calculation.setTariff11Fee(tariff);
		assertEquals(tariff, calculation.getTariff11Fee(), 0.1);
	}
	
	@Test
	public void testTariff11FeOf0() {
		double tariff = 0.0;
		calculation.setTariff11Fee(tariff);
		assertEquals(tariff, calculation.getTariff11Fee(), 0.1);
	}
	
	@Test
	public void testHighTariff11Fee() {
		double tariff = 9.9999;
		calculation.setTariff11Fee(tariff);
		assertEquals(tariff, calculation.getTariff11Fee(), 0.1);
	}


	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getDailySolarPower()}.
	 */
	@Test
	public void testSetGetDailySolarPower() {
		double newSolarPower = 12.3;
		calculation.setDailySolarPower(newSolarPower);
		assertEquals(newSolarPower, calculation.getDailySolarPower(), 0.1);
	}

	@Test
	public void testDailySolarPowerof0() {
		double newSolarPower = 0.0;
		calculation.setDailySolarPower(newSolarPower);
		assertEquals(newSolarPower, calculation.getDailySolarPower(), 0.1);
	}
	
	@Test
	public void testHighDailySolarPower() {
		double newSolarPower = 999.999;
		calculation.setDailySolarPower(newSolarPower);
		assertEquals(newSolarPower, calculation.getDailySolarPower(), 0.1);
	}
	
	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getAnnualSolarPower()}.
	 */
	@Test
	public void testSetGetAnnualSolarPower() {
		int dayOf1Year = 365;
		double newAnnualSolarPower = 12.3 * dayOf1Year;
		calculation.setAnnualSolarPower(newAnnualSolarPower);
		assertEquals(newAnnualSolarPower, calculation.getAnnualSolarPower(), 0.1);
	}
	
	@Test
	public void testAnnualSolarPowerOf0() {
		int dayOf1Year = 365;
		double newAnnualSolarPower = 0.0 * dayOf1Year;
		calculation.setAnnualSolarPower(newAnnualSolarPower);
		assertEquals(newAnnualSolarPower, calculation.getAnnualSolarPower(), 0.1);
	}
	
	@Test
	public void testHighAnnualSolarPower() {
		int dayOf1Year = 365;
		double newAnnualSolarPower = 999.999 * dayOf1Year;
		calculation.setAnnualSolarPower(newAnnualSolarPower);
		assertEquals(newAnnualSolarPower, calculation.getAnnualSolarPower(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getReplacementGeneration()}.
	 */
	@Test
	public void testSetGetReplacementGeneration() {
		double newReplacementGeneration = 2.3;
		calculation.setReplacementGeneration(newReplacementGeneration);
		assertEquals(newReplacementGeneration, calculation.getReplacementGeneration(), 0.1);
	}
	
	@Test
	public void testReplacementGenerationOf0() {
		double newReplacementGeneration = 0.0;
		calculation.setReplacementGeneration(newReplacementGeneration);
		assertEquals(newReplacementGeneration, calculation.getReplacementGeneration(), 0.1);
	}
	
	@Test
	public void testHighReplacementGeneration() {
		double newReplacementGeneration = 9999.999;
		calculation.setReplacementGeneration(newReplacementGeneration);
		assertEquals(newReplacementGeneration, calculation.getReplacementGeneration(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getExportedGeneration()}.
	 */
	@Test
	public void testSetGetExportedGeneration() {
		double newExportedGeneration = 1.3;
		calculation.setExportedGeneration(newExportedGeneration);
		assertEquals(newExportedGeneration, calculation.getExportedGeneration(), 0.1);
	}
	
	@Test
	public void testExportedGenerationOf0() {
		double newExportedGeneration = 0.0;
		calculation.setExportedGeneration(newExportedGeneration);
		assertEquals(newExportedGeneration, calculation.getExportedGeneration(), 0.1);
	}
	
	@Test
	public void testHighExportedGeneration() {
		double newExportedGeneration = 999.9999;
		calculation.setExportedGeneration(newExportedGeneration);
		assertEquals(newExportedGeneration, calculation.getExportedGeneration(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getDailySaving()}.
	 */
	@Test
	public void testSetGetDailySaving() {
		double newDailySaving = 8.3;
		calculation.setDailySaving(newDailySaving);
		assertEquals(newDailySaving, calculation.getDailySaving(), 0.1);
	}
	
	@Test
	public void testDailySavingOf0() {
		double newDailySaving = 0.0;
		calculation.setDailySaving(newDailySaving);
		assertEquals(newDailySaving, calculation.getDailySaving(), 0.1);
	}
	
	@Test
	public void testHighDailySaving() {
		double newDailySaving = 999.999;
		calculation.setDailySaving(newDailySaving);
		assertEquals(newDailySaving, calculation.getDailySaving(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getAnnualSaving()}.
	 */
	@Test
	public void testSetGetAnnualSaving() {
		int oneYearDay = 365;
		double newAnnualSaving = 8.3 * oneYearDay;
		calculation.setAnnualSaving(newAnnualSaving);
		assertEquals(newAnnualSaving, calculation.getAnnualSaving(), 0.1);
	}
	
	@Test
	public void testAnnualSavingOf0() {
		int oneYearDay = 365;
		double newAnnualSaving = 0.0 * oneYearDay;
		calculation.setAnnualSaving(newAnnualSaving);
		assertEquals(newAnnualSaving, calculation.getAnnualSaving(), 0.1);
	}
	
	@Test
	public void testHighAnnualSaving() {
		int oneYearDay = 365;
		double newAnnualSaving = 999.999 * oneYearDay;
		calculation.setAnnualSaving(newAnnualSaving);
		assertEquals(newAnnualSaving, calculation.getAnnualSaving(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getCumulativeSaving()}.
	 */
	@Test
	public void testSetGetCumulativeSaving() {
		int oneYearDay = 365;
		double newAnnualCumulativeSaving = 16.6 * 365;
		calculation.setCumulativeSaving(newAnnualCumulativeSaving);
		assertEquals(newAnnualCumulativeSaving, calculation.getCumulativeSaving(), 0.1);
	}
	
	@Test
	public void testCumulativeSavingOf0() {
		int oneYearDay = 365;
		double newAnnualCumulativeSaving = 0.0 * 365;
		calculation.setCumulativeSaving(newAnnualCumulativeSaving);
		assertEquals(newAnnualCumulativeSaving, calculation.getCumulativeSaving(), 0.1);
	}
	
	@Test
	public void testHighCumulativeSaving() {
		int oneYearDay = 365;
		double newAnnualCumulativeSaving = 9999.999 * 365;
		calculation.setCumulativeSaving(newAnnualCumulativeSaving);
		assertEquals(newAnnualCumulativeSaving, calculation.getCumulativeSaving(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getMoneySaved()}.
	 */
	@Test
	public void testSetGetMoneySaved() {
		double newMoneySaved = 4.3;
		calculation.setMoneySaved(newMoneySaved);
		assertEquals(newMoneySaved, calculation.getMoneySaved(), 0.1);
	}
	
	@Test
	public void testMoneySavedOf0() {
		double newMoneySaved = 0.0;
		calculation.setMoneySaved(newMoneySaved);
		assertEquals(newMoneySaved, calculation.getMoneySaved(), 0.1);
	}
	
	@Test
	public void testHighMoneySaved() {
		double newMoneySaved = 999.999;
		calculation.setMoneySaved(newMoneySaved);
		assertEquals(newMoneySaved, calculation.getMoneySaved(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getPanelEfficiency()}.
	 */
	@Test
	public void testSetGetPanelEfficiency() {
		double newPanelEfficiency = 83.5;
		calculation.setPanelEfficiency(newPanelEfficiency);
		assertEquals(newPanelEfficiency, calculation.getPanelEfficiency(), 0.1);
	}
	
	@Test
	public void testPanelEfficiencyOf0() {
		double newPanelEfficiency = 0.0;
		calculation.setPanelEfficiency(newPanelEfficiency);
		assertEquals(newPanelEfficiency, calculation.getPanelEfficiency(), 0.1);
	}
	
	@Test
	public void testHighPanelEfficiency() {
		double newPanelEfficiency = 9999.9999;
		calculation.setPanelEfficiency(newPanelEfficiency);
		assertEquals(newPanelEfficiency, calculation.getPanelEfficiency(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank1Efficiency()}.
	 */
	@Test
	public void testSetGetBank1Efficiency() {
		double newBank1Efficiency = 98.7;
		calculation.setBank1Efficiency(newBank1Efficiency);
		assertEquals(newBank1Efficiency, calculation.getBank1Efficiency(), 0.1);
	}
	
	@Test
	public void testBank1EfficiencyOf0() {
		double newBank1Efficiency = 0.0;
		calculation.setBank1Efficiency(newBank1Efficiency);
		assertEquals(newBank1Efficiency, calculation.getBank1Efficiency(), 0.1);
	}
	
	@Test
	public void testHighBank1Efficiency() {
		double newBank1Efficiency = 9999.9999;
		calculation.setBank1Efficiency(newBank1Efficiency);
		assertEquals(newBank1Efficiency, calculation.getBank1Efficiency(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank2Efficiency()}.
	 */
	@Test
	public void testSetGetBank2Efficiency(){
		double newBankEfficiency2 = 98.7;
		calculation.setBank2Efficiency(newBankEfficiency2);
		assertEquals(newBankEfficiency2, calculation.getBank2Efficiency(), 0.1);
	}
	
	@Test
	public void testBank2EfficiencyOf0(){
		double newBankEfficiency2 = 0.0;
		calculation.setBank2Efficiency(newBankEfficiency2);
		assertEquals(newBankEfficiency2, calculation.getBank2Efficiency(), 0.1);
	}
	
	@Test
	public void testHighBank2Efficiency(){
		double newBankEfficiency2 = 9999.9999;
		calculation.setBank2Efficiency(newBankEfficiency2);
		assertEquals(newBankEfficiency2, calculation.getBank2Efficiency(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank1DailySolarPower()}.
	 */
	@Test
	public void testSetGetBank1DailySolarPower() {
		double newbank1DailySolarPower = 2.3;
		calculation.setBank1DailySolarPower(newbank1DailySolarPower);
		assertEquals(newbank1DailySolarPower, calculation.getBank1DailySolarPower(), 0.1);
	}
	
	@Test
	public void testBank1DailySolarPowerOf0() {
		double newbank1DailySolarPower = 0.0;
		calculation.setBank1DailySolarPower(newbank1DailySolarPower);
		assertEquals(newbank1DailySolarPower, calculation.getBank1DailySolarPower(), 0.1);
	}
	
	@Test
	public void testHighBank1DailySolarPower() {
		double newbank1DailySolarPower = 999.999;
		calculation.setBank1DailySolarPower(newbank1DailySolarPower);
		assertEquals(newbank1DailySolarPower, calculation.getBank1DailySolarPower(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getBank2DailySolarPower()}.
	 */
	@Test
	public void testSetGetBank2DailySolarPower() {
		double newBank2DailySolarPower = 2.3;
		calculation.setBank2DailySolarPower(newBank2DailySolarPower);
		assertEquals(newBank2DailySolarPower, calculation.getBank2DailySolarPower(), 0.1);
	}
	
	@Test
	public void testBank2DailySolarPowerOf0() {
		double newBank2DailySolarPower = 0.0;
		calculation.setBank2DailySolarPower(newBank2DailySolarPower);
		assertEquals(newBank2DailySolarPower, calculation.getBank2DailySolarPower(), 0.1);
	}
	
	@Test
	public void testHighBank2DailySolarPower() {
		double newBank2DailySolarPower = 9999.999;
		calculation.setBank2DailySolarPower(newBank2DailySolarPower);
		assertEquals(newBank2DailySolarPower, calculation.getBank2DailySolarPower(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getMoneyEarned()}.
	 */
	@Test
	public void testSetGetMoneyEarned() {
		double newMoneySaved = 4.3;
		calculation.setMoneyEarned(newMoneySaved);
		assertEquals(newMoneySaved, calculation.getMoneyEarned(), 0.1);
	}
	
	@Test
	public void testMoneyEarnedOf0() {
		double newMoneySaved = 0.0;
		calculation.setMoneyEarned(newMoneySaved);
		assertEquals(newMoneySaved, calculation.getMoneyEarned(), 0.1);
	}
	
	@Test
	public void testHighMoneyEarned() {
		double newMoneySaved = 999.999;
		calculation.setMoneyEarned(newMoneySaved);
		assertEquals(newMoneySaved, calculation.getMoneyEarned(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getReturnOnInvestment()}.
	 */
	@Test
	public void testSetGetReturnOnInvestment() {
		double newROI = 1.6;
		calculation.setReturnOnInvestment(newROI);
		assertEquals(newROI, calculation.getReturnOnInvestment(), 0.1);
	}
	
	@Test
	public void testReturnOnInvestmentOf0() {
		double newROI = 0.0;
		calculation.setReturnOnInvestment(newROI);
		assertEquals(newROI, calculation.getReturnOnInvestment(), 0.1);
	}
	
	@Test
	public void testHighReturnOnInvestment() {
		double newROI = 99.99;
		calculation.setReturnOnInvestment(newROI);
		assertEquals(newROI, calculation.getReturnOnInvestment(), 0.1);
	}

	/**
	 * Test method for {@link au.edu.qut.inn372.greenhat.bean.Calculation#getPaybackPeriod()}.
	 */
	@Test
	public void testSetGetPaybackPeriod() {
		double newPaybackPeriod = 6.0;
		calculation.setPaybackPeriod(newPaybackPeriod);
		assertEquals(newPaybackPeriod, calculation.getPaybackPeriod(), 0.1);
	}
	
	@Test
	public void testPaybackPeriodOf0() {
		double newPaybackPeriod = 0.0;
		calculation.setPaybackPeriod(newPaybackPeriod);
		assertEquals(newPaybackPeriod, calculation.getPaybackPeriod(), 0.1);
	}
	
	@Test
	public void testHighPaybackPeriod() {
		double newPaybackPeriod = 999.99;
		calculation.setPaybackPeriod(newPaybackPeriod);
		assertEquals(newPaybackPeriod, calculation.getPaybackPeriod(), 0.1);
	}
}
