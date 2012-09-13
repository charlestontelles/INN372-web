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
		
		DecimalFormat df = new DecimalFormat("#.###");

		for(int i=0; i<25; i++){
			double panelEfficiency = Math.round( (100 - (Panel.getEfficiencyLoss() * (i-1+1))) * 100.0) /100.0;

			double bank1Efficiency = Math.round( panelEfficiency * (1-banks[0].getOrientationEfficiencyLoss())
					* (1-banks[0].getAngleEfficiencyLoss()) *100.0) /100.0;

			double bank2Efficiency = Math.round( panelEfficiency * (1-banks[1].getOrientationEfficiencyLoss())
					* (1-banks[1].getAngleEfficiencyLoss()) *100.0)/100.0;

			double bank1DailySolarPower = Double.parseDouble( df.format( banks[0].getPowerOutput() * (bank1Efficiency/100)
					* location.getSunLightHours() ));

			double bank2DailySolarPower = Double.parseDouble( df.format( banks[1].getPowerOutput() * (bank2Efficiency/100)
					* location.getSunLightHours() ));
			
			double dailySolarPower = Double.parseDouble( df.format( (bank1DailySolarPower + bank2DailySolarPower) 
					* equipment.getInverter().getEfficiency() ));
			
			double tariff11Fee = Math.round( (tariff.getTariff11Fee() * ( 
									Math.pow( (1+tariff.getAnnualTariffIncrease()/100), ((i+1)-1) ) ) ) * 100.0)/100.0 ;

			if(customer.getDayLightElectricityUsage() < dailySolarPower){
				replacementGeneration = Double.parseDouble( df.format(customer.getDayLightElectricityUsage() ));
			}
			else {
				replacementGeneration = Double.parseDouble( df.format(dailySolarPower ));
			}
			
			double exportedGeneration = Double.parseDouble(df.format(dailySolarPower - replacementGeneration));
			
			double moneySaved = Math.round( (replacementGeneration * tariff11Fee) * 100.0)/100.0;
			
			double moneyEarned = Math.round( (exportedGeneration * tariff.getFeedInFee()) * 100.0)/100.0;
			
			double dailySaving = Math.round( (moneySaved + moneyEarned) * 100.0)/100.0;
			
			double annualSaving = Math.round( (dailySaving * 365) *100.0)/100.0;
			
			cumulativeSaving = Math.round( (cumulativeSaving + annualSaving) *100.0)/100.0;
			
			double returnOnInvestment = Math.round( (cumulativeSaving/equipment.getCost()) *100.0)/100.0;
			
			calculations[i] = new Calculation(i+2012, panelEfficiency, bank1Efficiency, 
					bank2Efficiency, bank1DailySolarPower, bank2DailySolarPower,
					tariff11Fee, dailySolarPower, replacementGeneration, exportedGeneration, 
					moneySaved, moneyEarned, dailySaving, annualSaving, cumulativeSaving, returnOnInvestment);
		}
		calculatePaybackPeriod();
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
		//return (banks[0].getNumberOfPanels() * Panel.getPowerRating())/ 1000;
		bank.setNumberOfPanels(numOfPanels);
		bank.setPowerOutput((bank.getNumberOfPanels() * Panel.getPowerRating())/ 1000);
	}
	
	public void calculateDayLightElectricityUsage(){
		double dayLightElectricityUsage = customer.getElectricityUsage().getDayTimeHourlyUsage() 
				* customer.getLocation().getSunLightHours();
		customer.setDayLightElectricityUsage(dayLightElectricityUsage);
	}
	
	public void calculateSystemCost(){
		//this.cost =(Panel Cost * (No of Panels Bank 1 + No of Panels Bank 2)) + Inverter Cost;
		equipment.setCost( (Panel.getCost() * equipment.getTotalPanels()) + equipment.getInverter().getCost());
	}
	
	public void calculateSystemSize(){
		//this.size = (Panel Power Rating*(No of Panels Bank 1 + No of Panels Bank 2))/1000
		equipment.setSize( (Panel.getPowerRating() * equipment.getTotalPanels()) / 1000);
	}
}
