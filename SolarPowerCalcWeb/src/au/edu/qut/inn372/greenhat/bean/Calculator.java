package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
/**
 * Bean that represents a Calculator
 * 
 * @author Charleston Telles
 * @version 0.2
 */
@ManagedBean
@SessionScoped
public class Calculator implements Serializable {
	private static final long serialVersionUID = 8267206547724271616L;
	
	@ManagedProperty (value = "#{equipment}")
	private Equipment equipment;
	
	@ManagedProperty (value = "#{customer}")
	private Customer customer;
	
	@ManagedProperty (value = "#{calculation}")
	private Calculation calculation;
	
	private Calculation [] calculations;
	
	DecimalFormat df = new DecimalFormat("#.###");
	
	/**
	 * Get the customer
	 * @return customer value of the customer property
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Set the customer
	 * @param customer value for the customer property
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Set the equipment
	 * @param equipment value for the equipment property
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	/**
	 * Get the equipment
	 * @return equipment value of the equipment property
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * Get the calculation
	 * @return the calculation
	 */
	public Calculation getCalculation() {
		return calculation;
	}

	/**
	 * Set the calculation
	 * @param calculation the calculation to set
	 */
	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	/**
	 * Get the calculations for a specified range of years
	 * @return the calculations
	 */
	public Calculation[] getCalculations() {
		return calculations;
	}

	/**
	 * Set the calculations for a specified range of years
	 ******This method contains huge junk of code just to get the functionality working, 
	 ******it will be reviewed and refactored.****************************************** 
	 *
	 * @param calculations the calculations to set
	 */
	public void performCalculations() {
		Tariff tariff = customer.getTariff();
		Location location = customer.getLocation();
		Roof roof = location.getRoof();
		Bank[] banks = roof.getBanks();
		calculations = new Calculation[25];
		double cumulativeSaving = 0.0;
		double replacementGeneration = 0.0;
		
		calculateBankPowerOutput(banks[1]);
		calculateBankPowerOutput(banks[2]);
		
		calculateDayLightElectricityUsage();
		
		for(int i=0; i<25; i++){
			double panelEfficiency = calculatePanelEfficiency(i);
			double bank1Efficiency = calculateBankEfficiency(banks, panelEfficiency, 1);
			double bank2Efficiency = calculateBankEfficiency(banks, panelEfficiency, 2);
			double bank1DailySolarPower = calculateBankDailySolarPower(location, banks, bank1Efficiency, 1);
			double bank2DailySolarPower = calculateBankDailySolarPower(location, banks, bank2Efficiency, 2);	
			double dailySolarPower = calculateDailySolarPower(bank1DailySolarPower, bank2DailySolarPower);
			double annualSolarPower = Math.round( (dailySolarPower *365)*1000.0)/1000.0;
			double tariff11Fee = calculateTariff11Fee(tariff, i);
			replacementGeneration = calculateReplacementGeneration(dailySolarPower);
			double exportedGeneration = calculateExportedGeneration(replacementGeneration, dailySolarPower);
			double moneySaved = calculateMoneySaved(replacementGeneration, tariff11Fee);
			double moneyEarned = calculateMoneyEarned(tariff, exportedGeneration);
			double dailySaving = calculateDailySaving(moneySaved, moneyEarned);
			double annualSaving = calculateAnnualSaving(dailySaving);
			cumulativeSaving = Math.round( (cumulativeSaving + annualSaving) *100.0)/100.0;
			double returnOnInvestment = calculateReturnOnInvestment(cumulativeSaving);
			
			calculations[i] = new Calculation(i+2012, panelEfficiency, bank1Efficiency, 
					bank2Efficiency, bank1DailySolarPower, bank2DailySolarPower,
					tariff11Fee, dailySolarPower, annualSolarPower, replacementGeneration, exportedGeneration, 
					moneySaved, moneyEarned, dailySaving, annualSaving, cumulativeSaving, returnOnInvestment);
		}
		calculatePaybackPeriod();
	}

	/**
	 * Calculate return on investment
	 * @param cumulativeSaving
	 * @return
	 */
	public double calculateReturnOnInvestment(double cumulativeSaving) {
		double returnOnInvestment = Math.round( (cumulativeSaving/equipment.getCost()) *100.0)/100.0;
		return returnOnInvestment;
	}

	/**
	 * Calculate annual saving
	 * @param dailySaving
	 * @return
	 */
	public double calculateAnnualSaving(double dailySaving) {
		double annualSaving = Math.round( (dailySaving * 365) *100.0)/100.0;
		return annualSaving;
	}

	/**
	 * Calculate daily saving
	 * @param moneySaved
	 * @param moneyEarned
	 * @return
	 */
	private double calculateDailySaving(double moneySaved, double moneyEarned) {
		double dailySaving = Math.round( (moneySaved + moneyEarned) * 100.0)/100.0;
		return dailySaving;
	}

	/**
	 * Calculate money earned from exporting solar generation (excess energy produced)
	 * @param tariff
	 * @param exportedGeneration
	 * @return
	 */
	private double calculateMoneyEarned(Tariff tariff, double exportedGeneration) {
		double moneyEarned = Math.round( (exportedGeneration * tariff.getFeedInFee()) * 100.0)/100.0;
		return moneyEarned;
	}

