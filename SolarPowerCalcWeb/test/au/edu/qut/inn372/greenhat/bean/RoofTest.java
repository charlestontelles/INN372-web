package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RoofTest {

	private static final double WIDTH = 8.0;
	private static final double PERCENTAGE_WEST = 0.25;
	private static final double PERCENTAGE_NORTH = 0.75;
	private static final double HEIGHT = 10.0;
	private static final double EFFICIENCY_LOSS_WEST = 0.8;
	private static final double EFFICIENCY_LOSS_NORTH = 0.9;
	private Bank [] bank;
	private Roof roof;

	@Before
	public void setUp() throws Exception {
		roof = new Roof();
		bank = new Bank[2];
		roof.setEfficiencyLossNorth(EFFICIENCY_LOSS_NORTH);
		roof.setEfficiencyLossWest(EFFICIENCY_LOSS_WEST);
		roof.setWidth(WIDTH);
		roof.setHeight(HEIGHT);
		roof.setPercentageNorth(PERCENTAGE_NORTH);
		roof.setPercentageWest(PERCENTAGE_WEST);
	}
	
	@Test
	public void testSetGetEfficiencyLossNorth() {
		assertEquals(roof.getEfficiencyLossNorth(), EFFICIENCY_LOSS_NORTH, 0.0);
		Double newEfficiencyLossNorth = 0.85;
		roof.setEfficiencyLossNorth(newEfficiencyLossNorth);
		assertEquals(roof.getEfficiencyLossNorth(), newEfficiencyLossNorth, 0.0);
	}
	
	@Test
	public void testSetGetEfficiencyLossWest() {
		assertEquals(roof.getEfficiencyLossWest(), EFFICIENCY_LOSS_WEST, 0.0);
		Double newEfficiencyLossWest = 0.85;
		roof.setEfficiencyLossWest(newEfficiencyLossWest);
		assertEquals(roof.getEfficiencyLossWest(), newEfficiencyLossWest, 0.0);
	}
	
	@Test
	public void testSetGetWidth() {
		assertEquals(roof.getWidth(), WIDTH, 0.0);
		Double newWidth = 9.0;
		roof.setWidth(newWidth);
		assertEquals(roof.getWidth(), newWidth, 0.0);
	}
	
	@Test
	public void testSetGetHeight() {
		assertEquals(roof.getHeight(), HEIGHT, 0.0);
		Double newHeight = 11.0;
		roof.setHeight(newHeight);
		assertEquals(roof.getHeight(), newHeight, 0.0);
	}
	
	@Test
	public void testSetGetPercentageNorth() {
		assertEquals(roof.getPercentageNorth(), PERCENTAGE_NORTH, 0.0);
		Double newPercentageNorth = 0.6;
		roof.setPercentageNorth(newPercentageNorth);
		assertEquals(roof.getPercentageNorth(), newPercentageNorth, 0.0);
	}
	
	@Test
	public void testSetGetPercentageWest() {
		assertEquals(roof.getPercentageWest(), PERCENTAGE_WEST, 0.0);
		Double newPercentageWest = 0.4;
		roof.setPercentageWest(newPercentageWest);
		assertEquals(roof.getPercentageWest(), newPercentageWest, 0.0);
	}
	
	@Test
	public void testSetGetBanks(){
		assertEquals(2, bank.length);
		Bank[] banks = new Bank[2];
		roof.setBanks(banks);
		assertEquals(2, banks.length);
	}
}
