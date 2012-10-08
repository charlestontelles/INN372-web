package au.edu.qut.inn372.greenhat.dao;

import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Inverter;

/**
 * Panel Data Access Object
 * 
 * @author Joachim Jissang
 *
 */
public interface InverterDAO {
	/**
	 * 
	 * @param brand
	 * @return
	 */
	
	public Inverter getInverter(String brand);
	
	/**
	 * Return a list
	 * @return 
	 */
	public List<Inverter> getInverters();
	
}
