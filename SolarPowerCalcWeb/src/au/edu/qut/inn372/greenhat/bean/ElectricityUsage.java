/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * 
 * Bean that represents a customer
 * @author Martin Daniel
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class ElectricityUsage implements Serializable{
	
	private static final long serialVersionUID = -8315704050812581587L;
	
	private double dailyAverageUsage;
	private double dayTimeHourlyUsage;
	
	/**
	 * Get the daily energy usage
	 * @return the dailyAverageUsage
	 */
	public double getDailyAverageUsage() {
		return dailyAverageUsage;
	}
	/**
	 * Set the daily energy usage
	 * @param dailyAverageUsage new daily energy usage
	 */
	public void setDailyAverageUsage(double dailyAverageUsage) {
		this.dailyAverageUsage = dailyAverageUsage;
	}
	/**
	 * Get the daytime hourly energy usage
	 * @return dayTimeHourlyUsage
	 */
	public double getDayTimeHourlyUsage() {
		return dayTimeHourlyUsage;
	}
	/**
	 * @param dayTimeHourlyUsage new daytime hourly energy usage
	 */
	public void setDayTimeHourlyUsage(double dayTimeHourlyUsage) {
		this.dayTimeHourlyUsage = dayTimeHourlyUsage;
	}
}
