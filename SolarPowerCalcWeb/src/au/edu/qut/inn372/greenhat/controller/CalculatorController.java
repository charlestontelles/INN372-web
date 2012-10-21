package au.edu.qut.inn372.greenhat.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import au.edu.qut.inn372.greenhat.bean.Bank;
import au.edu.qut.inn372.greenhat.bean.Calculation;
import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Customer;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.Inverter;
import au.edu.qut.inn372.greenhat.bean.Location;
import au.edu.qut.inn372.greenhat.bean.Panel;
import au.edu.qut.inn372.greenhat.bean.UserProfile;
import au.edu.qut.inn372.greenhat.dao.CalculatorDAO;
import au.edu.qut.inn372.greenhat.dao.EquipmentDAO;
import au.edu.qut.inn372.greenhat.dao.InverterDAO;
import au.edu.qut.inn372.greenhat.dao.LocationDAO;
import au.edu.qut.inn372.greenhat.dao.PanelDAO;
import au.edu.qut.inn372.greenhat.dao.UserProfileDAO;
import au.edu.qut.inn372.greenhat.dao.gae.CalculatorDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.EquipmentDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.InverterDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.LocationDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.PanelDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.UserProfileDAOImpl;

/**
 * Bean that represents a Calculator Controller
 * 
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@ViewScoped
public class CalculatorController implements Serializable {

	private static final long serialVersionUID = 8091277788980459284L;
	private static final int customerUsageIndex = 1;
	private static final int equipmentTabIndex = 2;
	private static final int roofTabIndex = 3;
	private static final int locationTabIndex = 0;
	private static final int summaryTabIndex = 4;

	@ManagedProperty(value = "#{calculator}")
	private Calculator calculator;

	private CalculatorDAO calculatorDAO = new CalculatorDAOImpl();
	private UserProfileDAO userProfileDAO = new UserProfileDAOImpl();

	// private List<Equipment> equipments = new ArrayList<Equipment>();
	// private EquipmentDataModel equipmentDataModel;
	private Map<String, String> equipments = new HashMap<String, String>();
	List<Equipment> listEquipments;
	private Equipment selectedEquipment;

	private Map<String, String> locations = new HashMap<String, String>();
	List<Location> listLocations;

	private List<Panel> panelList = new ArrayList<Panel>();
	private Panel selectedPanel;
	
	//private List<Inverter> inverterList = new ArrayList<Inverter>();
	//private Inverter selectedInverter;
	
	private Map<String, String> inverters = new HashMap<String, String>();
	List<Inverter> listInverters;

	private int tabIndex = 0;
	private String responseMessage = "";

	private CalculatorDataModel savedCalculators;
	private Calculator[] selectedCalculators;
	private List<Calculation> calculationsToCompare = new ArrayList<Calculation>();
	private Calculator [] calculatorsToCompare = null;
	@ManagedProperty (value="#{comparisonChart}")
	private ComparisonChart comparisonChart;
	
	// parameters after refactoring
	private String selectedKit;
	private MapModel draggableModel;	
	private Marker marker;
	private String currentLatLong = "";

	public CalculatorController() {
		EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
		listEquipments = equipmentDAO.getEquipments();
		for (Equipment equipment : listEquipments) {
			this.equipments.put(equipment.getKitName(), equipment.getKitName());
		}

		LocationDAO locationDAO = new LocationDAOImpl();
		listLocations = locationDAO.getLocations();
		for (Location location : listLocations) {
			this.locations.put(location.getCity(), location.getCity());
		}

		PanelDAO panelDAO = new PanelDAOImpl();
		panelList = panelDAO.getPanels();
		
		//InverterDAO inverterDAO = new InverterDAOImpl();
		//inverterList = inverterDAO.getInverters();
		InverterDAO inverterDAO = new InverterDAOImpl();
		listInverters = inverterDAO.getInverters();
		for (Inverter inverter : listInverters) {
			this.inverters.put(inverter.getBrand(), inverter.getBrand());
		}
		
		// Map features
		draggableModel = new DefaultMapModel();
		
		//Shared coordinates
		LatLng coord1 = new LatLng(-27.4667, 153.0333); // default location brisbane
		
		//Draggable
		draggableModel.addOverlay(new Marker(coord1, "My House"));
		
		for(Marker marker : draggableModel.getMarkers()) {
			marker.setDraggable(true);
		}
	}
	
	

	public String getSelectedKit() {
		return selectedKit;
	}



	public void setSelectedKit(String selectedKit) {
		this.selectedKit = selectedKit;
	}



	/**
	 * Gets a list of saved calculators
	 * 
	 * @return
	 */
	public CalculatorDataModel getSavedCalculators() {
		this.savedCalculators = new CalculatorDataModel(
				calculatorDAO.getAllByUserProfile(calculator.getCustomer()
						.getUserProfile()));
		return savedCalculators;
	}

	/**
	 * Sets a list of saved calculators
	 * 
	 * @param savedCalculators
	 */
	public void setSavedCalculators(CalculatorDataModel savedCalculators) {
		this.savedCalculators = savedCalculators;
	}

	/**
	 * Gets a list of selected calculators from UI
	 * 
	 * @return
	 */
	public Calculator[] getSelectedCalculators() {
		return selectedCalculators;
	}

	/**
	 * Sets a list of selected calculators to UI
	 * 
	 * @param selectedCalculators
	 */
	public void setSelectedCalculators(Calculator[] selectedCalculators) {
		this.selectedCalculators = selectedCalculators;
	}

	/**
	 * Gets the Response Message
	 * 
	 * @return response message
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * Sets the response message
	 * 
	 * @param responseMessage
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * Get the calculator
	 * 
	 * @return calculator value of the calculator property
	 */
	public Calculator getCalculator() {
		return calculator;
	}

	/**
	 * Set the calculator
	 * 
	 * @param calculator
	 *            value for the calculator property
	 */
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
		//setDefaultEquipmentSelection(); // CRAZY LINE
	}

	/**
	 * First equipment kit selected by default
	 */
	public void setDefaultEquipmentSelection(){
		selectedEquipment = listEquipments.get(0);
		this.calculator.setEquipment(selectedEquipment);
	}

	/**
	 * Gets Tab Index
	 * 
	 * @return tab index
	 */
	public int getTabIndex() {
		return tabIndex;
	}

	/**
	 * Sets tabIndex
	 * 
	 * @param tabIndex
	 */
	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	/**
	 * Perform calculations and return the page to navigate to
	 * 
	 * @return
	 */
	public void calculate(ActionEvent event) {
		calculator.performCalculations();
		//calculator.createChart();
		calculator.setStatus(1);
		//return "output.xhtml";

		this.tabIndex = 7;
	}

	public Map<String, String> getEquipments() {
		return equipments;
	}

	/**
	 * @param equipments
	 *            the equipments to set
	 */
	public void setEquipments(Map<String, String> equipments) {
		this.equipments = equipments;
	}

	/**
	 * Get the locations
	 * 
	 * @return the locations
	 */
	public Map<String, String> getLocations() {
		return locations;
	}

	/**
	 * Set the locations
	 * 
	 * @param locations
	 *            the locations to set
	 */
	public void setLocations(Map<String, String> locations) {
		this.locations = locations;
	}

	/**
	 * Save the calculation
	 * 
	 * @throws Exception
	 */
	public void saveCalculation() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(calculator.getStatus() == 2){
				calculator.setName(null);
				calculator.setKey(null);
			}
			if (calculator.getCalculations() == null || calculator.getCalculations().length <= 0
					|| calculator.getCalculations()[0] == null)
				calculator.setStatus(0);
			else
				calculator.setStatus(1);
			calculatorDAO.save(calculator);
			context.addMessage(null, new FacesMessage("Calculation Saved."));
			
			this.tabIndex = 1;
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Error: " + e));
			throw new Exception(e);
		}
	}
	
	public void saveTemplate() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			calculator.setStatus(2);
			calculatorDAO.save(calculator);
			context.addMessage(null, new FacesMessage("Template Saved."));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Error: " + e));
			throw new Exception(e);
		}
	}

	/**
	 * Get the list of panels
	 * 
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
	 * 
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
	 * Get the list of panels
	 * 
	 * @return list of panels
	 */
	public List<SelectItem> getUserTypeList() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem(0, "<< Select Type >>"));
		list.add(new SelectItem(1, "Customer"));
		list.add(new SelectItem(2, "Seller"));
		list.add(new SelectItem(3, "Admin"));
		return list;
	}

	/**
	 * Returns a list of panel brands
	 * 
	 * @return list of panel brands
	 */
	public List<SelectItem> getListOfPanelBrands() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("BP Solar Panels", "BP Solar Panels"));
		list.add(new SelectItem("Sharp Solar Panels", "Sharp Solar Panels"));
		list.add(new SelectItem("Sunlinq Portable Solar Panels",
				"Sunlinq Portable Solar Panels"));
		list.add(new SelectItem("SunPower Solar Panels",
				"SunPower Solar Panels"));
		list.add(new SelectItem("SunTech Solar Panels", "SunTech Solar Panels"));
		list.add(new SelectItem("Powerfilm Flexible Solar Panels",
				"Powerfilm Flexible Solar Panels"));
		list.add(new SelectItem("Sanyo Solar Panels", "Sanyo Solar Panels"));
		list.add(new SelectItem("Global Solar Panels", "Global Solar Panels"));
		list.add(new SelectItem("Solarfun", "Solarfun"));
		list.add(new SelectItem("REC Solar Panels", "REC Solar Panels"));
		return list;
	}
	
	/**
	 * Returns a list of inverter brands
	 * @return list of inverter brands
	 */
	public List<SelectItem> getListOfInverterBrands() {
		List<SelectItem> list = new ArrayList<SelectItem>();
	    list.add(new SelectItem("BP Solar Inverters", "BP Solar Inverters"));
	    list.add(new SelectItem("Sharp Solar Inverters", "Sharp Solar Inverters"));
	    list.add(new SelectItem("Sunlinq Portable Solar Inverters", "Sunlinq Portable Solar Inverters"));
	    list.add(new SelectItem("SunPower Solar Inverters", "SunPower Solar Inverters"));
	    list.add(new SelectItem("SunTech Solar Inverters", "SunTech Solar Inverters"));
	    list.add(new SelectItem("Powerfilm Flexible Solar Inverters", "Powerfilm Flexible Solar Inverters"));
	    list.add(new SelectItem("Sanyo Solar Inverters", "Sanyo Solar Inverters"));
	    list.add(new SelectItem("Global Solar Inverters", "Global Solar Inverters"));
	    list.add(new SelectItem("Solarfun Inverters", "Solarfun Inverters"));
	    list.add(new SelectItem("REC Solar Inverters", "REC Solar Inverters"));
	    return list;
	}

	/**
	 * Loads selected location to calculator
	 */
	public void handleLocationChange(ValueChangeEvent event) {
		try {
			for (Location location : listLocations) {
				if (location.getCity().equalsIgnoreCase(
						event.getNewValue().toString())) {
					this.calculator.getCustomer().setLocation(location);
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Loads selected panel to calculator
	 */
	public void handlePanelChange(ValueChangeEvent event) {
		try {
			for (Panel panel : panelList) {
				if (panel.getBrand().equalsIgnoreCase(
						event.getNewValue().toString())) {
					for (int index = 0; index < this.calculator.getEquipment()
							.getPanels().size(); index++) {
						this.calculator.getEquipment().getPanels()
								.set(index, panel);
					}
					this.calculator.getEquipment().setCost(
							this.calculator.getEquipment().getTotalPanels()
									* panel.getCost()
									+ this.calculator.getEquipment()
											.getInverter().getCost());
				}
			}
		} catch (Exception e) {
		}
	}
	
	public void handleInverterChange(ValueChangeEvent event){
		try {
			for (Inverter inverter : listInverters) {
				if (inverter.getBrand().equalsIgnoreCase(
						event.getNewValue().toString())) {
					this.calculator.getEquipment().setInverter(inverter);
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Move to the equipment tab
	 * 
	 * @return the equipment tab
	 */
	public void moveToEquipment() {
		int currentIndex = customerUsageIndex;
		setTabIndex(currentIndex + 1);
		getTabIndex();

	}

	public void moveToCustomer() {
		int currentIndex = locationTabIndex;
		setTabIndex(currentIndex + 1);
		getTabIndex();

	}

	/**
	 * Move to the roof tab
	 * 
	 * @return the roof tab
	 */
	public void moveToRoof() {
		int currentIndex = equipmentTabIndex;
		setTabIndex(currentIndex + 1);
		getTabIndex();
	}

	/**
	 * Move to the location tab
	 * 
	 * @return the location tab
	 */
	public void moveToLocation() {
		int currentIndex = locationTabIndex;
		setTabIndex(currentIndex);
		getTabIndex();
	}

	/**
	 * Move to the summary tab
	 * 
	 * @return the summary tab
	 */
	public void moveToSummary() {
		int currentIndex = roofTabIndex;
		setTabIndex(currentIndex + 1);
		getTabIndex();
	}

	/**
	 * Move to the output tab
	 * 
	 * @return the output tab
	 */
	public void moveToOutput() {
		int currentIndex = summaryTabIndex;
		setTabIndex(currentIndex + 1);
		getTabIndex();
	}

	/**
	 * @return the selectedEquipment
	 */
	public Equipment getSelectedEquipment() {
		return selectedEquipment;
	}

	/**
	 * @param selectedEquipment
	 *            the selectedEquipment to set
	 */
	public void setSelectedEquipment(Equipment selectedEquipment) {
		this.selectedEquipment = selectedEquipment;
	}

	public void onRowSelect(SelectEvent event) {
		for (Equipment equipment : listEquipments) {
			if (equipment.getKitName().equalsIgnoreCase(
					((Equipment) event.getObject()).getKitName())) {
				this.calculator.setEquipment(equipment);
			}
		}
		moveToEquipment();
	}

	/**
	 * Save UserProfile
	 */
	public void saveUserProfile() {
		userProfileDAO.save(calculator.getCustomer().getUserProfile());
		responseMessage = "User profile created!";
	}

	/**
	 * Show user profile creation screen
	 * 
	 * @return
	 */
	public String showUserProfileScreen() {
		calculator.getCustomer().setUserProfile(new UserProfile());
		responseMessage = "";
		return "userprofile.xhtml";
	}

	public String showLoginScreen() {
		responseMessage = "";
		return "tabinput.xhtml";
	}

	/**
	 * Open input screen to a new calculation
	 * 
	 * @return
	 */
	public void newCalculation() {
		Customer persistedCustomer = this.calculator.getCustomer();
				//Calculation calc [] = this.calculator.getCalculations();
				//this.calculator = new Calculator();
				//this.calculator.setCalculations(calc);
		this.calculator = new Calculator();
		this.selectedKit="";
		this.calculator.setChart(new Chart());
		this.calculator.setCustomer(persistedCustomer);
				
		this.tabIndex = 2;

		//return "tabinput.xhtml";
	}

	/**
	 * delete selected calculations
	 */
	public void deleteCalculation() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			for (Calculator calc : selectedCalculators)
				calculatorDAO.remove(calc);
			context.addMessage(null, new FacesMessage("Successful",
					"Calculation(s) deleted."));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Error: " + e));
		}
		this.tabIndex = 1;
		//return "home.xhtml";
	}

	/**
	 * Open a selected Calculation
	 * 
	 * @return
	 */
	public void openCalculation() {
		for (Calculator calc : selectedCalculators)
			this.calculator = calculatorDAO.getByName(calc.getName());
		this.selectedKit = this.calculator.getEquipment().getKitName();
		this.tabIndex = 2;
		//moveToLocation();
		//return "tabinput.xhtml?faces-redirect=true";
	}

	/**
	 * Compares two or more calculations
	 */
	public void compareCalculation() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(selectedCalculators.length > 1){
			try {
				calculatorsToCompare = new Calculator[selectedCalculators.length]; 
				for (int i=0; i<selectedCalculators.length; i++)
					calculatorsToCompare[i] = calculatorDAO.getByName(selectedCalculators[i].getName());
				
				for(int i=0; i<calculatorsToCompare.length; i++){
					for(int j=0; j<calculatorsToCompare[i].getCalculations().length; j++){
						calculationsToCompare.add(calculatorsToCompare[i].getCalculations()[j]);
					}
					
				}
				createComparisonChart();
				this.tabIndex = 9;
			} catch (Exception e) {
				context.addMessage(null, new FacesMessage("Error occured."));
			}
		} else {
			context.addMessage(null, new FacesMessage("Please, select 2 calculations."));
			this.tabIndex = 1;
		}
	}

	/**
	 * Back to Home Page
	 */
	public String backToHome() {
		return "home.xhtml?faces-redirect=true";
	}

	/**
	 * Validate login credentials
	 * 
	 * @return
	 */
	public void validateCredentials() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			UserProfile response = userProfileDAO.validateCredential(calculator
					.getCustomer().getUserProfile().getEmail(), calculator
					.getCustomer().getUserProfile().getPassword());
			
			if (response.getKey() == null) {
				context.addMessage(null, new FacesMessage("Invalid Email or Password."));
				//
			} else {
				if (response.getPassword()
						.equalsIgnoreCase(
								calculator.getCustomer().getUserProfile()
										.getPassword())) {
					calculator.getCustomer().setUserProfile(response);
					responseMessage = "";
					this.tabIndex = 1;
				} else {
					context.addMessage(null, new FacesMessage("Invalid Email or Password."));
					//return "login.xhtml";
				}
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Invalid Email or Password."));
			//return "login.xhtml";
		}
	}

	/**
	 * @return the panelList
	 */
	public List<Panel> getPanelList() {
		return panelList;
	}

	/**
	 * @param panelList
	 *            the panelList to set
	 */
	public void setPanelList(List<Panel> panelList) {
		this.panelList = panelList;
	}

	/**
	 * @return the selectedPanel
	 */
	public Panel getSelectedPanel() {
		return selectedPanel;
	}

	/**
	 * @param selectedPanel
	 *            the selectedPanel to set
	 */
	public void setSelectedPanel(Panel selectedPanel) {
		this.selectedPanel = selectedPanel;
	}

	/**
	 * Loads selected equipment to calculator
	 */
	public void handleEquipmentChange(ValueChangeEvent event) {
		try {
			for (Equipment equipment : listEquipments) {
				if (equipment.getKitName().equalsIgnoreCase(
						event.getNewValue().toString())) {
					this.calculator.setEquipment(equipment);
					// Set default for number of panels for bank 1
				}
			}
			this.calculator.getCustomer().getLocation().getRoof().getBanks()[0]
					.setNumberOfPanels(this.calculator.getEquipment().getTotalPanels());
		} catch (Exception e) {
		}
	}
	
	public void handleBankOrientationChange(ValueChangeEvent event) {
		try {
			Bank[] banks = calculator.getCustomer().getLocation().getRoof().getBanks();
			javax.faces.component.html.HtmlSelectOneMenu sel = (javax.faces.component.html.HtmlSelectOneMenu)event.getSource();
			int index = 0;
			if(sel.getValue() != null && !sel.getValue().equals("")){
				if(sel.getId().equalsIgnoreCase("bank1Orientation")){
					index = 0;
				} else if (sel.getId().equalsIgnoreCase("bank2Orientation")){
					index = 1;
				}
				calculator.calculateBankOrientationEfficiencyLoss(banks, sel.getValue().toString() , index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void calculateAngleEfficiency(ValueChangeEvent event){
		try {
			Bank[] banks = calculator.getCustomer().getLocation().getRoof().getBanks();
			javax.faces.component.html.HtmlInputText sel = (javax.faces.component.html.HtmlInputText)event.getSource();
			int index = 0;
			if(sel.getValue() != null && !sel.getValue().equals("")){
				if(sel.getId().equalsIgnoreCase("bank1Angle")){
					index = 0;
				} else if (sel.getId().equalsIgnoreCase("bank2Angle")){
					index = 1;
				}
				calculator.calculateBankAngleEfficiencyLoss(banks, new Double (sel.getValue().toString()) , index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleNumOfPanelsChange(ValueChangeEvent event){
		try {
			Bank[] banks = calculator.getCustomer().getLocation().getRoof().getBanks();
			javax.faces.component.html.HtmlInputText sel = (javax.faces.component.html.HtmlInputText)event.getSource();
			
			if(sel.getValue() != null && !sel.getValue().equals("")){
				if(sel.getId().equalsIgnoreCase("bank1NumberOfPanels")){
					banks[1].setNumberOfPanels(calculator.getEquipment().getTotalPanels() - new Integer(sel.getValue().toString()));
				} else if (sel.getId().equalsIgnoreCase("bank2NumberOfPanels")){
					banks[0].setNumberOfPanels(calculator.getEquipment()
							.getTotalPanels() - new Integer(sel.getValue().toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the inverters
	 */
	public Map<String, String> getInverters() {
		return inverters;
	}

	/**
	 * @param inverters the inverters to set
	 */
	public void setInverters(Map<String, String> inverters) {
		this.inverters = inverters;
	}

	/**
	 * @return the listInverters
	 */
	public List<Inverter> getListInverters() {
		return listInverters;
	}

	/**
	 * @param listInverters the listInverters to set
	 */
	public void setListInverters(List<Inverter> listInverters) {
		this.listInverters = listInverters;
	}
	
	/**
	 * Create a chart and navigate to the chart page to display it.
	 * 
	 * @return
	 */
	public void createChart() {
		calculator.createChart();
		this.tabIndex = 8;
		//return "chart.xhtml";
	}
	
	
	/**
	 * 
	 * @return
	 */
	public MapModel getDraggableModel() {
		return draggableModel;
	}
	/**
	 * 
	 * @param event
	 */
	private double sunLightHours = 0;
	public void onMarkerDrag(MarkerDragEvent event) {
		marker = event.getMarker();
		String newLatLong = marker.getLatlng().getLat()+"#"+ marker.getLatlng().getLng();
		
		if (!currentLatLong.equalsIgnoreCase(newLatLong)){			
			sunLightHours = calculator.getSunLightHours(marker.getLatlng().getLat(), marker.getLatlng().getLng());
		
			calculator.getCustomer().getLocation().setSunLightHours(sunLightHours);	
			
			currentLatLong = newLatLong;			
			addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Sun Light Hours", "Average: " + sunLightHours));	
		}
		
		
	}
	
	/**
	 * Add new message to map
	 * 
	 * @param message
	 */
	public void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	/**
	 * @return the calculatorsToCompare
	 */
	public Calculator[] getCalculatorsToCompare() {
		return calculatorsToCompare;
	}



	/**
	 * @param calculatorsToCompare the calculatorsToCompare to set
	 */
	public void setCalculatorsToCompare(Calculator[] calculatorsToCompare) {
		this.calculatorsToCompare = calculatorsToCompare;
	}
	
	
	public void createComparisonChart(){
		CartesianChartModel CostCategoryModel;
		CartesianChartModel savingsCategoryModel;
		CostCategoryModel = new CartesianChartModel();
		savingsCategoryModel = new CartesianChartModel();
		
		ChartSeries costWithOutSolarCalculation1Series = new ChartSeries();
		costWithOutSolarCalculation1Series.setLabel("Cost Without Solar - " + this.calculatorsToCompare[0].getName());
		ChartSeries costsWithSolarCalculation1Series = new ChartSeries();
		costsWithSolarCalculation1Series.setLabel("Costs With Solar - " + this.calculatorsToCompare[0].getName());
		
		
		ChartSeries costsWithOutSolarCalculation2Series = new ChartSeries();
		costsWithOutSolarCalculation2Series.setLabel("Cost Without Solar - " + this.calculatorsToCompare[1].getName());
		ChartSeries costsWithSolarCalculation2Series = new ChartSeries();
		costsWithSolarCalculation2Series.setLabel("Costs With Solar - " + this.calculatorsToCompare[1].getName());
        
		for(Calculation curCalculation : this.calculatorsToCompare[0].getCalculations()) {			
			double annualCost1 = curCalculation.getTariff11Fee() * this.calculatorsToCompare[0].getCustomer().getElectricityUsage().getDailyAverageUsage()*365;			
			costWithOutSolarCalculation1Series.set(curCalculation.getYear() + "", annualCost1);			
			costsWithSolarCalculation1Series.set(curCalculation.getYear()+"", annualCost1 - curCalculation.getAnnualSaving());		
		}
		
		for(Calculation curCalculation : this.calculatorsToCompare[1].getCalculations()) {			
			double annualCost2 = curCalculation.getTariff11Fee() * this.calculatorsToCompare[1].getCustomer().getElectricityUsage().getDailyAverageUsage()*365;			
			costsWithOutSolarCalculation2Series.set(curCalculation.getYear() + "", annualCost2);			
			costsWithSolarCalculation2Series.set(curCalculation.getYear()+"", annualCost2 - curCalculation.getAnnualSaving());		
		}

        	
        ChartSeries savings1 = new ChartSeries();
        savings1.setLabel("Cumulative Savings - " + this.calculatorsToCompare[0].getName());
        ChartSeries paybackPeriod1 = new ChartSeries();
        paybackPeriod1.setLabel("Initial Investment - " + this.calculatorsToCompare[0].getName());
        
        ChartSeries savings2 = new ChartSeries();
        savings2.setLabel("Cumulative Savings - " + this.calculatorsToCompare[1].getName());
        ChartSeries paybackPeriod2 = new ChartSeries();
        paybackPeriod2.setLabel("Initial Investment - " + this.calculatorsToCompare[1].getName());
        
		double systemCost1 = this.calculatorsToCompare[0].getEquipment().getCost();		
        
		for(Calculation curCalculation : this.calculatorsToCompare[0].getCalculations()) {			
			savings1.set(curCalculation.getYear()+"", curCalculation.getCumulativeSaving());	
			paybackPeriod1.set(curCalculation.getYear()+"", systemCost1);	
		}

		double systemCost2 = this.calculatorsToCompare[1].getEquipment().getCost();		
        
		for(Calculation curCalculation : this.calculatorsToCompare[1].getCalculations()) {			
			savings2.set(curCalculation.getYear()+"", curCalculation.getCumulativeSaving());	
			paybackPeriod2.set(curCalculation.getYear()+"", systemCost2);	
		}
		
		CostCategoryModel.addSeries(costWithOutSolarCalculation1Series);
		CostCategoryModel.addSeries(costsWithSolarCalculation1Series);
		
		CostCategoryModel.addSeries(costsWithOutSolarCalculation2Series);
		CostCategoryModel.addSeries(costsWithSolarCalculation2Series);
        
		savingsCategoryModel.addSeries(savings1);
		savingsCategoryModel.addSeries(paybackPeriod1);
		
		savingsCategoryModel.addSeries(savings2);
		savingsCategoryModel.addSeries(paybackPeriod2);
        
        if(this.comparisonChart == null){
        	this.comparisonChart = new ComparisonChart();
        }
		this.comparisonChart.setCostsCategoryModel(CostCategoryModel);
        this.comparisonChart.setSavingsCategoryModel(savingsCategoryModel);
        //this.setComparisonChart(comparisonChart);
        this.tabIndex = 10;
	}



	/**
	 * @return the comparisonChart
	 */
	public ComparisonChart getComparisonChart() {
		return comparisonChart;
	}



	/**
	 * @param comparisonChart the comparisonChart to set
	 */
	public void setComparisonChart(ComparisonChart comparisonChart) {
		this.comparisonChart = comparisonChart;
	}
}
