/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * 
 * Bean that represents sunlight
 * @author Martin Daniel
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Sunlight implements Serializable {
	
	private static final long serialVersionUID = 192594841205611668L;
	
	private double sunLightHours;

	/**
	 * Get the sun light hours
	 * @return sunLightHours
	 */
	public double getSunLightHours() {
		return sunLightHours;
	}

	/**
	 * Set the sun light hours
	 * @param sunLightHours
	 */
	public void setSunLightHours(double sunLightHours) {
		this.sunLightHours = sunLightHours;
	}
}
