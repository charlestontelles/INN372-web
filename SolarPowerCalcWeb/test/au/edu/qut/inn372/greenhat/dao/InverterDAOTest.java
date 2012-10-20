package au.edu.qut.inn372.greenhat.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Inverter;
import au.edu.qut.inn372.greenhat.dao.gae.InverterDAOImpl;

public class InverterDAOTest {
	InverterDAO dao;
	@Before
	public void setUp() throws Exception {
		dao = new InverterDAOImpl();
	}
	
	@Test
	public void testGetInverter() {
		List<Inverter> inverter = dao.getInverters();
		Inverter[] list = new Inverter[inverter.size()];
		inverter.toArray(list);
		assertEquals(inverter.size(), 10);
		
	}
}
