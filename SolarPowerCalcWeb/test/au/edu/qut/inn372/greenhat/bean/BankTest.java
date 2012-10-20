package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	
	private Bank bank;
	
	@Before
	public void setUp() throws Exception {
		bank = new Bank();
		bank.setAngle(20);
	}
	
	@Test
	public void testSetGetBankId(){
		int newBankId = 2;
		bank.setBankId(newBankId);
		assertEquals(bank.getBankId(), newBankId);
	}
	
	@Test
	public void testBankIdOf0(){
		int newBankId = 0;
		bank.setBankId(newBankId);
		assertEquals(bank.getBankId(), newBankId);
	}
	
	@Test
	public void testBankIdWithHighId(){
		int newBankId = 999999999;
		bank.setBankId(newBankId);
		assertEquals(bank.getBankId(), newBankId);
	}
	
	@Test 
	public void testGetSetAngle(){
		Double newAngle = 40.0;
		bank.setAngle(newAngle);
		assertEquals(bank.getAngle(), newAngle, 0.0);
	}
	
	@Test 
	public void testAngleOf0(){
		Double newAngle = 0.0;
		bank.setAngle(newAngle);
		assertEquals(bank.getAngle(), newAngle, 0.0);
	}
	
	@Test
	public void testHighAngle(){
		Double newAngle = 99999.99999;
		bank.setAngle(newAngle);
		assertEquals(bank.getAngle(), newAngle, 0.0);
	}
	
	@Test
	public void testSetGetSelectedOrientation(){
		String newSelectedOrientation = "West";
		bank.setSelectedOrientation(newSelectedOrientation);
		assertEquals(bank.getSelectedOrientation(), newSelectedOrientation);
	}
	
	@Test
	public void testSetGetEfficiency(){
		double newEfficiency = 20.0;
		bank.setEfficiency(newEfficiency);
		assertEquals(bank.getEfficiency(), newEfficiency, 0.0);
	}
	
	@Test
	public void testEfficiencyFor0(){
		double newEfficiency = 0.0;
		bank.setEfficiency(newEfficiency);
		assertEquals(bank.getEfficiency(), newEfficiency, 0.0);
	}
	
	@Test
	public void testHighEfficiency(){
		double newEfficiency = 99999.99999;
		bank.setEfficiency(newEfficiency);
		assertEquals(bank.getEfficiency(), newEfficiency, 0.0);
	}
	
	@Test
	public void testSetGetNumberOfPanels(){
		int newNumberPanels = 4;
		bank.setNumberOfPanels(newNumberPanels);
		assertEquals(bank.getNumberOfPanels(), newNumberPanels);
	}
	
	@Test
	public void testNumberOfPanelsOf0(){
		int newNumberPanels = 0;
		bank.setNumberOfPanels(newNumberPanels);
		assertEquals(bank.getNumberOfPanels(), newNumberPanels);
	}
	
	@Test
	public void testHighNumberOfPanels(){
		int newNumberPanels = 99;
		bank.setNumberOfPanels(newNumberPanels);
		assertEquals(bank.getNumberOfPanels(), newNumberPanels);
	}
	
	@Test
	public void testSetGetOrientationEfficiencyLoss(){
		double newOrientationEfficiencyLoss = 10.0;
		bank.setOrientationEfficiencyLoss(newOrientationEfficiencyLoss);
		assertEquals(bank.getOrientationEfficiencyLoss(), newOrientationEfficiencyLoss, 0.0);
	}
	
	@Test
	public void testOrientationEfficiencyLossOf0(){
		double newOrientationEfficiencyLoss = 0.0;
		bank.setOrientationEfficiencyLoss(newOrientationEfficiencyLoss);
		assertEquals(bank.getOrientationEfficiencyLoss(), newOrientationEfficiencyLoss, 0.0);
	}
	
	@Test
	public void testHighOrientationEfficiencyLoss(){
		double newOrientationEfficiencyLoss = 9999.999;
		bank.setOrientationEfficiencyLoss(newOrientationEfficiencyLoss);
		assertEquals(bank.getOrientationEfficiencyLoss(), newOrientationEfficiencyLoss, 0.0);
	}
	
	@Test
	public void testSetGetAngleEfficiencyLoss(){
		double newAngleEfficiencyLoss = 10.0;
		bank.setAngleEfficiencyLoss(newAngleEfficiencyLoss);
		assertEquals(bank.getAngleEfficiencyLoss(), newAngleEfficiencyLoss, 0.0);
	}
	
	@Test
	public void testAngleEfficiencyLossOf0(){
		double newAngleEfficiencyLoss = 0.0;
		bank.setAngleEfficiencyLoss(newAngleEfficiencyLoss);
		assertEquals(bank.getAngleEfficiencyLoss(), newAngleEfficiencyLoss, 0.0);
	}
	
	@Test
	public void testHighAngleEfficiencyLoss(){
		double newAngleEfficiencyLoss = 9999.9999;
		bank.setAngleEfficiencyLoss(newAngleEfficiencyLoss);
		assertEquals(bank.getAngleEfficiencyLoss(), newAngleEfficiencyLoss, 0.0);
	}
	
	@Test
	public void testSetGetPowerOutput(){
		double newPowerOutput = 70.0;
		bank.setPowerOutput(newPowerOutput);
		assertEquals(bank.getPowerOutput(), newPowerOutput, 0.0);
	}
	
	@Test
	public void testPowerOutputOf0(){
		double newPowerOutput = 0.0;
		bank.setPowerOutput(newPowerOutput);
		assertEquals(bank.getPowerOutput(), newPowerOutput, 0.0);
	}
	
	@Test
	public void testHighPowerOutput(){
		double newPowerOutput = 999.999;
		bank.setPowerOutput(newPowerOutput);
		assertEquals(bank.getPowerOutput(), newPowerOutput, 0.0);
	}
	
	@Test
	public void testSetGetOrientation(){
		double newOrientation = 10.0;
		bank.setOrientation(newOrientation);
		assertEquals(bank.getOrientation(), newOrientation, 0.0);
	}
	
	@Test
	public void testOrientationOf0(){
		double newOrientation = 0.0;
		bank.setOrientation(newOrientation);
		assertEquals(bank.getOrientation(), newOrientation, 0.0);
	}
	
	@Test
	public void testHighOrientation(){
		double newOrientation = 9999.999;
		bank.setOrientation(newOrientation);
		assertEquals(bank.getOrientation(), newOrientation, 0.0);
	}
}
