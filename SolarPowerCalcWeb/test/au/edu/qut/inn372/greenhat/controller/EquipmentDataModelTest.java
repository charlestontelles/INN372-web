package au.edu.qut.inn372.greenhat.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Equipment;

public class EquipmentDataModelTest {

	private EquipmentDataModel equipmentModel;
	private Equipment equipment;
	
	@Before
	public void setUp() throws Exception {
		equipmentModel = new EquipmentDataModel();
		equipment = new Equipment();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRowKey() {
		equipment.setKitName("Kit 5.6KWH");
		assertEquals(equipmentModel.getRowKey(equipment), equipment.getKitName());
	}

}
