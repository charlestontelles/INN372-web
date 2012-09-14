package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class EquipmentTest {

	private static final double SIZE = 4.5;
	private static final double COST = 1500.0;
	private Equipment equipment;
	private Inverter inverter;
	private ArrayList<Panel> panels;

	@Before
	public void setUp() throws Exception {
		equipment = new Equipment();
		equipment.setCost(COST);
		equipment.setSize(SIZE);
		inverter = new Inverter();
		equipment.setInverter(inverter);
		panels = new ArrayList<Panel>();
		equipment.setPanels(panels);
	}
	
	@Test
	public void testSetGetCost() {

		assertEquals(equipment.getCost(), COST, 0.0);
		Double newCost = 1900.0;
		equipment.setCost(newCost);
		assertEquals(equipment.getCost(), newCost, 80000.0);
	}
	
	@Test
	public void testSetGetSize() {
		assertEquals(equipment.getSize(), SIZE, 0.0);
		Double newSize = 3.9;
		equipment.setSize(newSize);
		assertEquals(equipment.getSize(), newSize, 0.0);
	}
	
	@Test
	public void testSetGetPanels() {
		assertEquals(equipment.getPanels(), panels);
		ArrayList<Panel> newPanels = new ArrayList<Panel>();
		equipment.setPanels(newPanels);
		assertEquals(equipment.getPanels(), newPanels);
	}
	
	@Test
	public void testSetGetInverter() {
		assertEquals(equipment.getInverter(), inverter);
		Inverter newInverter = new Inverter();
		equipment.setInverter(newInverter);
		assertEquals(equipment.getInverter(), newInverter);
	}
	
	@Test 
	public void testGetSetTotalPanels(){
		int newSelectedNoOfPanel = 0;
		assertEquals(equipment.getTotalPanels(), newSelectedNoOfPanel);
		
	}
	
}
