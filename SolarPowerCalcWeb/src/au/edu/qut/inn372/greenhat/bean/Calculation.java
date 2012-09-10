/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * @author Martin Daniel
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Calculation implements Serializable{
	
	private static final long serialVersionUID = 3124836987351801557L;

	Integer year;
	Double tariff11Fee;
	Double dailySolarPower;
	Double replacementGeneration;
	Double exportedGeneration;
	Double dailySaving;
	Double annualSaving;
	Double cumulativeSaving;
		
 
	public Calculation(Integer year, Double tariff11Fee, Double dailySolarPower, 
			Double replacementGeneration, Double exportedGeneration, Double dailySaving, 
				Double annualSaving, Double cumulativeSaving) {
		this.year = year;
		this.tariff11Fee = tariff11Fee;
		this.dailySolarPower = dailySolarPower;
		this.replacementGeneration = replacementGeneration;
		this.exportedGeneration = exportedGeneration;
		this.dailySaving = dailySaving;
		this.annualSaving = annualSaving;
		this.cumulativeSaving = cumulativeSaving;
	}

	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the tariff11Fee
	 */
	public Double getTariff11Fee() {
		return tariff11Fee;
	}

	/**
	 * @param tariff11Fee the tariff11Fee to set
	 */
	public void setTariff11Fee(Double tariff11Fee) {
		this.tariff11Fee = tariff11Fee;
	}

	/**
	 * @return the dailySolarPower
	 */
	public Double getDailySolarPower() {
		return dailySolarPower;
	}

	/**
	 * @param dailySolarPower the dailySolarPower to set
	 */
	public void setDailySolarPower(Double dailySolarPower) {
		this.dailySolarPower = dailySolarPower;
	}

	/**
	 * @return the replacementGeneration
	 */
	public Double getReplacementGeneration() {
		return replacementGeneration;
	}

	/**
	 * @param replacementGeneration the replacementGeneration to set
	 */
	public void setReplacementGeneration(Double replacementGeneration) {
		this.replacementGeneration = replacementGeneration;
	}

	/**
	 * @return the exportedGeneration
	 */
	public Double getExportedGeneration() {
		return exportedGeneration;
	}

	/**
	 * @param exportedGeneration the exportedGeneration to set
	 */
	public void setExportedGeneration(Double exportedGeneration) {
		this.exportedGeneration = exportedGeneration;
	}

	/**
	 * @return the dailySaving
	 */
	public Double getDailySaving() {
		return dailySaving;
	}

	/**
	 * @param dailySaving the dailySaving to set
	 */
	public void setDailySaving(Double dailySaving) {
		this.dailySaving = dailySaving;
	}

	/**
	 * @return the annualSaving
	 */
	public Double getAnnualSaving() {
		return annualSaving;
	}

	/**
	 * @param annualSaving the annualSaving to set
	 */
	public void setAnnualSaving(Double annualSaving) {
		this.annualSaving = annualSaving;
	}

	/**
	 * @return the cumulativeSaving
	 */
	public Double getCumulativeSaving() {
		return cumulativeSaving;
	}

	/**
	 * @param cumulativeSaving the cumulativeSaving to set
	 */
	public void setCumulativeSaving(Double cumulativeSaving) {
		this.cumulativeSaving = cumulativeSaving;
	}
}
