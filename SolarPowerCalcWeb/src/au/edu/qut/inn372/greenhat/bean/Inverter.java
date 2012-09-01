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
	
	private double efficiency;
	private double lifespan;
	private double replacementCost;
	
	/**
	 * Get the efficiency
	 * @return
	 */
	public double getEfficiency() {
		return efficiency;
	}
	
	/**
	 * Set the efficiency
	 * @param efficiency
	 */
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	
	/**
	 * Get the lifespan
	 * @return
	 */
	public double getLifespan() {
		return lifespan;
	}
	
	/**
	 * Set the lifespan
	 * @param lifespan
	 */
	public void setLifespan(double lifespan) {
		this.lifespan = lifespan;
	}
	
	/**
	 * Get the replacement cost
	 * @return replacementCost
	 */
	public double getReplacementCost() {
		return replacementCost;
	}
	
	/**
	 * Set the replacementCost
	 * @param replacementCost
	 */
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
}
