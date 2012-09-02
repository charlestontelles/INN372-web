/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * Bean that represents a daily average electricity usage
 * 
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
	 * Get the daily electricity usage
	 * @return the dailyAverageUsage value of the daily average electricity usage
	 */
	public double getDailyAverageUsage() {
		return dailyAverageUsage;
	}
	
	/**
	 * Set the daily electricity usage
	 * @param dailyAverageUsage new value of the daily electricity usage
	 */
	public void setDailyAverageUsage(double dailyAverageUsage) {
		this.dailyAverageUsage = dailyAverageUsage;
	}
	
	/**
	 * Get the daytime hourly electricity usage
	 * @return dayTimeHourlyUsage value of the daytime hourly usage
	 */
	public double getDayTimeHourlyUsage() {
		return dayTimeHourlyUsage;
	}
	
	/**
	 * Set the daytime hourly usage
	 * @param dayTimeHourlyUsage new daytime hourly electricity usage
	 */
	public void setDayTimeHourlyUsage(double dayTimeHourlyUsage) {
		this.dayTimeHourlyUsage = dayTimeHourlyUsage;
	}
}
