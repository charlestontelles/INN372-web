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
	
	private double sunLightHours;
	
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
}
