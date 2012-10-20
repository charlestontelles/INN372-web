package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class InverterTest {

	private static final double REPLACEMENT_COST = 350.0;
	private static final double LIFESPAN = 25.0;
	private static final double EFFICIENCY = 0.95;
	private Inverter inverter;

	@Before
	public void setUp() throws Exception {
		inverter = new Inverter();
		inverter.setId(1);
		inverter.setEfficiency(EFFICIENCY);
		inverter.setLifespan(LIFESPAN);
		inverter.setReplacementCost(REPLACEMENT_COST);
		inverter.setCost(300);
		inverter.setEfficiencyLoss(0.5);
		inverter.setBrand("Solarfun Inverters");
	}
	
	@Test
	public void testSetGetId(){
		inverter.setId(2);
		assertEquals(2,inverter.getId(), 0.0);
	}

	@Test
	public void testSetGetEfficiency() {
		assertEquals(inverter.getEfficiency(), EFFICIENCY, 0.0);
		Double newEfficiency = 0.9;
		inverter.setEfficiency(newEfficiency);
		assertEquals(inverter.getEfficiency(), newEfficiency, 0.0);
	}
	
	@Test
	public void testSetGetLifespan() {
		assertEquals(inverter.getLifespan(), LIFESPAN, 0.0);
		Double newLifespan= 22.0;
		inverter.setEfficiency(newLifespan);
		assertEquals(inverter.getEfficiency(), newLifespan, 0.0);
	}
	
	@Test
	public void testSetGetReplacementCost() {
		assertEquals(inverter.getReplacementCost(), REPLACEMENT_COST, 0.0);
		Double newReplacementCost = 320.0;
		inverter.setEfficiency(newReplacementCost);
		assertEquals(inverter.getEfficiency(), newReplacementCost, 0.0);
	}
	
	@Test
	public void testSetGetCost(){
		assertEquals(300, inverter.getCost(), 0.0);
		inverter.setCost(345);
		assertEquals(345, inverter.getCost(), 0.0);
	}
	
	@Test
	public void testSetGetEfficiencyLoss() {
		assertEquals(0.5, inverter.getEfficiencyLoss(), 0.0);
		inverter.setEfficiencyLoss(0.7);
		assertEquals(0.7, inverter.getEfficiencyLoss(), 0.0);
	}
	
	@Test
	public void testSetGetBrand(){
		assertEquals("Solarfun Inverters", inverter.getBrand());
		inverter.setBrand("brand");
		assertEquals("brand", inverter.getBrand());
	}
}
