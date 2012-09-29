package au.edu.qut.inn372.greenhat.dao;

import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.UserProfile;

/**
 * Data Access Object to provide operations related to the Calculator
 * 
 * @author Charleston Telles
 * @version 1.0
 */
public interface CalculatorDAO {
	/**
	 * Save a Calculator hierarchy
	 * If key is null create a new one,
	 * otherwise update a existent one
	 * @param calculator
	 */
	public String save(Calculator calculator);
	/**
	 * Remove a calculator
	 * @param calculator
	 */
	public String remove(Calculator calculator);
	
	/**
	 * Get all calculators by user profile from data store
	 * 
	 */
	public List<Calculator> getAllByUserProfile(UserProfile userProfile);
	/**
	 * Get calculator by name from data store
	 * 
	 */
	public Calculator getByName(String name);
}
