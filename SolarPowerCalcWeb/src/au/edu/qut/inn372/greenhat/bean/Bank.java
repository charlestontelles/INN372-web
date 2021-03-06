/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a Bank
 * 
 * @author Joachim
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Bank implements Serializable {

	private static final long serialVersionUID = -5620428438578639760L;
	
	private int bankId;
	private double angle;
	private String selectedOrientation;
	private double efficiency;
	private int numberOfPanels;
	private double orientationEfficiencyLoss;
	private double angleEfficiencyLoss;
	private double powerOutput;
	private double orientation;
	
	/**
	 * Get the bankId
	 * @return bankId value of the bankId property
	 */
	public int getBankId(){
		return bankId;
	}
	
	/**
	 * Set the bankId
	 * @param bankId new value for the bankId property
	 */
	public void setBankId(int bankId){
		this.bankId = bankId;
	}
	
	/**
	 * Get the angle
	 * @return angle value of the angle property
	 */
	public double getAngle(){
		return angle;
	}
	
	/**
	 * Set the angle
	 * @param angle new value for the angle property
	 */
	public void setAngle(double angle){
		this.angle = angle;
	}

	/**
	 * Set the orientation list
	 * @param orientation list new value for the orientation list property
	 */
	//public void setListOfOrientation(List<SelectItem> listOfOrientation) {
	//	this.listOfOrientation = listOfOrientation;
	//}
	
	/**
	 * Get the selected orientation
	 * @return selected orientation value of the selected orientation property
	 */
	public String getSelectedOrientation() { 
		return selectedOrientation; 
	} 
	
	/**
	 * Set the selected orientation
	 * @param selected orientation new value for the selected orientation property
	 */
	public void setSelectedOrientation(String selectedOrientation) { 
		this.selectedOrientation = selectedOrientation; 
	}

	/**
	 * Get the efficiency
	 * @return the efficiency
	 */
	public Double getEfficiency() {
		return efficiency;
	}

	/**
	 * Set the efficiency
	 * @param efficiency the efficiency to set
	 */
	public void setEfficiency(Double efficiency) {
		this.efficiency = efficiency;
	}

	/**
	 * Get the number of panels
	 * @return the numberOfPanels
	 */
	public int getNumberOfPanels() {
		return numberOfPanels;
	}

	/**
	 * Set the number of panels
	 * @param numberOfPanels the numberOfPanels to set
	 */
	public void setNumberOfPanels(int numberOfPanels) {
		this.numberOfPanels = numberOfPanels;
	}

	/**
	 * Get the efficiency loss due to orientation
	 * @return the orientationEfficiencyLoss
	 */
	public double getOrientationEfficiencyLoss() {
		return orientationEfficiencyLoss;
	}

	/**
	 * Set the efficiency loss due to orientation
	 * @param orientationEfficiencyLoss the orientationEfficiencyLoss to set
	 */
	public void setOrientationEfficiencyLoss(double orientationEfficiencyLoss) {
		this.orientationEfficiencyLoss = orientationEfficiencyLoss;
	}

	/**
	 * Get the efficiency loss due to the angle
	 * @return the angleEfficiencyLoss
	 */
	public double getAngleEfficiencyLoss() {
		return angleEfficiencyLoss;
	}

	/**
	 * Set the efficiency loss due to the angle
	 * @param angleEfficiencyLoss the angleEfficiencyLoss to set
	 */
	public void setAngleEfficiencyLoss(double angleEfficiencyLoss) {
		this.angleEfficiencyLoss = angleEfficiencyLoss;
	}

	/**
	 * Get the power output
	 * @return the powerOutput
	 */
	public double getPowerOutput() {
		return powerOutput;
	}

	/**
	 * Set the power output
	 * @param powerOutput the powerOutput to set
	 */
	public void setPowerOutput(double powerOutput){
		this.powerOutput = powerOutput;
	}

	/**
	 * Get the orientation
	 * @return the orientation
	 */
	public double getOrientation() {
		return orientation;
	}

	/**
	 * Set the orientation
	 * @param orientation the orientation to set
	 */
	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}
}
