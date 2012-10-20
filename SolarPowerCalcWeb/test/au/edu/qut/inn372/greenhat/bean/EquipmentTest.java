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
	private ArrayList<Inverter> inverters;
	private ArrayList<Panel> panels;
	private Battery battery;

	@Before
	public void setUp() throws Exception {
		equipment = new Equipment();
		equipment.setCost(COST);
		equipment.setSize(SIZE);
		inverter = new Inverter();
		equipment.setInverter(inverter);
		panels = new ArrayList<Panel>();
		equipment.setPanels(panels);
		battery = new Battery();
		equipment.setBattery(battery);
		inverters = new ArrayList<Inverter>();
	}
	
	@Test
	public void testSetGetInverter() {
		assertEquals(equipment.getInverter(), inverter);
		Inverter newInverter = new Inverter();
		equipment.setInverter(newInverter);
		assertEquals(equipment.getInverter(), newInverter);
	}
	
	@Test
	public void testSetGetInverters(){
		assertEquals(equipment.getInverters(), inverters);
		ArrayList<Inverter> newInverters = new ArrayList<Inverter>();
		equipment.setInverters(newInverters);
		assertEquals(equipment.getPanels(), newInverters);
	}
	
	@Test
	public void testSetGetAddRemoveInverter(){
		inverters.add(new Inverter());
		inverters.add(new Inverter());
		assertEquals(2, inverters.size());
		inverters.remove(0);
		assertEquals(1, inverters.size());
	}
	
	@Test
	public void testSetGetBattery(){
		assertEquals(battery, equipment.getBattery());
		Battery bat = new Battery();
		equipment.setBattery(bat);
		assertEquals(bat, equipment.getBattery());
	}
	
	@Test
	public void testSetGetPanels() {
		assertEquals(equipment.getPanels(), panels);
		ArrayList<Panel> newPanels = new ArrayList<Panel>();
		equipment.setPanels(newPanels);
		assertEquals(equipment.getPanels(), newPanels);
	}
	
	@Test
	public void testSetGetAddRemovePanel(){
		panels.add(new Panel());
		panels.add(new Panel());
		assertEquals(2, panels.size());
		panels.remove(0);
		assertEquals(1, panels.size());
	}
	
	@Test
	public void testSetGetKitName(){
		equipment.setKitName("4KWh - 8 500W");
		assertEquals("4KWh - 8 500W", equipment.getKitName());
	}
	
	@Test 
	public void testSetGetTotalPanels(){
		int newSelectedNoOfPanel = 0;
		assertEquals(equipment.getTotalPanels(), newSelectedNoOfPanel);
	}
	
	@Test
	public void testSetGetCost() {
		assertEquals(equipment.getCost(), COST, 0.0);
		Double newCost = 1900.0;
		equipment.setCost(newCost);
		assertEquals(equipment.getCost(), newCost, 80000.0);
	}
	
	@Test
	public void testHighCost() {
		Double newCost = 9999.9999;
		equipment.setCost(newCost);
		assertEquals(equipment.getCost(), newCost, 80000.0);
	}
	
	@Test
	public void testCostOf0() {
		Double newCost = 0.0;
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
	public void testSizeOf0() {
		assertEquals(equipment.getSize(), SIZE, 0.0);
		Double newSize = 0.0;
		equipment.setSize(newSize);
		assertEquals(equipment.getSize(), newSize, 0.0);
	}
	
	@Test
	public void testHighSize() {
		Double newSize = 999.999;
		equipment.setSize(newSize);
		assertEquals(equipment.getSize(), newSize, 0.0);
	}
	
}
