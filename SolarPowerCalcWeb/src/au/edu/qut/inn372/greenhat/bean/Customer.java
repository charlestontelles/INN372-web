/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 * 
 * Bean that represents a customer
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
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Set the location
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * Get the tariff
	 * @return tariff
	 */
	public Tariff getTariff() {
		return tariff;
	}
	
	/**
	 * Set the tariff
	 * @param tariff
	 */
	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Get the electricity usage
	 * @return electricityUsage
	 */
	public ElectricityUsage getElectricityUsage() {
		return electricityUsage;
	}
	
	/**
	 * Set the electricity usage
	 * @param electricityUsage
	 */
	public void setElectricityUsage(ElectricityUsage electricityUsage) {
		this.electricityUsage = electricityUsage;
	}
}
