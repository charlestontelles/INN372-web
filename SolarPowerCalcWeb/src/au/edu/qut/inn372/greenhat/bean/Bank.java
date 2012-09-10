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
 * Bean that represents a Roof
 * 
 * @author Joachim
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Bank implements Serializable {

	private static final long serialVersionUID = -5620428438578639760L;
	
	private double angle;
	private List<SelectItem> listOfOrientation; 
	private String selectedOrientation;
	private int panelNo;

	@ManagedProperty (value = "#{equipment}")
	private Equipment equipment;
	
	/**
	 * Get the selected panel
	 * @return selected panel value of the selected panel property
	 */
	public Equipment getEquipment(){
		return equipment;
	}
	
	/**
	 * Set the selected panel
	 * @param selected panel new value for the selected panel property
	 */
	public void setEquipment(Equipment equipment){
		this.equipment = equipment;
	}
	
	public int getPanelNo(){
		return panelNo;
	}
	
	public void setPanelNo(int panelNo){
		this.panelNo = panelNo;
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
	
}
