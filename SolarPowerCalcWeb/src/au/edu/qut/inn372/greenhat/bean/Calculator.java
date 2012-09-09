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
	
	@ManagedProperty (value = "#{result}")
	private Result result;
	
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
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 * Calculate the daily solar power generated
	 */
	public void calculateSolarPower(){
		result.setSolarPowers();
	}
	
	public void calculateTariff(){
		result.setTariff11Fees();
	}
	
	public void calculateReplacementGenaration(){
		result.setReplacementGeneration();
	}
	
	public void calculateExportedGeneration(){
		result.setExportedGeneration();
	}
	
	public void calculateDailySavings(){
		result.setDailySavings();
	}
}
