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
	
	//This property will be removed later....
	@ManagedProperty (value = "#{panel}")
	private Panel panel;
	
	private double solarPower;
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
	 * Get the daily solar power
	 * @return solarPower value of the solarPower property
	 */
	public double getSolarPower() {
		return solarPower;
	}

	/**
	 * Set the daily solar power
	 * @param solarPower value for the solarPower property
	 */
	public void setSolarPower(double solarPower) {
		this.solarPower = solarPower;
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
	 * Get the panel
	 * @return the panel
	 */
	public Panel getPanel() {
		return panel;
	}

	/**
	 * Set the panel
	 * @param panel the panel to set
	 */
	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	/**
	 * Calculate the daily solar power generated
	 */
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
	 * @param calculations the calculations to set
	 */
	public void setCalculations() {
		Tariff tariff = customer.getTariff();
		Location location = customer.getLocation();
		DecimalFormat df = new DecimalFormat("#.###");
		calculations = new Calculation[25];
		Roof roof = location.getRoof();
		Double cumulativeSaving = 0.0;
		
		for(int i=0; i<25; i++){
			Double tariff11Fee = Double.parseDouble( df.format( tariff.getTariff11Fee() * 
					( Math.pow( (1+tariff.getAnnualTariffIncrease()/100), ((i+1)-1) ) ) ) );

			Double solarPower  = Double.parseDouble( df.format(  ((equipment.getSize()
						* (roof.getPercentageNorth()/100)
						* (1-(roof.getEfficiencyLossNorth()/100)))
						+ (equipment.getSize()
						* (roof.getPercentageWest()/100)
						* (1-(roof.getEfficiencyLossWest()/100))))
						* (100 - panel.getEfficiencyLoss()*i)/100
						* (equipment.getInverter().getEfficiency()/100)
						* location.getSunLightHours() ));
			
			Double replacementGeneration = Double.parseDouble( df.format ( location.getSunLightHours() * 
					customer.getElectricityUsage().getDayTimeHourlyUsage() ) );
			
			Double exportedGeneration = Double.parseDouble( df.format (solarPower - replacementGeneration ));
			
			Double dailySaving = Math.round( (replacementGeneration*tariff11Fee + exportedGeneration*0.5) *100.0)/100.0;
			
			Double annualSaving = Math.round( (dailySaving * 365) *100.0)/100.0;
			
			cumulativeSaving = Math.round( (cumulativeSaving + annualSaving) *100.0)/100.0;
			
			calculations[i] = new Calculation(i+2012, tariff11Fee, solarPower, replacementGeneration,
					exportedGeneration, dailySaving, annualSaving, cumulativeSaving);
		}
	}
}
