package au.edu.qut.inn372.greenhat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import au.edu.qut.inn372.greenhat.bean.Battery;
import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.Inverter;
import au.edu.qut.inn372.greenhat.bean.Panel;
import au.edu.qut.inn372.greenhat.dao.CalculatorDAO;
import au.edu.qut.inn372.greenhat.dao.EquipmentDAO;
import au.edu.qut.inn372.greenhat.dao.gae.CalculatorDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.EquipmentDAOImpl;

/**
 * Bean that represents a Calcualtor Controller
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class CalculatorController implements Serializable {

	private static final long serialVersionUID = 8091277788980459284L;
	private static final int customerUsageIndex = 0;
	private static final int equipmentTabIndex = 1;
	private static final int roofTabIndex = 2;
	private static final int locationTabIndex = 3;
	private static final int summaryTabIndex = 4;
	
	@ManagedProperty (value = "#{calculator}")
	private Calculator calculator;
	
	private CalculatorDAO calculatorDAO = new CalculatorDAOImpl();
	
	private Map<String,String> equipments = new HashMap<String, String>();
	List<Equipment> listEquipments;
	private int tabIndex = 0;
	
	public CalculatorController(){
		EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
		listEquipments = equipmentDAO.getEquipments();
		for (Equipment equipment : listEquipments) {
			this.equipments.put(equipment.getKitName(), equipment.getKitName());
		}
	}
	
	/**
	 * Get the calculator
	 * @return calculator value of the calculator property
	 */
	public Calculator getCalculator() {
		return calculator;
	}
	/**
	 * Set the calculator
	 * @param calculator value for the calculator property
	 */
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	/**
	 * Gets Tab Index
	 * @return
	 */
	public int getTabIndex() {
		return tabIndex;
	}
	/**
	 * Sets tabIndex
	 * @param tabIndex
	 */
	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}
	/**
	 * Gets Selected Equipment
	 * @return
	 */


	/**
	 * Get the daily solar power generated and return the page to navigate to
	 * @return
	 */
	public void calculate(){
		calculator.performCalculations();
		//this.tabIndex = 5;
		moveToOutput();//to go to the next tab
		
	}

	public void setEquipments(Map<String, String> equipments) {
		this.equipments = equipments;
	}

	public Map<String, String> getEquipments() {
		return equipments;
	}

	/**
	 * Save the calculation
	 */
	public void saveCalculation(){
		calculatorDAO.saveCalculation(calculator);
	}
	
	/**
	 * Get the list of panels
	 * @return list of panels
	 */
	public List<SelectItem> getPanels() {
		    List<SelectItem> list = new ArrayList<SelectItem>();
		    list.add(new SelectItem(1, "1"));
		    list.add(new SelectItem(2, "2"));
		    list.add(new SelectItem(3, "3"));
		    list.add(new SelectItem(4, "4"));
		    list.add(new SelectItem(5, "5"));
		    return list;
	}
	

	/**
	 * Loads selected equipment to calculator
	 */
	public void handleEquipmentChange(ValueChangeEvent event){
		for (Equipment equipment : listEquipments) {
			if (equipment.getKitName().equalsIgnoreCase(event.getNewValue().toString())){
				this.calculator.setEquipment(equipment);
				this.calculator.getEquipment().setPanel(equipment.getPanels().get(0)); //Added because selecting equipment kit 
						//was producing null pointer exception for the panel	
			}
		}
		moveToEquipment();
	}
	
	/**
	 * Move to the equipment tab
	 * @return the equipment tab
	 */
	public void moveToEquipment(){
		int currentIndex = customerUsageIndex;
		setTabIndex(currentIndex+1);
		getTabIndex();
		
	}
	
	/**
	 * Move to the roof tab
	 * @return the roof tab
	 */
	public void moveToRoof(){
		int currentIndex = equipmentTabIndex;
		setTabIndex(currentIndex+1);
		getTabIndex();
		
		//need these two to display the result in the summary tab
		//system cost is now based on the selected equipment kit
		//calculator.calculateSystemCost();
		//calculator.calculateSystemSize();
	}
	
	/**
	 * Move to the location tab
	 * @return the location tab
	 */
	public void moveToLocation(){
		int currentIndex = roofTabIndex;
		setTabIndex(currentIndex+1);
		getTabIndex();
		
		//add the banks
		
	}
	
	/**
	 * Move to the summary tab
	 * @return the summary tab
	 */
	public void moveToSummary(){
		int currentIndex = locationTabIndex;
		setTabIndex(currentIndex+1);
		getTabIndex();
	}
	
	/**
	 * Move to the output tab
	 * @return the output tab
	 */
	public void moveToOutput(){
		int currentIndex = summaryTabIndex;
		setTabIndex(currentIndex+1);
		getTabIndex(); 
	}
	
	
	
}
