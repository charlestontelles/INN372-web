package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

	private static final double SUNLIGHT_HOURS = 8.0;
	private Location location;
	private Roof roof;

	@Before
	public void setUp() throws Exception {
		location = new Location();
		location.setSunLightHours(SUNLIGHT_HOURS);
		roof = new Roof();
		location.setRoof(roof);
	}

	@Test
	public void testSetGetRoof() {
		assertEquals(location.getRoof(), roof);
		Roof newRoof = new Roof();
		location.setRoof(newRoof);
		assertEquals(location.getRoof(), newRoof);
	}
	
	@Test
	public void testSetGetSunLightHours() {
		assertEquals(location.getSunLightHours(), SUNLIGHT_HOURS, 0.0);
		Double newSunlightHours = 7.5;
		location.setSunLightHours(newSunlightHours);
		assertEquals(location.getSunLightHours(), newSunlightHours, 0.0);
	}
	
	@Test
	public void testSetGetCity(){
		location.setCity("Brisbane");
		assertEquals("Brisbane", location.getCity());
	}
	
	@Test
	public void testSetGetRegion(){
		location.setRegion("Queensland");
		assertEquals("Queensland", location.getRegion());
	}
}
