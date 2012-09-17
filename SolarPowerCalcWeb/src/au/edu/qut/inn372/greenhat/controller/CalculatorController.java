package au.edu.qut.inn372.greenhat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import au.edu.qut.inn372.greenhat.bean.Bank;
import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.Location;
import au.edu.qut.inn372.greenhat.bean.Roof;
import au.edu.qut.inn372.greenhat.dao.CalculatorDAO;
import au.edu.qut.inn372.greenhat.dao.EquipmentDAO;
import au.edu.qut.inn372.greenhat.dao.LocationDAO;
import au.edu.qut.inn372.greenhat.dao.gae.CalculatorDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.EquipmentDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.LocationDAOImpl;

/**
 * Bean that represents a Calcualtor Controller
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class CalculatorController implements Serializable {

	private static final long serialVersionUID = 8091277788980459284L;
	private static final int customerUsageIndex = 1;
	private static final int equipmentTabIndex = 2;
	private static final int roofTabIndex = 3;
	private static final int locationTabIndex = 0;
	private static final int summaryTabIndex = 4;
	
	@ManagedProperty (value = "#{calculator}")
	private Calculator calculator;
	
	private CalculatorDAO calculatorDAO = new CalculatorDAOImpl();
	
	private Map<String,String> equipments = new HashMap<String, String>();
	List<Equipment> listEquipments;
	private Map<String, String> locations = new HashMap<String, String>();
	List<Location> listLocations;
	private int tabIndex = 0;
	
	public CalculatorController(){
		EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
		listEquipments = equipmentDAO.getEquipments();
		for (Equipment equipment : listEquipments) {
			this.equipments.put(equipment.getKitName(), equipment.getKitName());
		}
		
		LocationDAO locationDAO = new LocationDAOImpl();
		listLocations = locationDAO.getLocations();
		for(Location location : listLocations){
			this.locations.put(location.getCity(), location.getCity());
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
	 * @return tab index
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
	 * Perform calculations and return the page to navigate to
	 * @return
	 */
	public void calculate(){
		calculator.performCalculations();
		//this.tabIndex = 5;
		moveToOutput();//to go to the next tab
		
	}

	/**
	 * Set the equipments
	 * @param equipments
	 */
	public void setEquipments(Map<String, String> equipments) {
		this.equipments = equipments;
	}

	/**
	 * Get the equipments
	 * @return equipments
	 */
	public Map<String, String> getEquipments() {
		return equipments;
	}
	
	/**
	 * Get the locations
	 * @return the locations
	 */
	public Map<String, String> getLocations() {
		return locations;
	}

	/**
	 * Set the locations
	 * @param locations the locations to set
	 */
	public void setLocations(Map<String, String> locations) {
		this.locations = locations;
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
	 * Get the orientation list
	 * @return orientation list value of the orientation list property
	 */
	
	public List<SelectItem> getListOfOrientation() {
		List<SelectItem> list = new ArrayList<SelectItem>();
	    list.add(new SelectItem("North", "North"));
	    list.add(new SelectItem("North East", "North East"));
	    list.add(new SelectItem("North West", "North West"));
	    list.add(new SelectItem("South", "South"));
	    list.add(new SelectItem("South East", "South East"));
	    list.add(new SelectItem("South West", "South West"));
	    list.add(new SelectItem("West", "West"));
	    list.add(new SelectItem("East", "East"));
	    return list;
	}
	
	/**
	 * Loads selected equipment to calculator
	 */
	public void handleEquipmentChange(ValueChangeEvent event){
		for (Equipment equipment : listEquipments) {
			if (equipment.getKitName().equalsIgnoreCase(event.getNewValue().toString())){
				this.calculator.setEquipment(equipment);
				//this.calculator.getEquipment().setPanel(equipment.getPanels().get(0)); //Added because selecting equipment kit 
						//was producing null pointer exception for the panel	
			}
		}
		moveToEquipment();
	}
	
	/**
	 * Loads selected location to calculator
	 */
	public void handleCityChange(ValueChangeEvent event){
		Roof r = calculator.getCustomer().getLocation().getRoof();
		Bank [] b = calculator.getCustomer().getLocation().getRoof().getBanks();
		for (Location location : listLocations) {
			if (location.getCity().equalsIgnoreCase(event.getNewValue().toString())){
				this.calculator.getCustomer().setLocation(location);
				this.calculator.getCustomer().getLocation().setRoof(r);
				this.calculator.getCustomer().getLocation().getRoof().setBanks(b);
				
			}
		}
		moveToLocation();
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
	
	public void moveToCustomer(){
		int currentIndex = locationTabIndex;
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
		int currentIndex = locationTabIndex;
		setTabIndex(currentIndex);
		getTabIndex();
		
		//add the banks
	}
	
	/**
	 * Move to the summary tab
	 * @return the summary tab
	 */
	public void moveToSummary(){
		int currentIndex = roofTabIndex;
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
	
	public void handleBankIdChange(ValueChangeEvent event){
		int id = Integer.parseInt(event.getNewValue().toString());
		calculator.getCustomer().getLocation().getRoof().getBanks()[0].setBankId(id);
		calculator.getCustomer().getLocation().getRoof().getBanks()[id].setBankId(id);
	}
	
	public void handleBankNumPanelsChange(ValueChangeEvent event){
		int numPanels = Integer.parseInt(event.getNewValue().toString());
		int id = calculator.getCustomer().getLocation().getRoof().getBanks()[0].getBankId();
		calculator.getCustomer().getLocation().getRoof().getBanks()[id].setNumberOfPanels(numPanels);
	}
	
	public void handleBankAngleChange(ValueChangeEvent event){
		double angle = Double.parseDouble(event.getNewValue().toString());
		int id = calculator.getCustomer().getLocation().getRoof().getBanks()[0].getBankId();
		calculator.getCustomer().getLocation().getRoof().getBanks()[id].setAngle(angle);
	}
	
	public void handleBankChange(ValueChangeEvent event){
		try {
			String orientation = event.getNewValue().toString();
			int id = calculator.getCustomer().getLocation().getRoof().getBanks()[0].getBankId();
			calculator.getCustomer().getLocation().getRoof().getBanks()[id].setSelectedOrientation(orientation);
		} catch (Exception ex) {}
		
	}
	
}
