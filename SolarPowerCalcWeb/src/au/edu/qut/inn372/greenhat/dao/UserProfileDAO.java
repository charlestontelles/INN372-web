package au.edu.qut.inn372.greenhat.dao;

import java.util.List;

import au.edu.qut.inn372.greenhat.bean.UserProfile;
/**
 * Data Access Object to provide operations related to the UserProfile
 * 
 * @author Charleston Telles
 * @version 1.0
 */
public interface UserProfileDAO {
	/**
	 * Save a userProfile
	 * If key is null create a new one,
	 * otherwise update a existent one
	 * @param userProfile
	 */
	public String save(UserProfile userProfile);
	/**
	 * Remove a userProfile
	 * @param userProfile
	 */
	public String remove(UserProfile userProfile);
	
	/**
	 * Get all user profiles in the data store
	 * 
	 */
	public List<UserProfile> getAll();
	
	/**
	 * Get user profile by email
	 * @param email
	 */
	public UserProfile getByEmail(String email);
	
	/**
	 * Validates login credentials
	 * @param email, password
	 * @return Full UserProfile if credential is valid
	 * 			Empty UserProfile is credential is invalid
	 */
	public UserProfile validateCredential(String email, String password);
}
