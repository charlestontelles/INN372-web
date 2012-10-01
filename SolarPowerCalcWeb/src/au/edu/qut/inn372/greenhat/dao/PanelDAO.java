package au.edu.qut.inn372.greenhat.dao;

import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Panel;

/**
 * Panel Data Access Object
 * 
 * @author Martin Daniel
 *
 */
public interface PanelDAO {
	/**
	 * 
	 * @param brand
	 * @return
	 */
	
	public Panel getPanel(String brand);
	
	/**
	 * Return a list of locations
	 * @return location lost
	 */
	public List<Panel> getPanels();
	
}
