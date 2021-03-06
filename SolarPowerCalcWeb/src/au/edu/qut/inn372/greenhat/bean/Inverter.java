/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * Bean that represents an Inverter
 * 
 * @author Martin Daniel
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Inverter implements Serializable{

	private static final long serialVersionUID = 6903832305061311100L;
	
	private double efficiency;// = 0.95;
	private double lifespan;
	private double replacementCost;
	private double cost;// = 5000;
	private double efficiencyLoss;
	private String brand;
	private int id;
	
	/**
	 * Get the panel id
	 * @return id of the panel
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Set the panel id
	 * @param id new value for the panel id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get the efficiency
	 * @return efficiency value of the inverter efficiency
	 */
	public double getEfficiency() {
		return efficiency;
	}
	
	/**
	 * Set the efficiency of the inverter
	 * @param efficiency new value for the inverter efficiency
	 */
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	
	/**
	 * Get the lifespan of the inverter
	 * @return lifespan value for the lifespan
	 */
	public double getLifespan() {
		return lifespan;
	}
	
	/**
	 * Set the lifespan of the inverter
	 * @param lifespan new value for the lifespan
	 */
	public void setLifespan(double lifespan) {
		this.lifespan = lifespan;
	}
	
	/**
	 * Get the replacement cost of the inverter
	 * @return replacementCost value of the replacement cost
	 */
	public double getReplacementCost() {
		return replacementCost;
	}
	
	/**
	 * Set the replacementCost of the inverter
	 * @param replacementCost new value for the replacement cost
	 */
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	/**
	 * Get the cost of the inverter
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Set the cost of the inverter
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Get the efficiency loss of the inverter
	 * @return the efficiencyLoss
	 */
	public double getEfficiencyLoss() {
		return efficiencyLoss;
	}

	/**
	 * Set the efficiency loss of the inverter
	 * @param efficiencyLoss to set
	 */
	public void setEfficiencyLoss(double efficiencyLoss) {
		this.efficiencyLoss = efficiencyLoss;
	}
	
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
