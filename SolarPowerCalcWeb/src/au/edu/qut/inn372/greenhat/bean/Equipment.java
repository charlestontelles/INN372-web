package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents an Equipment
 * 
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Equipment implements Serializable{
	private static final long serialVersionUID = 7549990716571383217L;
	
	private double cost;
	private double size;
	private String kitName = "";
	
	@ManagedProperty (value = "#{panels}")
	private List<Panel> panels = new ArrayList<Panel>();
	
	@ManagedProperty (value = "#{inverter}")
	private Inverter inverter;
	
	@ManagedProperty (value = "#{battery}")
	private Battery battery;
	
	/**
	 * Get the inverter
	 * @return the inverter value of the inverter property
	 */
	public Inverter getInverter() {
		return inverter;
	}
	
	/**
	 * Set the inverter 
	 * @param inverter new value for the inverter property
	 */
	public void setInverter(Inverter inverter) {
		this.inverter = inverter;
	}
	
	
	/**
	 * Get the battery
	 * @return Battery
	 */
	public Battery getBattery() {
		return battery;
	}
	/**
	 * Set the battery
	 * @param battery to set
	 */
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	
	/**
	 * Get the panels
	 * @return panels value of the panels property
	 */
	public List<Panel> getPanels() {
		return panels;
	}
	
	/**
	 * Set the panels
	 * @param panels new value for the panels property
	 */
	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}
	
	/**
	 * Add panel to Panel List
	 * @param panel
	 */
	public void addPanel (Panel panel){
		this.panels.add(panel);
	}
	
	/**
	 * Remove panel from Panel List
	 * @param panel
	 */
	public void removePanel (Panel panel){
		this.panels.remove(panel);
	}
	
	/**
	 * Get Kit name
	 * @return kit name
	 */
	public String getKitName() {
		return kitName;
	}
	
	/**
	 * Set kit name
	 * @param kitName
	 */
	public void setKitName(String kitName) {
		this.kitName = kitName;
	}

	/**
	 * Get the selected panel
	 * @return selected panel value of the selected panel property
	 */
	public int getTotalPanels() { 
		if (this.panels != null)
			return this.panels.size();
		else
			return 0;
	} 

	/**
	 * Get the cost
	 * @return cost value of the cost property
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Set the cost
	 * @param cost value for the cost property
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Get the size of the system
	 * @return size value of the size property
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Set the size of the system
	 * @param size value for the size property
	 */
	public void setSize(double size) {
		this.size = size; 
	}
}
