package au.edu.qut.inn372.greenhat.dao.gae;

import java.util.ArrayList;
import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Battery;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.Inverter;
import au.edu.qut.inn372.greenhat.bean.Panel;
import au.edu.qut.inn372.greenhat.dao.EquipmentDAO;

public class EquipmentDAOImpl implements EquipmentDAO {

	@Override
	public List<Equipment> getEquipments() {
		List<Equipment> equipments = new ArrayList<Equipment>();
		Equipment equipment1 = new Equipment();
		equipment1.setKitName("Kit 2.5Kwh - 10 panels(250w)");
		equipment1.setCost(2500);
		equipment1.setSize(2.5);
		Inverter inverter1 = new Inverter();
		inverter1.setEfficiency(85);
		inverter1.setCost(500);
		Panel panel1 = new Panel();
		panel1.setEfficiency(95);
		panel1.setPowerRating(250);
		Battery battery1 = new Battery();
		battery1.setCost(500);
		equipment1.setInverter(inverter1);
		equipment1.setBattery(battery1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		equipment1.addPanel(panel1);
		
		equipments.add(equipment1);
		
		Equipment equipment2 = new Equipment();
		equipment2.setKitName("Kit 4Kwh - 8 panels(500w)");
		equipment2.setCost(5000);
		equipment2.setSize(4);
		Inverter inverter2 = new Inverter();
		inverter2.setEfficiency(90);
		inverter2.setCost(500);
		Panel panel2 = new Panel();
		panel2.setEfficiency(95);
		panel2.setPowerRating(500);
		Battery battery2 = new Battery();
		battery2.setCost(500);
		equipment2.setInverter(inverter2);
		equipment2.setBattery(battery2);
		equipment2.addPanel(panel2);
		equipment2.addPanel(panel2);
		equipment2.addPanel(panel2);
		equipment2.addPanel(panel2);
		equipment2.addPanel(panel2);
		equipment2.addPanel(panel2);
		equipment2.addPanel(panel2);
		equipment2.addPanel(panel2);
		
		equipments.add(equipment2);
		
		Equipment equipment3 = new Equipment();
		equipment3.setKitName("Kit 3.6Kwh - 12 panels(300w)");
		equipment3.setCost(4000);
		equipment3.setSize(3.6);
		Inverter inverter3 = new Inverter();
		inverter3.setEfficiency(90);
		inverter3.setCost(500);
		Panel panel3 = new Panel();
		panel3.setEfficiency(95);
		panel3.setPowerRating(300);
		Battery battery3 = new Battery();
		battery3.setCost(500);
		equipment3.setInverter(inverter3);
		equipment3.setBattery(battery3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		equipment3.addPanel(panel3);
		
		equipments.add(equipment3);
		
		return equipments;
	}

}
