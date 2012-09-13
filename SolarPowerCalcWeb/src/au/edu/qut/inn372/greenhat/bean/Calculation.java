/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a list of calculations
 * @author Martin Daniel
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Calculation implements Serializable{
	
	private static final long serialVersionUID = 3124836987351801557L;

	int year;
	double panelEfficiency;
	double bank1Efficiency;
	double bank2Efficiency;
	double bank1DailySolarPower;
	double bank2DailySolarPower;
	double tariff11Fee;
	double dailySolarPower; //total daily solar power
	double replacementGeneration; 	//energy saved
	double exportedGeneration; 		// excess energy produced
	double moneySaved; 				// money saved on electricity bill 
	double moneyEarned;				// money earned from exporting excess energy
	double dailySaving;				
	double annualSaving;
	double cumulativeSaving;
	double returnOnInvestment;
	double paybackPeriod;
		
	/**
	 * A calculation object contains info about year, tariff, solar power generation and savings.
	 * @param year
	 * @param tariff11Fee
	 * @param dailySolarPower
	 * @param replacementGeneration
	 * @param exportedGeneration
	 * @param dailySaving
	 * @param annualSaving
	 * @param cumulativeSaving
	 */
	
	public Calculation(){}
	
	public Calculation(Integer year, double panelEfficiency, double bank1Efficiency, 
			double bank2Efficiency, double bank1DailySolarPower, double bank2DailySolarPower,
			double tariff11Fee, double dailySolarPower, double replacementGeneration, double exportedGeneration, 
			double moneySaved, double moneyEarned, double dailySaving, double annualSaving, double cumulativeSaving, double returnOnInvestment) {
		this.year = year;
		this.panelEfficiency = panelEfficiency;
		this.bank1Efficiency = bank1Efficiency;
		this.bank2Efficiency = bank2Efficiency;
		this.bank1DailySolarPower = bank1DailySolarPower;
		this.bank2DailySolarPower = bank2DailySolarPower;
		this.tariff11Fee = tariff11Fee;
		this.dailySolarPower = dailySolarPower;
		this.replacementGeneration = replacementGeneration;
		this.exportedGeneration = exportedGeneration;
		this.moneySaved = moneySaved;
		this.moneyEarned = moneyEarned;
		this.dailySaving = dailySaving;
		this.annualSaving = annualSaving;
		this.cumulativeSaving = cumulativeSaving;
		this.returnOnInvestment = returnOnInvestment;
	}

	/**
	 * Get the year for a calculation
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Set the year for a calculation
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Get the tariff for a year
	 * @return the tariff11Fee
	 */
	public double getTariff11Fee() {
		return tariff11Fee;
	}

	/**
	 * Set the tariff for a year
	 * @param tariff11Fee the tariff11Fee to set
	 */
	public void setTariff11Fee(double tariff11Fee) {
		this.tariff11Fee = tariff11Fee;
	}

	/**
	 * Get the daily solar power generation for a year
	 * @return the dailySolarPower
	 */
	public double getDailySolarPower() {
		return dailySolarPower;
	}

	/**
	 * Set the daily solar power generation for a year
	 * @param dailySolarPower the dailySolarPower to set
	 */
	public void setDailySolarPower(double dailySolarPower) {
		this.dailySolarPower = dailySolarPower;
	}

	/**
	 * Get the solar power replacement generation
	 * @return the replacementGeneration
	 */
	public double getReplacementGeneration() {
		return replacementGeneration;
	}

	/**Set the replacement solar power generation
	 * @param replacementGeneration the replacementGeneration to set
	 */
	public void setReplacementGeneration(double replacementGeneration) {
		this.replacementGeneration = replacementGeneration;
	}

	/**
	 * Get the exported solar power generation
	 * @return the exportedGeneration
	 */
	public double getExportedGeneration() {
		return exportedGeneration;
	}

	/**
	 * Set the exported solar power generation
	 * @param exportedGeneration the exportedGeneration to set
	 */
	public void setExportedGeneration(double exportedGeneration) {
		this.exportedGeneration = exportedGeneration;
	}

	/**
	 * Get the daily savings for a year
	 * @return the dailySaving
	 */
	public double getDailySaving() {
		return dailySaving;
	}

	/**
	 * Set the daily savings for a year
	 * @param dailySaving the dailySaving to set
	 */
	public void setDailySaving(double dailySaving) {
		this.dailySaving = dailySaving;
	}

	/**
	 * Get the annual savings for a year
	 * @return the annualSaving
	 */
	public double getAnnualSaving() {
		return annualSaving;
	}

	/**
	 * Set the annual savings for a year
	 * @param annualSaving the annualSaving to set
	 */
	public void setAnnualSaving(double annualSaving) {
		this.annualSaving = annualSaving;
	}

	/**
	 * Get the cumulative savings for a year
	 * @return the cumulativeSaving
	 */
	public double getCumulativeSaving() {
		return cumulativeSaving;
	}

	/**
	 * Set the cumulative savings for a year
	 * @param cumulativeSaving the cumulativeSaving to set
	 */
	public void setCumulativeSaving(double cumulativeSaving) {
		this.cumulativeSaving = cumulativeSaving;
	}

	/**
	 * @return the moneySaved
	 */
	public double getMoneySaved() {
		return moneySaved;
	}

	/**
	 * @param moneySaved the moneySaved to set
	 */
	public void setMoneySaved(double moneySaved) {
		this.moneySaved = moneySaved;
	}

	/**
	 * @return the panelEfficiency
	 */
	public double getPanelEfficiency() {
		return panelEfficiency;
	}

	/**
	 * @param panelEfficiency the panelEfficiency to set
	 */
	public void setPanelEfficiency(double panelEfficiency) {
		this.panelEfficiency = panelEfficiency;
	}

	/**
	 * @return the bank1Efficiency
	 */
	public double getBank1Efficiency() {
		return bank1Efficiency;
	}

	/**
	 * @param bank1Efficiency the bank1Efficiency to set
	 */
	public void setBank1Efficiency(double bank1Efficiency) {
		this.bank1Efficiency = bank1Efficiency;
	}

	/**
	 * @return the bank2Efficiency
	 */
	public double getBank2Efficiency() {
		return bank2Efficiency;
	}

	/**
	 * @param bank2Efficiency the bank2Efficiency to set
	 */
	public void setBank2Efficiency(double bank2Efficiency) {
		this.bank2Efficiency = bank2Efficiency;
	}

	/**
	 * @return the bank1DailySolarPower
	 */
	public double getBank1DailySolarPower() {
		return bank1DailySolarPower;
	}

	/**
	 * @param bank1DailySolarPower the bank1DailySolarPower to set
	 */
	public void setBank1DailySolarPower(double bank1DailySolarPower) {
		this.bank1DailySolarPower = bank1DailySolarPower;
	}

	/**
	 * @return the bank2DailySolarPower
	 */
	public double getBank2DailySolarPower() {
		return bank2DailySolarPower;
	}

	/**
	 * @param bank2DailySolarPower the bank2DailySolarPower to set
	 */
	public void setBank2DailySolarPower(double bank2DailySolarPower) {
		this.bank2DailySolarPower = bank2DailySolarPower;
	}

	/**
	 * @return the moneyEarned
	 */
	public double getMoneyEarned() {
		return moneyEarned;
	}

	/**
	 * @param moneyEarned the moneyEarned to set
	 */
	public void setMoneyEarned(double moneyEarned) {
		this.moneyEarned = moneyEarned;
	}

	/**
	 * @return the returnOnInvestment
	 */
	public double getReturnOnInvestment() {
		return returnOnInvestment;
	}

	/**
	 * @param returnOnInvestment the returnOnInvestment to set
	 */
	public void setReturnOnInvestment(double returnOnInvestment) {
		this.returnOnInvestment = returnOnInvestment;
	}

	/**
	 * @return the paybackPeriod
	 */
	public double getPaybackPeriod() {
		return paybackPeriod;
	}

	/**
	 * @param paybackPeriod the paybackPeriod to set
	 */
	public void setPaybackPeriod(double paybackPeriod) {
		this.paybackPeriod = paybackPeriod;
	}
}
