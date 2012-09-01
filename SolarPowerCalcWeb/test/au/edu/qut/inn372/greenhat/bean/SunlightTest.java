package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SunlightTest {

	private static final double SUNLIGHT_HOURS = 8.0;
	private Sunlight sunlight;

	@Before
	public void setUp() throws Exception {
		sunlight = new Sunlight();
		sunlight.setSunLightHours(SUNLIGHT_HOURS);
	}
	
	@Test
	public void testSetGetSunlightHours() {
		assertEquals(sunlight.getSunLightHours(), SUNLIGHT_HOURS, 0.0);
		Double newSunlightHours = 9.0;
		sunlight.setSunLightHours(newSunlightHours);
		assertEquals(sunlight.getSunLightHours(), newSunlightHours, 0.0);
	}
	
}
