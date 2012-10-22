/**
 * 
 */
package au.edu.qut.inn372.greenhat.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import au.edu.qut.inn372.greenhat.bean.*;

/**
 * @author joachimjis
 *
 */
public class CalculatorDataModelTest {
	
	private CalculatorDataModel calculate;
	private Calculator calculator;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		calculate = new CalculatorDataModel();
		calculator = new Calculator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRowKey() {
		String key = "calculate";
		calculator.setKey(key);
		assertEquals(calculate.getRowKey(calculator), calculator.getKey());
	}

}
