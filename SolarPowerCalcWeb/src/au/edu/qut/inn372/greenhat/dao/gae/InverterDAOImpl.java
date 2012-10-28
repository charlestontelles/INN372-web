package au.edu.qut.inn372.greenhat.dao.gae;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Inverter;
import au.edu.qut.inn372.greenhat.dao.InverterDAO;

public class InverterDAOImpl implements Serializable, InverterDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8132528384505235206L;
	
	
	public Inverter getInverter(String brand){
		/*for(Panel p : panelList)
			if(p.getBrand() == brand)
				return p; */
		return null;
	} 
	
	@Override
	public List<Inverter> getInverters() {
		List<Inverter> panelList = new ArrayList<Inverter>();
		Inverter bPSolarInverter = new Inverter();
		bPSolarInverter.setId(1);
		bPSolarInverter.setBrand("BP Solar Inverters");
		bPSolarInverter.setCost(500);
		bPSolarInverter.setEfficiency(85);
		bPSolarInverter.setEfficiencyLoss(0.5);
		
		Inverter sharpSolarInverter = new Inverter();
		sharpSolarInverter.setId(1);
		sharpSolarInverter.setBrand("Sharp Solar Inverters");
		sharpSolarInverter.setCost(600);
		sharpSolarInverter.setEfficiency(95);
		sharpSolarInverter.setEfficiencyLoss(0.7);
		
		Inverter sunlinqSolarInverter = new Inverter();
		sunlinqSolarInverter.setId(1);
		sunlinqSolarInverter.setBrand("Sunlinq Portable Solar Inverters");
		sunlinqSolarInverter.setCost(400);
		sunlinqSolarInverter.setEfficiency(93);
		sunlinqSolarInverter.setEfficiencyLoss(0.7);
		
		Inverter sunPowerSolarInverter = new Inverter();
		sunPowerSolarInverter.setId(1);
		sunPowerSolarInverter.setBrand("SunPower Solar Inverters");
		sunPowerSolarInverter.setCost(400);
		sunPowerSolarInverter.setEfficiency(95);
		sunPowerSolarInverter.setEfficiencyLoss(0.8);
		
		Inverter sunTechSolarInverter = new Inverter();
		sunTechSolarInverter.setId(1);
		sunTechSolarInverter.setBrand("SunTech Solar Inverters");
		sunTechSolarInverter.setCost(400);
		sunTechSolarInverter.setEfficiency(95);
		sunTechSolarInverter.setEfficiencyLoss(0.7);
		
		Inverter powerFirmSolarPanel = new Inverter();
		powerFirmSolarPanel.setId(1);
		powerFirmSolarPanel.setBrand("Powerfilm Flexible Solar Inverters");
		powerFirmSolarPanel.setCost(400);
		powerFirmSolarPanel.setEfficiency(97);
		powerFirmSolarPanel.setEfficiencyLoss(0.7);

		Inverter sanyoSolarPanel = new Inverter();
		sanyoSolarPanel.setId(1);
		sanyoSolarPanel.setBrand("Sanyo Solar Inverters");
		sanyoSolarPanel.setCost(450);
		sanyoSolarPanel.setEfficiency(95);
		sanyoSolarPanel.setEfficiencyLoss(0.8);
		
		Inverter globalSolarPanel = new Inverter();
		globalSolarPanel.setId(1);
		globalSolarPanel.setBrand("Global Solar Inverters");
		globalSolarPanel.setCost(400);
		globalSolarPanel.setEfficiency(99);
		globalSolarPanel.setEfficiencyLoss(0.7);
		
		Inverter solarFunSolarPanel = new Inverter();
		solarFunSolarPanel.setId(1);
		solarFunSolarPanel.setBrand("Solarfun Inverters");
		solarFunSolarPanel.setCost(400);
		solarFunSolarPanel.setEfficiency(95);
		solarFunSolarPanel.setEfficiencyLoss(0.7);
		
		Inverter recSolarPanel = new Inverter();
		recSolarPanel.setId(1);
		recSolarPanel.setBrand("REC Solar Inverters");
		recSolarPanel.setCost(400);
		recSolarPanel.setEfficiency(95);
		recSolarPanel.setEfficiencyLoss(0.7);
		
		Inverter recCustomInverter = new Inverter();
		recCustomInverter.setId(1);
		recCustomInverter.setBrand("Custom Inverter");
		recCustomInverter.setCost(0);
		recCustomInverter.setEfficiency(100);
		recCustomInverter.setEfficiencyLoss(0);
	    
		panelList.add(bPSolarInverter);
		panelList.add(sharpSolarInverter);
		panelList.add(sunlinqSolarInverter);
		panelList.add(sunPowerSolarInverter);
		panelList.add(sunTechSolarInverter);
		panelList.add(powerFirmSolarPanel);
		panelList.add(sanyoSolarPanel);
		panelList.add(globalSolarPanel);
		panelList.add(solarFunSolarPanel);
		panelList.add(recSolarPanel);
		panelList.add(recCustomInverter);
	    return panelList;
	}
}
