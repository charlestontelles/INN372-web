/**
 * 
 */
package au.edu.qut.inn372.greenhat.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;

/**
 * @author Martin Daniel
 * @version 1.0
 */
public class CalculatorControllerTest {

	private CalculatorController calculatorController;
	private Calculator calculator;
	
	@Before
	public void setUp() throws Exception {
		calculatorController = new CalculatorController();
		calculator = new Calculator();
	}

	@Test
	public void testSetGetCalculator() {
		calculatorController.setCalculator(calculator);
		assertEquals(calculatorController.getCalculator(), calculator);
	}

	@Test
	public void testCalculateSolarPower() {

	}

	@Test
	public void testSaveCalculation() {
		
	}

	@Test
	public void testGetPanels() {
	    List<SelectItem> list = new ArrayList<SelectItem>();
	    list.add(new SelectItem(1, "1"));
	    list.add(new SelectItem(2, "2"));
	    list.add(new SelectItem(3, "3"));
	    list.add(new SelectItem(4, "4"));
	    list.add(new SelectItem(5, "5"));
	    assertEquals(calculatorController.getPanels().size(), list.size());
	}

}
