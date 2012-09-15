package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private static final double SOLAR_POWER = 4.5;
	private Calculator calculator;
	private Equipment equipment;
	private Customer customer;
	private Calculation calculation;
	private Calculation[] calculations;
	private Panel panel1;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
		customer = new Customer();
		equipment = new Equipment();
		equipment.setCost(10.0);
		calculation = new Calculation();
		calculations = new Calculation[1];
		Inverter inverter = new Inverter();
		inverter.setEfficiency(0.95);
		inverter.setLifespan(25);
		inverter.setReplacementCost(350.0);
		inverter.setCost(100);
		equipment.setInverter(inverter);
		ArrayList<Panel> panels = new ArrayList<Panel>();
		panel1 = new Panel();
		panel1.setEfficiency(0.35);
		panel1.setEfficiencyLoss(0.65);
		panel1.setHeight(10.0);
		panel1.setId(0);
		panel1.setWidth(10.0);
		panels.add(panel1);
		equipment.setPanels(panels);
		equipment.setSize(SOLAR_POWER);
		calculator.setEquipment(equipment);
		calculator.setCalculation(calculation);
		
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
		equipment.setPanel(panel1);

		
	}

	@Test 
	public void testGetSetCustomer() {
		assertEquals(calculator.getCustomer(), customer);
		Customer newCustomer = new Customer();
		calculator.setCustomer(newCustomer);
		assertEquals(calculator.getCustomer(), newCustomer);
	}

	
	@Test
	public void testGetSetEquipment() {
		assertEquals(calculator.getEquipment(), equipment);
		Equipment newEquipment = new Equipment();
		calculator.setEquipment(newEquipment);
		assertEquals(calculator.getEquipment(), newEquipment);
	}
	
	@Test
	public void testGetSetCalculation(){
		assertEquals(calculator.getCalculation(), calculation);
		Calculation newCalculation = new Calculation();
		calculator.setCalculation((newCalculation));
		assertEquals(calculator.getCalculation(), newCalculation);
	}
	
	@Test
	public void testGetSetCalculations(){
		assertEquals(1, calculations.length);
	}
	
	@Test
	public void testCalculateReturnOnInvestment(){
		double returnOnInvestment = calculator.calculateReturnOnInvestment(10);
		assertEquals(1.0, returnOnInvestment,0.1);
	}
	
	@Test
	public void testCalculateSystemSize(){
		calculator.calculateSystemSize();
		assertEquals(0.1, equipment.getSize() , 0.1);
	}
	
	@Test
	public void testCalculateSystemCost(){
		calculator.calculateSystemCost();
		assertEquals(200, equipment.getCost(),0.1);
	}
	
	@Test
	public void testCalculateDayLightElectricityUsage(){
		double dayLightElectricityUsage = customer.getElectricityUsage().getDayTimeHourlyUsage() 
				* customer.getLocation().getSunLightHours();
		customer.setDayLightElectricityUsage(dayLightElectricityUsage);
		assertEquals(240.0, customer.getDayLightElectricityUsage(), 0.1);
	}
	
	@Test
	public void testCalculateBankPowerOutput(){
		Bank bank = new Bank();
		bank.setNumberOfPanels(2);
		bank.setPowerOutput((bank.getNumberOfPanels() * panel1.getPowerRating())/ 1000);
		assertEquals(0.2, bank.getPowerOutput(), 0.1);
	}
	
	
	
	@Test
	public void testCalculatePanelEfficiency(){ 
		double panelEfficiency = calculator.calculatePanelEfficiency(0);
		assertEquals(100, panelEfficiency, 0.1);
	}
	
	@Test
	public void calculateBankEfficiency() {
		Bank[] bank = new Bank[1];
		bank[0] = new Bank();
		bank[0].setOrientationEfficiencyLoss(0.5);
		bank[0].setAngleEfficiencyLoss(0.5);
		double bankEfficiency = calculator.calculateBankEfficiency(bank, 100.0, 0);
		assertEquals(25.0, bankEfficiency, 0.1);
	}
	
	/*@Test
	private double calculateBankDailySolarPower(Location location, Bank[] banks, double bank1Efficiency, int i) throws NumberFormatException {
		double bank1DailySolarPower = Double.parseDouble( df.format( banks[i].getPowerOutput() * (bank1Efficiency/100)
				* location.getSunLightHours() ));
		return bank1DailySolarPower;
	} */
}
