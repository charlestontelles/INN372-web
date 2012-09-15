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
	private List<Panel> panels = new ArrayList<Panel>();
	
	@ManagedProperty (value = "#{inverter}")
	private Inverter inverter;
	
	@ManagedProperty (value = "#{panel}")
	private Panel panel;
	
	@ManagedProperty (value = "#{battery}")
	private Battery battery;
	
	//Added by Martin - what if customer wants to enter number of panels, instead of selecting from kit
	private int totalPanels;
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
	 * Gets Battery Bean
	 * @return Battery
	 */
	public Battery getBattery() {
		return battery;
	}
	/**
	 * Sets Battery Bean
	 * @param battery
	 */
	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	/**
	 * Get the panel
	 * @return the panel value of the panel property
	 */
	public Panel getPanel() {
		return panel;
	}
	
	/**
	 * Set the panel 
	 * @param panel new value for the panel property
	 */
	public void setPanel(Panel panel) {
		this.panel = panel;
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
	 * Gets Kit name
	 * @return kit name
	 */
	public String getKitName() {
		return kitName;
	}
	/**
	 * Sets kit name
	 * 
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
		//return this.panels.size();
		return totalPanels;
	} 
	
	/**
	 * @param totalPanels the totalPanels to set
	 */
	public void setTotalPanels(int totalPanels) {
		this.totalPanels = totalPanels;
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
