package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a Battery
 * 
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Battery implements Serializable{

	/**
	 * Unique identifier
	 */
	private static final long serialVersionUID = -4373394917607346069L;
	/**
	 * Battery Cost
	 */
	private double cost;
	
	/**
	 * Gets battery cost
	 * @return cost to get
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Sets battery cost
	 * @param cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	

}
