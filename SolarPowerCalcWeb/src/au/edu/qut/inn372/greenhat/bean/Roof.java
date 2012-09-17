
/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a Roof
 * 
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
	
	private Bank [] banks;
	
	public Roof(){
		banks = new Bank[2];
		for (int i=0; i < banks.length; i++){
			banks[i] = new Bank();
		}
	}
	

	/**
	 * Get the efficiency loss on north roof
	 * @return efficiencyLossNorth on the north roof
	 */
	public double getEfficiencyLossNorth() {
		return efficiencyLossNorth;
	}
	
	/**
	 * Set the efficiency loss on north roof
	 * @param efficiencyLossNorth new value for the efficiencyLossNorth property
	 */
	public void setEfficiencyLossNorth(double efficiencyLossNorth) {
		this.efficiencyLossNorth = efficiencyLossNorth;
	}
	
	/**
	 * Get the efficiency loss on west roof
	 * @return efficiencyLossWest on the west roof
	 */
	public double getEfficiencyLossWest() {
		return efficiencyLossWest;
	}
	
	/**
	 * Set the efficiency loss on west roof
	 * @param efficiencyLossWest new value for the efficiencyLossWest property
	 */
	public void setEfficiencyLossWest(double efficiencyLossWest) {
		this.efficiencyLossWest = efficiencyLossWest;
	}
	
	/**
	 * Get the roof width
	 * @return width of the roof
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Set the roof width
	 * @param width new value of the roof
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * Get the roof height
	 * @return height of the roof
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Set the roof height
	 * @param height new value for the roof
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Get the percentage on north roof
	 * @return percentageNorth of the north roof
	 */
	public double getPercentageNorth() {
		return percentageNorth;
	}
	
	/**
	 * Set the percentage on north roof
	 * @param percentageNorth new value of the north roof
	 */
	public void setPercentageNorth(double percentageNorth) {
		this.percentageNorth = percentageNorth;
	}
	
	/**
	 * Get the percentage on west roof
	 * @return percentageWest of the west roof
	 */
	public double getPercentageWest() {
		return percentageWest;
	}
	
	/**
	 * Set the percentage on west roof
	 * @param percentageWest new value for the west roof
	 */
	public void setPercentageWest(double percentageWest) {
		this.percentageWest = percentageWest;
	}

	/**
	 * Get the banks on the roof
	 * @return the banks
	 */
	public Bank[] getBanks() {
		return banks;
	}

	/**
	 * Set the banks on the roof
	 * @param banks the banks to set
	 */
	public void setBanks(Bank [] banks) {
		this.banks = banks;
	}
	
	public double getSize(){
		return (width * height)/10000;
	}
}