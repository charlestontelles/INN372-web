package au.edu.qut.inn372.greenhat.dao.gae;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import au.edu.qut.inn372.greenhat.bean.Location;
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
		Location sydney = new Location();
		sydney.setCity("Sydney");
		sydney.setSunLightHours(8/2.0);
		Location melbourne = new Location();
		melbourne.setCity("Melbourne");
		melbourne.setSunLightHours(5/2.0);
		Location canberra = new Location();
		canberra.setCity("Canberra");
		canberra.setSunLightHours(6/2.0);
		Location perth = new Location();
		perth.setCity("Adelaide");
		perth.setSunLightHours(8/2.0);
		Location hobart = new Location();
		hobart.setCity("Hobart");
		hobart.setSunLightHours(5/2.0);
		Location darwin = new Location();
		darwin.setCity("Darwin");
		darwin.setSunLightHours(9/2.0);
		
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
