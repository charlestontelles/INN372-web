/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a traiff fee
 * @author Martin Daniel
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Tariff implements Serializable {
	
	private static final long serialVersionUID = -8798153904184726039L;
	
	//private double tariff11Cost;
	//private double tariff33Cost;
	private double tariff11Fee = 0.1941;
	//private double tariff33Fee;
	//private double annualTariff11Cost;
	//private double annualTariff33Cost;
	private double annualTariffIncrease = 5;
	private double feedInFee = 0.5;
	private double tariffFeePerYear;

	/**
	 * Get tariff 11 fee
	 * @return the tariff11Fee
	 */
	public double getTariff11Fee() {
		return tariff11Fee;
	}
	/**
	 * Set the tariff fee
	 * @param tariff11Fee the tariff11Fee to set to
	 */
	public void setTariff11Fee(double tariff11Fee) {
		this.tariff11Fee = tariff11Fee;
	}
	/**
	 * Get the annual tariff increase
	 * @return the annualTariffIncrease
	 */
	public double getAnnualTariffIncrease() {
		return annualTariffIncrease;
	}
	/**
	 * Set the annual tariff increase
	 * @param annualTariffIncrease the annualTariffIncrease to set to
	 */
	public void setAnnualTariffIncrease(double annualTariffIncrease) {
		this.annualTariffIncrease = annualTariffIncrease;
	}
	/**
	 * Get the feed in fee
	 * @return the feedInfee
	 */
	public double getFeedInFee() {
		return feedInFee;
	}
	/**
	 * Set the feed in fee
	 * @param feedInfee the feedInfee to set
	 */
	public void setFeedInFee(double feedInFee) {
		this.feedInFee = feedInFee;
	}

	/**
	 * Get the tariff per year
	 * @return tariffPerYear 
	 */
	public double getTariffPerYear(int year){
		return tariffFeePerYear;
	}
	
	/**
	 * Set the tariff fee per year
	 * @param tariffFeePerYear the tariffFeePerYear to set
	 */
	public void setTariffFeePerYear(double year) {
		this.tariffFeePerYear = tariff11Fee * ( Math.pow( (1+annualTariffIncrease/100), (year-1) ) );
	}
}
