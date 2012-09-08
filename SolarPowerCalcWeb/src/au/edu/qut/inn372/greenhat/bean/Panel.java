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
	private double efficiencyLoss = 0.7;
	
	/**
	 * Get the id
	 * @return id of the panel
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Set the id
	 * @param id new value for the panel id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get the width
	 * @return width of the panel
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Set the width
	 * @param width new width for the panel
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * Get the height
	 * @return height of the panel
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Set the height
	 * @param height new height for the panel
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Get the efficiency
	 * @return efficiency of the panel
	 */
	public double getEfficiency() {
		return efficiency;
	}
	
	/**
	 * Set the efficiency
	 * @param efficiency new panel efficiency
	 */
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	
	/**
	 * Get the efficiency
	 * @return efficiencyLoss of the panel
	 */
	public double getEfficiencyLoss() {
		return efficiencyLoss;
	}
	
	/**
	 * Set the efficiency loss
	 * @param efficiencyLoss new efficiency loss of the panel
	 */
	public void setEfficiencyLoss(double efficiencyLoss) {
		this.efficiencyLoss = efficiencyLoss;
	}
}
