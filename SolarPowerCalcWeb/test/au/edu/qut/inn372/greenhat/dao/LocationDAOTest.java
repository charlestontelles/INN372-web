/**
 * 
 */
package au.edu.qut.inn372.greenhat.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.Location;
import au.edu.qut.inn372.greenhat.dao.gae.LocationDAOImpl;

/**
 * @author Martin Daniel
 *
 */
public class LocationDAOTest {
	private LocationDAO locationDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		locationDAO = new LocationDAOImpl();
	}


	@Test
	public void testGetLocations() {
		List<Location> locations = locationDAO.getLocations();
		Location[] list = new Location[locations.size()];
		locations.toArray(list);
		assertEquals(7, locations.size());
	}

}
