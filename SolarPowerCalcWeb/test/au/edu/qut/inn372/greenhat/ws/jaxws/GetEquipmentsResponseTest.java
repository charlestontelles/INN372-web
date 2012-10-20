package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Equipment;

public class GetEquipmentsResponseTest {
	private GetEquipmentsResponse getEquipmentsResponse;
    private Equipment[] equipments;

	@Before
	public void setUp() throws Exception {
		getEquipmentsResponse = new GetEquipmentsResponse();
		equipments = new Equipment[10];
	}

	@Test
	public void testSetGetEquipment() {
		getEquipmentsResponse.setEquipments(equipments);
		assertEquals(getEquipmentsResponse.getEquipments(), equipments);
	}
}
