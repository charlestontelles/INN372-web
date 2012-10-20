package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

	private static final double SUNLIGHT_HOURS = 8.0;
	private Location location;
	private String city;
	private Roof roof;

	@Before
	public void setUp() throws Exception {
		location = new Location();
		roof = new Roof();
		location.setSunLightHours(SUNLIGHT_HOURS);
		location.setRegion("Queensland");
		location.setCity("Brisbane");
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
		assertEquals("Brisbane", location.getCity());
		location.setCity("Sydney");
		assertEquals("Sydney", location.getCity());
	}
	
	@Test
	public void testSetGetRegion(){
		assertEquals("Queensland", location.getRegion());
		location.setRegion("Victoria");
		assertEquals("Victoria", location.getRegion());
	}
}
