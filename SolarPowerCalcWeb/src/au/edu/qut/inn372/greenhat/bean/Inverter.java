/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * Bean that represents a Calculator
 * 
 * @author Martin Daniel
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Inverter implements Serializable{

	private static final long serialVersionUID = 6903832305061311100L;
	
	private double efficiency = 0.95;
	private double lifespan;
	private double replacementCost;
	private double cost = 5000;
	
	/**
	 * Get the efficiency
	 * @return efficiency value of the inverter efficiency
	 */
	public double getEfficiency() {
		return efficiency;
	}
	
	/**
	 * Set the efficiency
	 * @param efficiency new value for the inverter efficiency
	 */
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	
	/**
	 * Get the lifespan
	 * @return lifespan value for the lifespan
	 */
	public double getLifespan() {
		return lifespan;
	}
	
	/**
	 * Set the lifespan
	 * @param lifespan new value for the lifespan
	 */
	public void setLifespan(double lifespan) {
		this.lifespan = lifespan;
	}
	
	/**
	 * Get the replacement cost
	 * @return replacementCost value of the replacement cost
	 */
	public double getReplacementCost() {
		return replacementCost;
	}
	
	/**
	 * Set the replacementCost
	 * @param replacementCost new value for the replacement cost
	 */
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
}
