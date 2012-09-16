package au.edu.qut.inn372.greenhat.dao;

import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Location;

/**
 * Equipment Data Access Object
 * 
 * @author Charleston
 *
 */
public interface LocationDAO {
	/**
	 * Returns a list of Equipments
	 * 
	 * @return Equipment List
	 */
	public double getAverageSunlightHours(String city);
	
	public List<Location> getLocations();
	
}
