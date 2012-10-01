package au.edu.qut.inn372.greenhat.dao.gae;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Panel;
import au.edu.qut.inn372.greenhat.dao.PanelDAO;

public class PanelDAOImpl implements Serializable, PanelDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8132528384505235206L;
	List<Panel> panelList = new ArrayList<Panel>();
	
	public Panel getPanel(String brand){
		for(Panel p : panelList)
			if(p.getBrand() == brand)
				return p;
		return null;
	}
	
	@Override
	public List<Panel> getPanels() {
		Panel bPSolarPanel = new Panel();
		bPSolarPanel.setId(1);
		bPSolarPanel.setBrand("BP Solar Panels");
		bPSolarPanel.setCost(100);
		bPSolarPanel.setEfficiency(95);
		bPSolarPanel.setEfficiencyLoss(0.5);
		bPSolarPanel.setPowerRating(250);
		bPSolarPanel.setSize(2.25);
		
		Panel sharpSolarPanel = new Panel();
		sharpSolarPanel.setId(1);
		sharpSolarPanel.setBrand("Sharp Solar Panels");
		sharpSolarPanel.setCost(500);
		sharpSolarPanel.setEfficiency(100);
		sharpSolarPanel.setEfficiencyLoss(0.7);
		sharpSolarPanel.setPowerRating(700);
		sharpSolarPanel.setSize(2.25);
		
		Panel sunlinqSolarPanel = new Panel();
		sunlinqSolarPanel.setId(1);
		sunlinqSolarPanel.setBrand("Sunlinq Portable Solar Panels");
		sunlinqSolarPanel.setCost(400);
		sunlinqSolarPanel.setEfficiency(95);
		sunlinqSolarPanel.setEfficiencyLoss(0.7);
		sunlinqSolarPanel.setPowerRating(250);
		sunlinqSolarPanel.setSize(2.25);
		
		Panel sunPowerSolarPanel = new Panel();
		sunPowerSolarPanel.setId(1);
		sunPowerSolarPanel.setBrand("SunPower Solar Panels");
		sunPowerSolarPanel.setCost(400);
		sunPowerSolarPanel.setEfficiency(95);
		sunPowerSolarPanel.setEfficiencyLoss(0.8);
		sunPowerSolarPanel.setPowerRating(300);
		sunPowerSolarPanel.setSize(2.25);
		
		Panel sunTechSolarPanel = new Panel();
		sunTechSolarPanel.setId(1);
		sunTechSolarPanel.setBrand("SunTech Solar Panels");
		sunTechSolarPanel.setCost(400);
		sunTechSolarPanel.setEfficiency(95);
		sunTechSolarPanel.setEfficiencyLoss(0.7);
		sunTechSolarPanel.setPowerRating(250);
		sunTechSolarPanel.setSize(2.25);
		
		Panel powerFirmSolarPanel = new Panel();
		powerFirmSolarPanel.setId(1);
		powerFirmSolarPanel.setBrand("Powerfilm Flexible Solar Panels");
		powerFirmSolarPanel.setCost(400);
		powerFirmSolarPanel.setEfficiency(95);
		powerFirmSolarPanel.setEfficiencyLoss(0.7);
		powerFirmSolarPanel.setPowerRating(250);
		powerFirmSolarPanel.setSize(2.25);

		Panel sanyoSolarPanel = new Panel();
		sanyoSolarPanel.setId(1);
		sanyoSolarPanel.setBrand("Sanyo Solar Panels");
		sanyoSolarPanel.setCost(450);
		sanyoSolarPanel.setEfficiency(95);
		sanyoSolarPanel.setEfficiencyLoss(0.8);
		sanyoSolarPanel.setPowerRating(500);
		sanyoSolarPanel.setSize(2.25);
		
		Panel globalSolarPanel = new Panel();
		globalSolarPanel.setId(1);
		globalSolarPanel.setBrand("Global Solar Panels");
		globalSolarPanel.setCost(400);
		globalSolarPanel.setEfficiency(95);
		globalSolarPanel.setEfficiencyLoss(0.7);
		globalSolarPanel.setPowerRating(250);
		globalSolarPanel.setSize(2.25);
		
		Panel solarFunSolarPanel = new Panel();
		solarFunSolarPanel.setId(1);
		solarFunSolarPanel.setBrand("Solarfun");
		solarFunSolarPanel.setCost(400);
		solarFunSolarPanel.setEfficiency(95);
		solarFunSolarPanel.setEfficiencyLoss(0.7);
		solarFunSolarPanel.setPowerRating(250);
		solarFunSolarPanel.setSize(2.25);
		
		Panel recSolarPanel = new Panel();
		recSolarPanel.setId(1);
		recSolarPanel.setBrand("REC Solar Panels");
		recSolarPanel.setCost(400);
		recSolarPanel.setEfficiency(95);
		recSolarPanel.setEfficiencyLoss(0.7);
		recSolarPanel.setPowerRating(250);
		recSolarPanel.setSize(2.25);
	    
		panelList.add(bPSolarPanel);
		panelList.add(sharpSolarPanel);
		panelList.add(sunlinqSolarPanel);
		panelList.add(sunPowerSolarPanel);
		panelList.add(sunTechSolarPanel);
		panelList.add(powerFirmSolarPanel);
		panelList.add(sanyoSolarPanel);
		panelList.add(globalSolarPanel);
		panelList.add(solarFunSolarPanel);
		panelList.add(recSolarPanel);
	    return panelList;
	}
}
