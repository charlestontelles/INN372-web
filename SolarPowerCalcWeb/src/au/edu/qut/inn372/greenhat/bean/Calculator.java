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
	 * @return the calculation
	 */
	public Calculation getCalculation() {
		return calculation;
	}

	/**
	 * @param calculation the calculation to set
	 */
	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	public void calculateSolarPower(){
		//result.setSolarPowers();
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
		calculateSystemCost();
		calculateSystemSize();
		
		//calculateBankOrientationEfficiencyLoss(banks[0], 10/100);
		banks[0].setOrientationEfficiencyLoss(0.1);
		//calculateBankAngleEfficiencyLoss(banks[0], 3/100);
		banks[0].setAngleEfficiencyLoss(0.03);
		
		//calculateBankOrientationEfficiencyLoss(banks[1], 17/100);
		banks[1].setOrientationEfficiencyLoss(0.17);
		//calculateBankAngleEfficiencyLoss(banks[1], 5/100);
		banks[1].setAngleEfficiencyLoss(0.05);
		
		calculateBankPowerOutput(banks[0],3);
		calculateBankPowerOutput(banks[1],5);
		
		calculateDayLightElectricityUsage();
		
		for(int i=0; i<25; i++){
			double panelEfficiency = calculatePanelEfficiency(i);
			double bank1Efficiency = calculateBankEfficiency(banks, panelEfficiency,0);
			double bank2Efficiency = calculateBankEfficiency(banks, panelEfficiency, 1);
			double bank1DailySolarPower = calculateBankDailySolarPower(location, banks, bank1Efficiency, 0);
			double bank2DailySolarPower = calculateBankDailySolarPower(location, banks, bank2Efficiency, 1);	
			double dailySolarPower = calculateDailySolarPower(bank1DailySolarPower, bank2DailySolarPower);
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
					tariff11Fee, dailySolarPower, replacementGeneration, exportedGeneration, 
					moneySaved, moneyEarned, dailySaving, annualSaving, cumulativeSaving, returnOnInvestment);
		}
		calculatePaybackPeriod();
	}

	/**
	 * @param cumulativeSaving
	 * @return
	 */
	private double calculateReturnOnInvestment(double cumulativeSaving) {
		double returnOnInvestment = Math.round( (cumulativeSaving/equipment.getCost()) *100.0)/100.0;
		return returnOnInvestment;
	}

	/**
	 * @param dailySaving
	 * @return
	 */
	private double calculateAnnualSaving(double dailySaving) {
		double annualSaving = Math.round( (dailySaving * 365) *100.0)/100.0;
		return annualSaving;
	}

	/**
	 * @param moneySaved
	 * @param moneyEarned
	 * @return
	 */
	private double calculateDailySaving(double moneySaved, double moneyEarned) {
		double dailySaving = Math.round( (moneySaved + moneyEarned) * 100.0)/100.0;
		return dailySaving;
	}

	/**
	 * @param tariff
	 * @param exportedGeneration
	 * @return
	 */
	private double calculateMoneyEarned(Tariff tariff, double exportedGeneration) {
		double moneyEarned = Math.round( (exportedGeneration * tariff.getFeedInFee()) * 100.0)/100.0;
		return moneyEarned;
	}

	/**
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
	 * @param replacementGeneration
	 * @param df
	 * @param dailySolarPower
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateExportedGeneration(double replacementGeneration,double dailySolarPower)
			throws NumberFormatException {
		double exportedGeneration = Double.parseDouble(df.format(dailySolarPower - replacementGeneration));
		return exportedGeneration;
	}

	/**
	 * @param df
	 * @param dailySolarPower
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateReplacementGeneration(double dailySolarPower) throws NumberFormatException {
		double replacementGeneration;
		if(customer.getDayLightElectricityUsage() > dailySolarPower){
			replacementGeneration = Double.parseDouble( df.format(dailySolarPower));
		}
		else {
			replacementGeneration = Double.parseDouble( df.format(customer.getDayLightElectricityUsage() ));
		}
		return replacementGeneration;
	}

	/**
	 * @param tariff
	 * @param i
	 * @return
	 */
	private double calculateTariff11Fee(Tariff tariff, int i) {
		double tariff11Fee = Math.round( (tariff.getTariff11Fee() * ( 
								Math.pow( (1+tariff.getAnnualTariffIncrease()/100), ((i+1)-1) ) ) ) * 100.0)/100.0 ;
		return tariff11Fee;
	}

	/**
	 * @param df
	 * @param bank1DailySolarPower
	 * @param bank2DailySolarPower
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateDailySolarPower(double bank1DailySolarPower, double bank2DailySolarPower) 
			throws NumberFormatException {
		double dailySolarPower = Double.parseDouble( df.format( (bank1DailySolarPower + bank2DailySolarPower) 
				* equipment.getInverter().getEfficiency() ));
		return dailySolarPower;
	}

	/**
	 * @param location
	 * @param banks
	 * @param df
	 * @param bank1Efficiency
	 * @return
	 * @throws NumberFormatException
	 */
	private double calculateBankDailySolarPower(Location location, Bank[] banks, double bank1Efficiency, int i) throws NumberFormatException {
		double bank1DailySolarPower = Double.parseDouble( df.format( banks[i].getPowerOutput() * (bank1Efficiency/100)
				* location.getSunLightHours() ));
		return bank1DailySolarPower;
	}

	/**
	 * @param banks
	 * @param panelEfficiency
	 * @return
	 */
	private double calculateBankEfficiency(Bank[] banks, double panelEfficiency, int i) {
		double bank1Efficiency = Math.round( panelEfficiency * (1-banks[i].getOrientationEfficiencyLoss())
				* (1-banks[i].getAngleEfficiencyLoss()) *100.0) /100.0;
		return bank1Efficiency;
	}

	/**
	 * @param i
	 * @return
	 */
	private double calculatePanelEfficiency(int i) {
		double panelEfficiency = Math.round( (100 - (Panel.getEfficiencyLoss() * (i-1+1))) * 100.0) /100.0;
		return panelEfficiency;
	}

	/**
	 * @param paybackPeriod the paybackPeriod to set
	 */
	public void calculatePaybackPeriod() {
		int pbp = 1;
		for(int i=0; i<25; i++){
			if(calculations[i].getReturnOnInvestment() < 1)
				pbp++;
		}
		calculation.setPaybackPeriod(pbp);
	}

	/**
	 * 
	 * @param bank
	 * @param numOfPanels
	 */
	public void calculateBankPowerOutput(Bank bank, int numOfPanels){
		bank.setNumberOfPanels(numOfPanels);
		bank.setPowerOutput((bank.getNumberOfPanels() * Panel.getPowerRating())/ 1000);
	}
	
	public void calculateDayLightElectricityUsage(){
		double dayLightElectricityUsage = customer.getElectricityUsage().getDayTimeHourlyUsage() 
				* customer.getLocation().getSunLightHours();
		customer.setDayLightElectricityUsage(dayLightElectricityUsage);
	}
	
	public void calculateSystemCost(){
		equipment.setCost( (Panel.getCost() * equipment.getTotalPanels()) + equipment.getInverter().getCost());
	}
	
	public void calculateSystemSize(){
		equipment.setSize( (Panel.getPowerRating() * equipment.getTotalPanels()) / 1000);
	}
}
