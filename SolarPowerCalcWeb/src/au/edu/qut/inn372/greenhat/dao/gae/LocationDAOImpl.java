package au.edu.qut.inn372.greenhat.dao.gae;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Bank;
import au.edu.qut.inn372.greenhat.bean.Location;
import au.edu.qut.inn372.greenhat.bean.Roof;
import au.edu.qut.inn372.greenhat.dao.LocationDAO;

public class LocationDAOImpl implements Serializable, LocationDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8132528384505235206L;
	List<Location> locations = new ArrayList<Location>();

	@Override
	public double getAverageSunlightHours(String city) {
		for(Location location : locations){
			if(location.getCity() == city)
				return location.getSunLightHours();
		}
		return 0;
	}
	
	
	@Override
	public List<Location> getLocations() {
		Location brisbane = new Location();
		brisbane.setCity("Brisbane");
		brisbane.setSunLightHours(9/2.0);
		
		Roof brisbaneRoof = new Roof();
		brisbaneRoof.getBanks()[0].setSelectedOrientation("North");
		brisbaneRoof.getBanks()[1].setSelectedOrientation("West");
		brisbane.setRoof(brisbaneRoof);
		
		Location sydney = new Location();
		sydney.setCity("Sydney");
		sydney.setSunLightHours(8/2.0);
		Roof SydneyRoof = new Roof();
		SydneyRoof.getBanks()[0].setSelectedOrientation("North");
		SydneyRoof.getBanks()[1].setSelectedOrientation("North West");
		sydney.setRoof(SydneyRoof);
		
		Location melbourne = new Location();
		melbourne.setCity("Melbourne");
		melbourne.setSunLightHours(5/2.0);
		Roof melbourneRoof = new Roof();
		melbourneRoof.getBanks()[0].setSelectedOrientation("North");
		melbourneRoof.getBanks()[1].setSelectedOrientation("North West");
		melbourne.setRoof(melbourneRoof);
		
		Location canberra = new Location();
		canberra.setCity("Canberra");
		canberra.setSunLightHours(6/2.0);
		Roof canberraRoof = new Roof();
		canberraRoof.getBanks()[0].setSelectedOrientation("North");
		canberraRoof.getBanks()[1].setSelectedOrientation("South West");
		canberra.setRoof(canberraRoof);
		
		Location perth = new Location();
		perth.setCity("Adelaide");
		perth.setSunLightHours(8/2.0);
		Roof perthRoof = new Roof();
		perthRoof.getBanks()[0].setSelectedOrientation("North");
		perthRoof.getBanks()[1].setSelectedOrientation("East");
		perth.setRoof(perthRoof);
		
		Location hobart = new Location();
		hobart.setCity("Hobart");
		hobart.setSunLightHours(5/2.0);
		Roof hobartRoof = new Roof();
		hobartRoof.getBanks()[0].setSelectedOrientation("North");
		hobartRoof.getBanks()[1].setSelectedOrientation("South");
		hobart.setRoof(hobartRoof);
		
		Location darwin = new Location();
		darwin.setCity("Darwin");
		darwin.setSunLightHours(9/2.0);
		Roof darwinRoof = new Roof();
		darwinRoof.getBanks()[0].setSelectedOrientation("North");
		darwinRoof.getBanks()[1].setSelectedOrientation("West");
		darwin.setRoof(darwinRoof);
		
		
		locations.add(brisbane);
		locations.add(sydney);
		locations.add(melbourne);
		locations.add(canberra);
		locations.add(perth);
		locations.add(hobart);
		locations.add(darwin);
		
		return locations;
	}
}
