package au.edu.qut.inn372.greenhat.dao;

import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Equipment;

/**
 * Equipment Data Access Object
 * 
 * @author Charleston
 *
 */
public interface EquipmentDAO {
	/**
	 * Returns a list of Equipments
	 * 
	 * @return Equipment List
	 */
	public List<Equipment> getEquipments();
	
}
