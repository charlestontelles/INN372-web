package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private static final double SIZE = 4.5;
	private static final double COST = 1500.0;
	private static final double ANGLE = 20.0;
	
	private Bank bank;
	private Equipment equipment;
	private int bankId;
	private double angle;
	private List<SelectItem> listOfOrientation; 
	private String selectedOrientation;
	private int panelNo;
	
	@Before
	public void setUp() throws Exception {
		equipment = new Equipment();
		equipment.setCost(COST);
		equipment.setSize(SIZE);
		bank = new Bank();
		bank.setAngle(20);
	}
	
	@Test
	public void testSetGetCost() {
		assertEquals(equipment.getCost(), COST, 0.0);
		Double newCost = 1900.0;
		equipment.setCost(newCost);
		assertEquals(equipment.getCost(), newCost, 0.0);
	}
	
	@Test
	public void testSetGetSize() {
		assertEquals(equipment.getSize(), SIZE, 0.0);
		Double newSize = 3.9;
		equipment.setSize(newSize);
		assertEquals(equipment.getSize(), newSize, 0.0);
	}
	
	@Test
	public void testGetAngle(){
		assertEquals(bank.getAngle(), ANGLE, 0.0);
	}
	
	@Test 
	public void testSetAngle(){
		Double newAngle = 40.0;
		bank.setAngle(newAngle);
		assertEquals(bank.getAngle(), newAngle, 0.0);
	}
	
	@Test
	public void testGetSelectedOrientation(){
		String newSelectedOrientation = "West";
		bank.setSelectedOrientation(newSelectedOrientation);
		assertEquals(bank.getSelectedOrientation(), newSelectedOrientation);
	}
	
	@Test
	public void testSetSelectedOrientation(){
		bank.setSelectedOrientation("North");
		String newSelectedOrientation = bank.getSelectedOrientation();
		int firstElement = 0;
		assertEquals(bank.getSelectedOrientation(), newSelectedOrientation);
	}
	
	@Test
	public void testASelectionOfOrientation(){
		bank.setSelectedOrientation("North");
		String newSelectedOrientation = bank.getSelectedOrientation();
		int firstElement = 0;
		assertEquals(bank.getListOfOrientation().get(firstElement).getLabel(), newSelectedOrientation);
	}
	
	@Test
	public void testGetSetBankId(){
		int newBankId = 2;
		bank.setBankId(newBankId);
		assertEquals(bank.getBankId(), newBankId);
	}
}
