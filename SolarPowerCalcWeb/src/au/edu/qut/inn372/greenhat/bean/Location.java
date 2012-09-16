/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 * Bean that represents a Location
 * 
 * @author Martin Daniel
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Location implements Serializable{

	private static final long serialVersionUID = -3413151911222121469L;
	
	private double sunLightHours; //average daily hours of sunlight
	private String region;
	private String city;
	
	@ManagedProperty (value = "#{roof}")
	private Roof roof;

	/**
	 * Get the roof
	 * @return roof value of the roof property
	 */
	public Roof getRoof() {
		return roof;
	}

	/**
	 * Set the roof
	 * @param roof new value for the roof property
	 */
	public void setRoof(Roof roof) {
		this.roof = roof;
	}

	/**
	 * Get the sunlight hours
	 * @return sunLightHours value of the sunlight hours
	 */
	public double getSunLightHours() {
		return sunLightHours;
	}

	/**
	 * Set the sunLightHours
	 * @param sunLightHours new value for the sunlight hours
	 */
	public void setSunLightHours(double sunLightHours) {
		this.sunLightHours = sunLightHours;
	}
	
	/**
	 * Get the region
	 * @return region value 
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Set the region
	 * @param region new value 
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Get the city
	 * @return city value
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city
	 * @param city new value 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
