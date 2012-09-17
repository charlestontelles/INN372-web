/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a tariff fee
 * @author Martin Daniel
 * @version 1.0
 */

@ManagedBean
@SessionScoped
public class Tariff implements Serializable {
	
	private static final long serialVersionUID = -8798153904184726039L;    
	private double tariff11Fee = 0.1941;
	private double annualTariffIncrease = 5;
	private double feedInFee = 0.5;
	private double tariffFeePerYear;

	/**
	 * Get tariff fee
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
	 * @return the tariffFeePerYear
	 */
	public double getTariffFeePerYear() {
		return tariffFeePerYear;
	}
	
	public void setTariffFeePerYear(double tariffFeePerYear){
		this.tariffFeePerYear = tariffFeePerYear;
	}
}
