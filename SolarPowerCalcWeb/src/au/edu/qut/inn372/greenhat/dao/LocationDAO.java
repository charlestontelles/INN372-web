package au.edu.qut.inn372.greenhat.dao;

import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Location;

/**
 * Location Data Access Object
 * 
 * @author Martin Daniel
 *
 */
public interface LocationDAO {
	
	/**
	 * Get the average hours of sunlight for a city
	 * @return average hours of sunlight
	 */
	public double getAverageSunlightHours(String city);
	
	/**
	 * Return a list of locations
	 * @return location lost
	 */
	public List<Location> getLocations();
	
}
