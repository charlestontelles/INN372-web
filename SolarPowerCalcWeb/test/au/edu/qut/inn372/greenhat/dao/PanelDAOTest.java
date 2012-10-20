package au.edu.qut.inn372.greenhat.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Panel;
import au.edu.qut.inn372.greenhat.dao.gae.PanelDAOImpl;

public class PanelDAOTest {
	PanelDAO dao;
	@Before
	public void setUp() throws Exception {
		dao = new PanelDAOImpl();
	}
	
	@Test
	public void testGetInverter() {
		List<Panel> panel = dao.getPanels();
		Panel[] list = new Panel[panel.size()];
		panel.toArray(list);
		assertEquals(panel.size(), 10);
		
	}
}
