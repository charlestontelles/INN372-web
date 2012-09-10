package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
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
	private ArrayList<Panel> panels;
	private List<SelectItem> panelList;
	private String selectedNoOfPanels;
	
	@ManagedProperty (value = "#{inverter}")
	private Inverter inverter;
	
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
	 * Get the panels
	 * @return panels value of the panels property
	 */
	public ArrayList<Panel> getPanels() {
		return panels;
	}
	
	/**
	 * Set the panels
	 * @param panels new value for the panels property
	 */
	public void setPanels(ArrayList<Panel> panels) {
		this.panels = panels;
	}
	
	/**
	 * Get the panel list
	 * @return panel list value of the panel list property
	 */
	public List<SelectItem> getPanelList() {
		List<SelectItem> list = new ArrayList<SelectItem>();
	    list.add(new SelectItem(1, "1"));
	    list.add(new SelectItem(2, "2"));
	    list.add(new SelectItem(3, "3"));
	    list.add(new SelectItem(4, "4"));
	    list.add(new SelectItem(5, "5"));
	    return list;
	}
	
	/**
	 * Set the panel list
	 * @param panel list new value for the panel list property
	 */
	public void setPanelList(List<SelectItem> panelList) {
		this.panelList = panelList;
	}
	
	/**
	 * Get the selected panel
	 * @return selected panel value of the selected panel property
	 */
	public String getSelectedNoOfPanels() { 
		return selectedNoOfPanels; 
	} 
	
	/**
	 * Set the selected panel
	 * @param selected panel new value for the selected panel property
	 */
	public void setSelectedNoOfPanels(String selectedNoOfPanels) { 
		this.selectedNoOfPanels = selectedNoOfPanels; 
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