	/**
	 * Money saved from replacement solar generation (energy saved)
	 * @param replacementGeneration
	 * @param tariff11Fee
	 * @return
	 */
	private double calculateMoneySaved(double replacementGeneration,
			double tariff11Fee) {
		double moneySaved = Math.round( (replacementGeneration * tariff11Fee) * 100.0)/100.0;
		return moneySaved;
	}

	/**
	 * Calculate exported solar generation (excess energy produced)
	 * @param replacementGeneration
	 * @param df
	 * @param dailySolarPower
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateExportedGeneration(double replacementGeneration,double dailySolarPower)
			throws NumberFormatException {
		double exportedGeneration = Math.round( (dailySolarPower - replacementGeneration) *1000.0)/1000.0;
		return exportedGeneration;
	}

	/**
	 * Calculate replacement solar generation (energy saved)
	 * @param df
	 * @param dailySolarPower
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateReplacementGeneration(double dailySolarPower) throws NumberFormatException {
		double replacementGeneration;
		if(customer.getDayLightElectricityUsage() > dailySolarPower){
			replacementGeneration = Math.round (dailySolarPower *1000.0)/1000.0;
		}
		else {
			replacementGeneration = Math.round (customer.getDayLightElectricityUsage() *1000.0)/1000.0;
		}
		return replacementGeneration;
	}

	/**
	 * Calculate tariff 11 fee for given year
	 * @param tariff
	 * @param i
	 * @return
	 */
	private double calculateTariff11Fee(Tariff tariff, int i) {
		double tariff11Fee = Math.round( (tariff.getTariff11Fee() * ( 
								Math.pow( (1+tariff.getAnnualTariffIncrease()/100.0), ((i+1)-1) ) ) ) * 100.0)/100.0 ;
		return tariff11Fee;
	}

	/**
	 * Calculate daily solar power
	 * @param bank1DailySolarPower
	 * @param bank2DailySolarPower
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateDailySolarPower(double bank1DailySolarPower, double bank2DailySolarPower) 
			throws NumberFormatException {
		double dailySolarPower = Math.round ( ((bank1DailySolarPower + bank2DailySolarPower) 
				* equipment.getInverter().getEfficiency()/100.0 )*1000.0)/1000.0;
		return dailySolarPower;
	}

	/**
	 * Calculate a bank's daily solar power
	 * @param location
	 * @param banks
	 * @param bank1Efficiency
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateBankDailySolarPower(Location location, Bank[] banks, double bank1Efficiency, int i) throws NumberFormatException {
		double bank1DailySolarPower = Math.round( (banks[i].getPowerOutput() * (bank1Efficiency/100)
				* location.getSunLightHours())*1000.0)/1000.0;
		return bank1DailySolarPower;
	}

	/**
	 * Calculate a bank's efficiency
	 * @param banks
	 * @param panelEfficiency
	 * @return
	 */
	public double calculateBankEfficiency(Bank[] banks, double panelEfficiency, int i) {
		double bank1Efficiency = Math.round( panelEfficiency * (1-banks[i].getOrientationEfficiencyLoss()/100)
				* (1-banks[i].getAngleEfficiencyLoss()/100) *100.0) /100.0;
		return bank1Efficiency;
	}

	/**
	 * Calculate panel efficiency
	 * @param i
	 * @return
	 */
	public double calculatePanelEfficiency(int i) {
		//double panelEfficiency = Math.round( (100 - (equipment.getPanel().getEfficiencyLoss() * (i-1+1))) * 100.0) /100.0;
		double panelEfficiency = Math.round( (100 - (equipment.getPanels().get(0).getEfficiencyLoss() * (i-1+1))) * 100.0) /100.0;
		return panelEfficiency;
	}

	/**
	 * Calculate the payback period
	 * @param paybackPeriod the paybackPeriod to set
	 */
	public void calculatePaybackPeriod() {
		int pbp = 1;
		for(int i=0; i<25; i++){
			if(calculations[i].getReturnOnInvestment() < 1){
				pbp++;
			}
		}
		calculation.setPaybackPeriod(pbp);
	}

	/**
	 * Calculate a bank's power output
	 * @param bank
	 * @param numOfPanels
	 */
	public void calculateBankPowerOutput(Bank bank){
		//bank.setNumberOfPanels(equipment.getPanels().size());
		bank.setPowerOutput((bank.getNumberOfPanels() * equipment.getPanels().get(0).getPowerRating())/ 1000);
	}
	
	/**
	 * Calculate a day light electricity usage
	 */
	public void calculateDayLightElectricityUsage(){
		double dayLightElectricityUsage = customer.getElectricityUsage().getDayTimeHourlyUsage() 
				* customer.getLocation().getSunLightHours();
		customer.setDayLightElectricityUsage(dayLightElectricityUsage);
	}
	
	/**
	 * Calculate the system cost
	 */
	public void calculateSystemCost(){
		equipment.setCost( (equipment.getPanels().get(0).getCost() * equipment.getTotalPanels()) + equipment.getInverter().getCost());
	}
	
	/**
	 * Calculate the system size
	 */
	public void calculateSystemSize(){
		equipment.setSize( (equipment.getPanels().get(0).getPowerRating() * equipment.getTotalPanels()) / 1000);
	}
}
