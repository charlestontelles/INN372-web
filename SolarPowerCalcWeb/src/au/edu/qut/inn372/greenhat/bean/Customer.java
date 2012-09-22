/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 * Bean that represents a Customer
 * 
 * @author Martin Daniel
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Customer implements Serializable {

	private static final long serialVersionUID = 7549990716571383217L;
	
	@ManagedProperty (value = "#{location}")
	private Location location;
	
	@ManagedProperty (value = "#{tariff}")
	private Tariff tariff;
	
	@ManagedProperty (value = "#{electricityUsage}")
	private ElectricityUsage electricityUsage;
	
	/**
	 * Get the location
	 * @return location value of the location property
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Set the location
	 * @param location new value for the location property 
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * Get the tariff
	 * @return tariff value of the tariff property
	 */
	public Tariff getTariff() {
		return tariff;
	}
	
	/**
	 * Set the tariff
	 * @param tariff new value for the tariff property
	 */
	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Get the daily average electricity usage
	 * @return electricityUsage value of the electricity usage property
	 */
	public ElectricityUsage getElectricityUsage() {
		return electricityUsage;
	}
	
	/**
	 * Set the daily average electricity usage
	 * @param electricityUsage new value for the electricity usage property
	 */
	public void setElectricityUsage(ElectricityUsage electricityUsage) {
		this.electricityUsage = electricityUsage;
	}
}
