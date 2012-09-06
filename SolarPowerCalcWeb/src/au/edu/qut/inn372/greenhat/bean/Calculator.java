package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

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
	
	private double solarPower;
	
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
	 * Calculate the daily solar power generated
	 */
	public void calculateSolarPower(){
		Location location = new Location();
		location = customer.getLocation();
		this.solarPower =((equipment.getSize()
				*(location.getRoof().getPercentageNorth()/100)
				*(1-(location.getRoof().getEfficiencyLossNorth()/100)))
				+(equipment.getSize()*
						(location.getRoof().getPercentageWest()/100)
						*(1-(location.getRoof().getEfficiencyLossWest()/100))))
						*100/100*(equipment.getInverter().getEfficiency()/100)*location.getSunLightHours();
	}
	
	public void calculateTariff(){
		customer.getTariff().setTariffFees();
	}
}
