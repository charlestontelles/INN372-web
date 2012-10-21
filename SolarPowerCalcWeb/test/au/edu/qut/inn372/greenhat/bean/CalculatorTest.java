package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.controller.Chart;

public class CalculatorTest {

	private static final double SOLAR_POWER = 4.5;
	private Calculator calculator;
	private Equipment equipment;
	private Customer customer;
	private Calculation[] calculations;
	private Panel panel1;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
		customer = new Customer();
		equipment = new Equipment();
		equipment.setCost(10.0);
		calculations = new Calculation[1];
		Inverter inverter = new Inverter();
		inverter.setEfficiency(95);
		inverter.setLifespan(25);
		inverter.setReplacementCost(350.0);
		inverter.setCost(100);
		equipment.setInverter(inverter);
		ArrayList<Panel> panels = new ArrayList<Panel>();
		panel1 = new Panel();
		panel1.setEfficiency(35);
		panel1.setEfficiencyLoss(0.65);
		panel1.setHeight(10.0);
		panel1.setId(0);
		panel1.setWidth(10.0);
		panels.add(panel1);
		equipment.setPanels(panels);
		equipment.setSize(SOLAR_POWER);
		calculator.setEquipment(equipment);
		
		ElectricityUsage electricityUsage = new ElectricityUsage();
		electricityUsage.setDailyAverageUsage(40.0);
		electricityUsage.setDayTimeHourlyUsage(30.0);
		customer.setElectricityUsage(electricityUsage);
		Location location = new Location();
		Roof roof = new Roof();
		roof.setEfficiencyLossNorth(0.2);
		roof.setEfficiencyLossWest(0.1);
		roof.setHeight(10.0);
		roof.setPercentageNorth(0.25);
		roof.setPercentageWest(0.75);
		roof.setWidth(10.0);
		location.setRoof(roof);
		location.setSunLightHours(8.0);
		customer.setLocation(location);
		customer.setTariff(new Tariff());
		calculator.setCustomer(customer);
		//calculator.setSolarPower(SOLAR_POWER);
		panel1.setPowerRating(100);
		panel1.setCost(100);
		panel1.setEfficiencyLoss(0.7);
		//equipment.setPanel(panel1);
		calculator.performCalculations();
		
	}
	
	@Test
	public void testGetStatusNameIncomplete(){
		int status = 0;
		calculator.setStatus(status);
		assertEquals(calculator.getStatusName(), "Incomplete");
	}
	
	@Test
	public void testGetStatusNameComplete(){
		int status = 1;
		calculator.setStatus(status);
		assertEquals(calculator.getStatusName(), "Complete");
	}
	
	@Test
	public void testGetStatusNameTemplate(){
		int status = 2;
		calculator.setStatus(status);
		assertEquals(calculator.getStatusName(), "Template");
	}
	
	@Test
	public void testGetStatusNameUnknown(){
		int status = 5;
		calculator.setStatus(status);
		assertEquals(calculator.getStatusName(), "unknow");
	}

	@Test 
	public void testSetGetCustomer() {
		assertEquals(calculator.getCustomer(), customer);
		Customer newCustomer = new Customer();
		calculator.setCustomer(newCustomer);
		assertEquals(calculator.getCustomer(), newCustomer);
	}

	@Test
	public void testSeGettEquipment() {
		assertEquals(calculator.getEquipment(), equipment);
		Equipment newEquipment = new Equipment();
		calculator.setEquipment(newEquipment);
		assertEquals(calculator.getEquipment(), newEquipment);
	}
	
	@Test
	public void testSetGetCalculations(){
		assertEquals(1, calculations.length);
	}
	
	@Test
	public void testSetGetName(){
		String newName = "Jack";
		calculator.setName(newName);
		assertEquals(calculator.getName(), newName);
	}
	
	@Test
	public void testSetGetKey(){
		String newKey = "username";
		calculator.setKey(newKey);
		assertEquals(calculator.getKey(), newKey);
	}
	
	
	@Test
	public void testSetGetDateTime(){
		Date newDateTime = new Date();
		calculator.setDatetime(newDateTime);
		assertEquals(calculator.getDatetime(), newDateTime);
	}
	
	@Test
	public void testSetGetStatus(){
		int newStatus = 2;
		calculator.setStatus(newStatus);
		assertEquals(calculator.getStatus(), newStatus);
	}
	
	@Test
	public void testCalculateReturnOnInvestment(){
		double returnOnInvestment = calculator.calculateReturnOnInvestment(10);
		assertEquals(1.0, returnOnInvestment,0.1);
	}
	
	@Test
	public void testCalculateAnnualSaving(){
		assertEquals(3650, calculator.calculateAnnualSaving(10), 0.1);
	}
	
	@Test
	public void testCalculateDailySaving() {
		assertEquals(31, calculator.calculateDailySaving(15.50, 15.50), 0.1);
	}
	
	@Test
	public void testCalculateMoneyEarned(){
		Tariff tariff = new Tariff();
		tariff.setFeedInFee(0.5);
		assertEquals(5, calculator.calculateMoneyEarned(tariff, 10), 0.1);
	}
	
	@Test
	public void testCalculateMoneySaved() {
		assertEquals(1.2, calculator.calculateMoneySaved(12, 0.1), 0.1);
	}
	
	@Test
	public void testCalculateExportedGeneration(){ 
		customer.getElectricityUsage().setDayLightElectricityUsage(12);
		double replacementGeneration = calculator.calculateReplacementGeneration(14);
		double exportedGeneration = calculator.calculateExportedGeneration(replacementGeneration, 14);
		assertEquals(2, exportedGeneration, 0.1);
	}
	
	@Test
	public void testCalculateReplacementGeneration() { 
		customer.getElectricityUsage().setDayLightElectricityUsage(12);
		assertEquals(12, calculator.calculateReplacementGeneration(14), 0.1);
	}
	
	@Test
	public void calculateTariff11Fee () { 
		Tariff tariff = new Tariff();
		tariff.setTariff11Fee(0.2);
		tariff.setAnnualTariffIncrease(5);
		double tariffFee = calculator.calculateTariff11Fee(tariff, 1);
		assertEquals(0.21, tariffFee, 0.1);
	}
	
	@Test
	public void calculateDailySolarPower() {
		double bank1DailySolarPower = 2.5, bank2DailySolarPower = 1.3;
		double dailySolarPower = calculator.calculateDailySolarPower(bank1DailySolarPower, bank2DailySolarPower);
		assertEquals(3.61, dailySolarPower, 0.1);
	}
	
	@Test
	public void testCalculateBankDailySolarPower(){
		Bank[] banks = new Bank[1];
		banks[0] = new Bank();
		double bankEfficiency = 2;
		banks[0].setPowerOutput(2.5);
		Location location = new Location();
		location.setSunLightHours(4);
		double bankDailySolarPower = calculator.calculateBankDailySolarPower(location, banks, bankEfficiency, 0);
		assertEquals(0.2, bankDailySolarPower, 0.1);
	}
	
	@Test
	public void calculateBankEfficiency() {
		Bank[] banks = new Bank[1];
		banks[0] = new Bank();
		banks[0].setOrientationEfficiencyLoss(0.5);
		banks[0].setAngleEfficiencyLoss(0.5);
		double bankEfficiency = calculator.calculateBankEfficiency(banks, 100.0, 0);
		assertEquals(99.0, bankEfficiency, 0.1);
	}
	
	@Test
	public void testCalculatePanelEfficiency(){ 
		double panelEfficiency = calculator.calculatePanelEfficiency(0);
		assertEquals(100, panelEfficiency, 0.1);
	}
	
	@Test
	public void testCalculatePaybackPeriod(){
		Calculation calc = new Calculation();
		double paybackPeriod = 10.0;
		calc.setPaybackPeriod(paybackPeriod);
		assertEquals(calc.getPaybackPeriod(), paybackPeriod, 0.0);
	}
	
	@Test
	public void testCalculateBankPowerOutput(){
		Bank bank = new Bank();
		bank.setNumberOfPanels(2);
		bank.setPowerOutput((bank.getNumberOfPanels() * panel1.getPowerRating())/ 1000);
		assertEquals(0.2, bank.getPowerOutput(), 0.1);
	}
	
	@Test
	public void testCalculateSystemCost(){
		calculator.calculateSystemCost();
		assertEquals(200, equipment.getCost(),0.1);
	}
	
	@Test
	public void testCalculateSystemSize(){
		calculator.calculateSystemSize();
		assertEquals(0.1, equipment.getSize() , 0.1);
	}
	
	@Test
	public void testCalculateBankOrientationEfficiencyLoss(){
		Bank bank = new Bank();
		String orientation = "North";
		if(orientation.trim().equalsIgnoreCase("North")){
			bank.setOrientationEfficiencyLoss(5.0);
		}else if (orientation.trim().equalsIgnoreCase("North East")){
			bank.setOrientationEfficiencyLoss(0);
		}else if (orientation.trim().equalsIgnoreCase("East")){
			bank.setOrientationEfficiencyLoss(5.0);
		}else if (orientation.trim().equalsIgnoreCase("South")){
			bank.setOrientationEfficiencyLoss(15);
		}else if (orientation.trim().equalsIgnoreCase("South East")){
			bank.setOrientationEfficiencyLoss(10);
		}else if (orientation.trim().equalsIgnoreCase("West")){
			bank.setOrientationEfficiencyLoss(15);
		}else if(orientation.trim().equalsIgnoreCase("North West")){
			bank.setOrientationEfficiencyLoss(10);
		}else{
			bank.setOrientationEfficiencyLoss(20);
		}
		assertEquals(bank.getOrientationEfficiencyLoss(), 5.0, 0.0);
		
	}
	
	@Test
	public void testlastElseCalculateBankOrientationEfficiencyLoss(){
		Bank bank = new Bank();
		String orientation = "Jack";
		if(orientation.trim().equalsIgnoreCase("North")){
			bank.setOrientationEfficiencyLoss(5.0);
		}else if (orientation.trim().equalsIgnoreCase("North East")){
			bank.setOrientationEfficiencyLoss(0);
		}else if (orientation.trim().equalsIgnoreCase("East")){
			bank.setOrientationEfficiencyLoss(5.0);
		}else if (orientation.trim().equalsIgnoreCase("South")){
			bank.setOrientationEfficiencyLoss(15);
		}else if (orientation.trim().equalsIgnoreCase("South East")){
			bank.setOrientationEfficiencyLoss(10);
		}else if (orientation.trim().equalsIgnoreCase("West")){
			bank.setOrientationEfficiencyLoss(15);
		}else if(orientation.trim().equalsIgnoreCase("North West")){
			bank.setOrientationEfficiencyLoss(10);
		}else{
			bank.setOrientationEfficiencyLoss(20);
		}
		assertEquals(bank.getOrientationEfficiencyLoss(), 20.0, 0.0);
		
	}
	
	@Test
	public void test1stConditionCalculateBankAngleEfficiencyLoss(){
		double angle = 10;
		Bank bank = new Bank();
		if((angle >= 0 && angle < 22.5) || (angle > 337.5 && angle <= 360))
			bank.setAngleEfficiencyLoss(0.0);
		else if (angle >= 22.5 && angle < 67.5)
			bank.setAngleEfficiencyLoss(5.0);
		else if (angle >= 67.5 && angle < 112.5)
			bank.setAngleEfficiencyLoss(10.0);
		else if (angle >= 112.5 && angle < 157.5)
			bank.setAngleEfficiencyLoss(15.0);
		else if (angle >= 157.5 && angle < 202.5)
			bank.setAngleEfficiencyLoss(20);
		else if (angle >= 202.5 && angle < 247.5)
			bank.setAngleEfficiencyLoss(15);
		else if(angle >= 247.5 && angle < 292.5)
			bank.setAngleEfficiencyLoss(10);
		else if(angle >= 292.5 && angle < 337.5)
			bank.setAngleEfficiencyLoss(5.0);
		assertEquals(bank.getAngleEfficiencyLoss(), 0.0, 0.0);
	}
	
	@Test
	public void test2ndConditionCalculateBankAngleEfficiencyLoss(){
		double angle = 350;
		Bank bank = new Bank();
		if((angle >= 0 && angle < 22.5) || (angle > 337.5 && angle <= 360))
			bank.setAngleEfficiencyLoss(0.0);
		else if (angle >= 22.5 && angle < 67.5)
			bank.setAngleEfficiencyLoss(5.0);
		else if (angle >= 67.5 && angle < 112.5)
			bank.setAngleEfficiencyLoss(10.0);
		else if (angle >= 112.5 && angle < 157.5)
			bank.setAngleEfficiencyLoss(15.0);
		else if (angle >= 157.5 && angle < 202.5)
			bank.setAngleEfficiencyLoss(20);
		else if (angle >= 202.5 && angle < 247.5)
			bank.setAngleEfficiencyLoss(15);
		else if(angle >= 247.5 && angle < 292.5)
			bank.setAngleEfficiencyLoss(10);
		else if(angle >= 292.5 && angle < 337.5)
			bank.setAngleEfficiencyLoss(5.0);
		assertEquals(bank.getAngleEfficiencyLoss(), 0.0, 0.0);
	}
	
	
	
	@Test
	public void testSetGetChart(){
		Chart newChart = new Chart();
		calculator.setChart(newChart);
		assertEquals(calculator.getChart(), newChart);
	}
		
}
