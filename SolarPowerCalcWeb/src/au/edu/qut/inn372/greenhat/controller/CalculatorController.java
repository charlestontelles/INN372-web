package au.edu.qut.inn372.greenhat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.dao.CalculatorDAO;
import au.edu.qut.inn372.greenhat.dao.gae.CalculatorDAOImpl;

/**
 * Bean that represents a Calcualtor Controller
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class CalculatorController implements Serializable {

	private static final long serialVersionUID = 8091277788980459284L;
	
	@ManagedProperty (value = "#{calculator}")
	private Calculator calculator;
	
	private CalculatorDAO calculatorDAO = new CalculatorDAOImpl();
	
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
	 * Get the daily solar power generated and return the page to navigate to
	 * @return
	 */
	public String calculateSolarPower(){
		calculator.calculateSolarPower();
		calculator.calculateTariff();
		calculator.calculateReplacementGenaration();
		calculator.calculateExportedGeneration();
		calculator.calculateDailySavings();
		return "output";
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
}
