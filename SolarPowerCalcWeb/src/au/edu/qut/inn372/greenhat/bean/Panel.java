package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a Panel
 * 
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Panel implements Serializable {

	private static final long serialVersionUID = 6525434735006191175L;
	
	private int id;
	private double width;
	private double height;
	private double efficiency;
	private double efficiencyLoss; // = 0.7;
	
	private double powerRating; // = 700; //assuming all panels have the same power rating
	private double size = 0; 
	private double cost;// = 500;
	
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
	 * Get the panel width
	 * @return width of the panel
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Set the panel width
	 * @param width new width for the panel
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * Get the panel height
	 * @return height of the panel
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Set the panel height
	 * @param height new height for the panel
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Get the panel efficiency
	 * @return efficiency of the panel
	 */
	public double getEfficiency() {
		return efficiency;
	}
	
	/**
	 * Set the panel efficiency
	 * @param efficiency new panel efficiency
	 */
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	
	/**
	 * Get the panel efficiency loss
	 * @return efficiencyLoss of the panel
	 */
	public double getEfficiencyLoss() {
		return efficiencyLoss;
	}
	
	/**
	 * Set the panel efficiency loss
	 * @param efficiencyLoss new efficiency loss of the panel
	 */
	public void setEfficiencyLoss(double effiLoss) {
		efficiencyLoss = effiLoss;
	}

	/**
	 * Get the panel power rating
	 * @return the panelPower
	 */
	public double getPowerRating() {
		return powerRating;
	}

	/**
	 * Set the panel power rating
	 * @param panelPower the panelPower to set
	 */
	public void setPowerRating(double powerRating) {
		this.powerRating = powerRating;
	}

	/**
	 * Get the panel size
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * Set the panel size
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * Get the panel cost
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Set the panel cost
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
}
