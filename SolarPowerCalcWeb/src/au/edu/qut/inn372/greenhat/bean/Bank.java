/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

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
	private List<SelectItem> listOfOrientation; 
	private String selectedOrientation;
	
	//Added by Martin
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
	 * Get the orientation list
	 * @return orientation list value of the orientation list property
	 */
	public List<SelectItem> getListOfOrientation() {
		List<SelectItem> list = new ArrayList<SelectItem>();
	    list.add(new SelectItem(1, "North"));
	    list.add(new SelectItem(2, "North East"));
	    list.add(new SelectItem(3, "North West"));
	    list.add(new SelectItem(4, "South"));
	    list.add(new SelectItem(5, "South East"));
	    list.add(new SelectItem(6, "South West"));
	    list.add(new SelectItem(7, "East"));
	    list.add(new SelectItem(8, "West"));
	    return list;
	}
	
	/**
	 * Set the orientation list
	 * @param orientation list new value for the orientation list property
	 */
	public void setListOfOrientation(List<SelectItem> listOfOrientation) {
		this.listOfOrientation = listOfOrientation;
	}
	
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
	 * @return the efficiency
	 */
	public Double getEfficiency() {
		return efficiency;
	}

	/**
	 * @param efficiency the efficiency to set
	 */
	public void setEfficiency(Double efficiency) {
		this.efficiency = efficiency;
	}

	/**
	 * @return the numberOfPanels
	 */
	public int getNumberOfPanels() {
		return numberOfPanels;
	}

	/**
	 * @param numberOfPanels the numberOfPanels to set
	 */
	public void setNumberOfPanels(int numberOfPanels) {
		this.numberOfPanels = numberOfPanels;
	}

	/**
	 * @return the orientationEfficiencyLoss
	 */
	public double getOrientationEfficiencyLoss() {
		return orientationEfficiencyLoss;
	}

	/**
	 * @param orientationEfficiencyLoss the orientationEfficiencyLoss to set
	 */
	public void setOrientationEfficiencyLoss(double orientationEfficiencyLoss) {
		this.orientationEfficiencyLoss = orientationEfficiencyLoss;
	}

	/**
	 * @return the angleEfficiencyLoss
	 */
	public double getAngleEfficiencyLoss() {
		return angleEfficiencyLoss;
	}

	/**
	 * @param angleEfficiencyLoss the angleEfficiencyLoss to set
	 */
	public void setAngleEfficiencyLoss(double angleEfficiencyLoss) {
		this.angleEfficiencyLoss = angleEfficiencyLoss;
	}

	/**
	 * @return the powerOutput
	 */
	public double getPowerOutput() {
		return powerOutput;
	}

	/**
	 * @param powerOutput the powerOutput to set
	 */
	public void setPowerOutput(double powerOutput){
		this.powerOutput = powerOutput;
	}

	/**
	 * @return the orientation
	 */
	public double getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation the orientation to set
	 */
	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}
}
