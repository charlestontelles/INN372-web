package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PanelTest {
	private Panel panel;
	
	@Before
	public void setUp() throws Exception {
		panel = new Panel();
		panel.setEfficiency(0.3);
		panel.setEfficiencyLoss(0.7);
		panel.setHeight(4.0);
		panel.setId(0);
		panel.setWidth(2.0);
		panel.setPowerRating(250);
		panel.setSize(4);
		panel.setCost(500);
		panel.setBrand("Solarfun Solar Panels");
	}
	
	@Test
	public void testSetGetEfficiency() {
		assertEquals(panel.getEfficiency(), 0.3, 0.0);
		Double newEfficiency = 0.4;
		panel.setEfficiency(newEfficiency);
		assertEquals(panel.getEfficiency(), newEfficiency, 0.0);
	}
	
	@Test
	public void testSetGetEfficiencyLoss() {
		assertEquals(panel.getEfficiencyLoss(), 0.7, 0.0);
		Double newEfficiencyLoss = 0.6;
		panel.setEfficiencyLoss(newEfficiencyLoss);
		assertEquals(panel.getEfficiencyLoss(), newEfficiencyLoss, 0.0);
	}
	
	@Test
	public void testSetGetHeight() {
		assertEquals(panel.getHeight(), 4.0, 0.0);
		Double newHeight = 3.0;
		panel.setHeight(newHeight);
		assertEquals(panel.getHeight(), newHeight, 0.0);
	}
	
	@Test
	public void testSetGetWidth() {
		assertEquals(panel.getWidth(), 2.0, 0.0);
		Double newWidth = 2.5;
		panel.setWidth(newWidth);
		assertEquals(panel.getWidth(), newWidth, 0.0);
	}
	
	@Test
	public void testSetGetId() {
		assertEquals(panel.getId(), 0);
		int newId = 2;
		panel.setId(newId);
		assertEquals(panel.getId(), newId);
	}
	
	@Test
	public void testSetGetPowerRating() {
		assertEquals(250, panel.getPowerRating(), 0.0);
		panel.setPowerRating(700);
		assertEquals(700, panel.getPowerRating(), 0.1);
	}
	
	@Test
	public void testSetGetSize(){
		assertEquals(4, panel.getSize(), 0.0);
		panel.setSize(2);
		assertEquals(2, panel.getSize(), 0.1);
	}
	
	@Test
	public void testSetGetCost(){
		assertEquals(500, panel.getCost(), 0.0);
		panel.setCost(400);
		assertEquals(400, panel.getCost(), 0.1);
	}
	
	@Test
	public void testSetGetBrand(){
		assertEquals("Solarfun Solar Panels", panel.getBrand());
		panel.setBrand("Sanyo Solar Panels");
		assertEquals("Sanyo Solar Panels", panel.getBrand());
	}
}
