package au.edu.qut.inn372.greenhat.dao;

import au.edu.qut.inn372.greenhat.bean.Calculator;
/**
 * Data Access Object to provide operations related to the Calculator
 * 
 * @author Charleston Telles
 * @version 1.0
 */
public interface CalculatorDAO {
	/**
	 * Save the calculation
	 * @param calculator
	 */
	public void saveCalculation(Calculator calculator);
	
	/**
	 * Delete the calculation
	 * @param calculator
	 */
	public void deleteCalculation (Calculator calculator);
	
	/**
	 * Update the calculation
	 * @param calculator
	 */
	public void updateCalculation (Calculator calculator);
	
	/**
	 * Get the calculation
	 * @param filter
	 * @return calculation
	 */
	public Calculator getCalculation (String[][] filter);
	
	/**
	 * Get the calculations
	 * @param filter
	 * @return calculations
	 */
	public Calculator[] getCalculations (String[][] filter);
}
