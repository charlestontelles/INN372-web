package au.edu.qut.inn372.greenhat.dao.gae;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Battery;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.Inverter;
import au.edu.qut.inn372.greenhat.bean.Panel;
import au.edu.qut.inn372.greenhat.dao.EquipmentDAO;

public class EquipmentDAOImpl implements Serializable, EquipmentDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -250530584611730415L;

	@Override
	public List<Equipment> getEquipments() {
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		Equipment equipment1 = new Equipment();
		
		Inverter inverter1 = new Inverter();
		inverter1.setEfficiency(85);
		inverter1.setCost(500);
		inverter1.setBrand("BP Solar Inverters");
		
		Panel panel1 = new Panel();
		panel1.setEfficiency(95);
		panel1.setPowerRating(250);
		panel1.setEfficiencyLoss(0.5);
		panel1.setCost(100);
		panel1.setSize(2.25);
		panel1.setBrand("BP Solar Panels");
		
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
		
		equipment1.setKitName("Kit 2.5KW - 10 panels(250W)");
		//equipment1.setCost(2500);
		equipment1.setCost(equipment1.getTotalPanels() * panel1.getCost() + inverter1.getCost());
		equipment1.setSize(2.5);
		
		equipments.add(equipment1);
		
		
		Equipment equipment2 = new Equipment();
		
		Inverter inverter2 = new Inverter();
		inverter2.setEfficiency(95);
		inverter2.setCost(600);
		inverter2.setBrand("Sharp Solar Inverters");
		
		Panel panel2 = new Panel();
		panel2.setPowerRating(700);
		panel2.setEfficiency(100);
		panel2.setEfficiencyLoss(0.7);
		panel2.setCost(500);
		panel2.setSize(2.25);
		panel2.setBrand("Sharp Solar Panels");
		
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
		
		equipment2.setKitName("Kit 5.6KW - 8 panels(700W)");
		//equipment2.setCost(9000);
		equipment2.setCost(equipment2.getTotalPanels() * panel2.getCost() + inverter2.getCost());
		equipment2.setSize(5.6);
		
		equipments.add(equipment2);
		
		
		Equipment equipment3 = new Equipment();
		
		Inverter inverter3 = new Inverter();
		inverter3.setEfficiency(90);
		inverter3.setCost(400);
		inverter3.setBrand("SunPower Solar Inverters");
		
		Panel panel3 = new Panel();
		panel3.setEfficiency(95);
		panel3.setEfficiencyLoss(0.8);
		panel3.setPowerRating(300);
		panel3.setCost(400);
		panel3.setSize(2.25);
		panel3.setBrand("SunPower Solar Panels");
		
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
		
		equipment3.setKitName("Kit 3.6KW - 12 panels(300W)");
		//equipment3.setCost(4000);
		equipment3.setCost(equipment3.getTotalPanels() * panel3.getCost() + inverter3.getCost());
		equipment3.setSize(3.6);
		
		equipments.add(equipment3);
		
		
		
		
		
		
		Equipment equipment4 = new Equipment();
		
		Inverter inverter4 = new Inverter();
		inverter4.setEfficiency(95);
		inverter4.setCost(450);
		inverter4.setBrand("Sanyo Solar Inverters");
		
		Panel panel4 = new Panel();
		panel4.setEfficiency(95);
		panel4.setEfficiencyLoss(0.8);
		panel4.setPowerRating(500);
		panel4.setCost(450);
		panel4.setSize(2.25);
		panel4.setBrand("Sanyo Solar Panels");
		
		Battery battery4 = new Battery();
		battery4.setCost(500);
		

		equipment4.setInverter(inverter4);
		equipment4.setBattery(battery4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		equipment4.addPanel(panel4);
		
		equipment4.setKitName("Kit 5KW - 10 panels(500W)");
		//equipment4.setCost(5000);
		equipment4.setCost(equipment4.getTotalPanels() * panel4.getCost() + inverter4.getCost());
		equipment4.setSize(5);
		
		equipments.add(equipment4);
		
		return equipments;
	}

}
