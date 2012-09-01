/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * 
 * Bean that represents a roof
 * @author Martin Daniel
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Roof implements Serializable {

	private static final long serialVersionUID = -5620428438578639760L;
	
	private double width;
	private double height;
	private double percentageNorth;
	private double percentageWest;
	private double efficiencyLossNorth;
	private double efficiencyLossWest;
	
	/**
	 * Get the efficiency loss on north roof
	 * @return
	 */
	public double getEfficiencyLossNorth() {
		return efficiencyLossNorth;
	}
	
	/**
	 * Set the efficiency loss on north roof
	 * @param efficiencyLossNorth
	 */
	public void setEfficiencyLossNorth(double efficiencyLossNorth) {
		this.efficiencyLossNorth = efficiencyLossNorth;
	}
	
	/**
	 * Get the efficiency loss on west roof
	 * @return efficiencyLossWest
	 */
	public double getEfficiencyLossWest() {
		return efficiencyLossWest;
	}
	
	/**
	 * Set the efficiency loss on west roof
	 * @param efficiencyLossWest
	 */
	public void setEfficiencyLossWest(double efficiencyLossWest) {
		this.efficiencyLossWest = efficiencyLossWest;
	}
	
	/**
	 * Get the width
	 * @return width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Set the width
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * Get the height
	 * @return height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Set the height
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Get the percentage on north roof
	 * @return percentageNorth
	 */
	public double getPercentageNorth() {
		return percentageNorth;
	}
	
	/**
	 * Set the percentage on north roof
	 * @param percentageNorth
	 */
	public void setPercentageNorth(double percentageNorth) {
		this.percentageNorth = percentageNorth;
	}
	
	/**
	 * Get the percentage on west roof
	 * @return percentageWest
	 */
	public double getPercentageWest() {
		return percentageWest;
	}
	
	/**
	 * Set the percentage on west roof
	 * @param percentageWest
	 */
	public void setPercentageWest(double percentageWest) {
		this.percentageWest = percentageWest;
	}
}
