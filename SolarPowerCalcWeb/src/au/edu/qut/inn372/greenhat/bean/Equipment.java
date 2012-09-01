package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
/**
 * Bean that represents a Equipment
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
	private ArrayList<Panel> panels;
	
	@ManagedProperty (value = "#{inverter}")
	private Inverter inverter;
	
	/**
	 * Get the inverter
	 * @return the inverter
	 */
	public Inverter getInverter() {
		return inverter;
	}
	
	/**
	 * Set the inverter
	 * @param inverter
	 */
	public void setInverter(Inverter inverter) {
		this.inverter = inverter;
	}
	
	/**
	 * Get the panels
	 * @return panels
	 */
	public ArrayList<Panel> getPanels() {
		return panels;
	}
	
	/**
	 * Set the panels
	 * @param panels
	 */
	public void setPanels(ArrayList<Panel> panels) {
		this.panels = panels;
	}
	
	/**
	 * Get the cost
	 * @return
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Set the cost
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Get the size of the system
	 * @return
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Set the size of the system
	 * @param size
	 */
	public void setSize(double size) {
		this.size = size;
	}
}
