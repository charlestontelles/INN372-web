/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * @author Martin Daniel
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class Result implements Serializable{
	
	private static final long serialVersionUID = 3124836987351801557L;
	
	@ManagedProperty (value = "#{tariff}")
	private Tariff tariff;
	
	@ManagedProperty (value = "#{customer}")
	private Customer customer;
	
	@ManagedProperty (value = "#{equipment}")
	private Equipment equipment;
	
	@ManagedProperty (value ="#{panel}")
	private Panel panel;
	
	@ManagedProperty (value = "#{Location}")
	private Location location;
	
	@ManagedProperty (value = "#{electricityUsage}")
	private ElectricityUsage electricityUsage;
	
	private double [] tariff11Fees;
	//private double [] tariff33Fees;
	
	private double [] solarPowers;
	private double [] replacementGeneration;
	private double [] exportedGeneration;
	private double [] dailySavings;
	
	DecimalFormat df = new DecimalFormat("#.###");
	
	/**
	 * Set up an array to hold tariff fees
	 */
	public void setTariff11Fees(){
		tariff11Fees = new double [25];
		for(int i=0; i<25; i++){
			tariff11Fees[i] = Double.parseDouble( df.format( tariff.getTariff11Fee() * 
					( Math.pow( (1+tariff.getAnnualTariffIncrease()/100), ((i+1)-1) ) ) ) );
		}
	}
	
	/**
	 * Get the array of tariff fees
	 * @return tariffFees array
	 */
	public double [] getTariff11Fees(){
		return tariff11Fees;
	}
	

	/**
	 * @return the solarPowers
	 */
	public double[] getSolarPowers() {
		return solarPowers;
	}

	/**
	 * @param solarPowers the solarPowers to set
	 */
	public void setSolarPowers() {
		Location location = new Location();
		location = customer.getLocation();
		solarPowers = new double [25];
		for(int i = 0; i < 25; i++){
			solarPowers[i]  = Double.parseDouble( df.format(  ((equipment.getSize()
					* (location.getRoof().getPercentageNorth()/100)
					* (1-(location.getRoof().getEfficiencyLossNorth()/100)))
					+ (equipment.getSize()
					*(location.getRoof().getPercentageWest()/100)
					*(1-(location.getRoof().getEfficiencyLossWest()/100))))
					* (100 - panel.getEfficiencyLoss()*i)/100
					* (equipment.getInverter().getEfficiency()/100)*location.getSunLightHours() ));
		}
	}

	/**
	 * @return the tariff
	 */
	public Tariff getTariff() {
		return tariff;
	}

	/**
	 * @param tariff the tariff to set
	 */
	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the panel
	 */
	public Panel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the electricity
	 */
	public ElectricityUsage getElectricityUsage() {
		return electricityUsage;
	}

	/**
	 * @param electricity the electricity to set
	 */
	public void setElectricityUsage(ElectricityUsage electricityUsage) {
		this.electricityUsage = electricityUsage;
	}
	

	/**
	 * @return the replacementGeneration
	 */
	public double[] getReplacementGeneration() {
		return replacementGeneration;
	}

	/**
	 * @param replacementGeneration the replacementGeneration to set
	 */
	public void setReplacementGeneration() {
		replacementGeneration = new double [25];
		for(int i=0; i<25; i++){
			replacementGeneration[i] = Double.parseDouble( df.format ( customer.getLocation().getSunLightHours() * 
					electricityUsage.getDayTimeHourlyUsage() ) );
		}
	}

	/**
	 * @return the exportedGeneration
	 */
	public double [] getExportedGeneration() {
		return exportedGeneration;
	}

	/**
	 * @param exportedGeneration the exportedGeneration to set
	 */
	public void setExportedGeneration() {
		exportedGeneration = new double [25];
		for(int i=0; i<25; i++){
			exportedGeneration[i] = Double.parseDouble( df.format (solarPowers[i] - replacementGeneration[i] ));
		}
	}

	/**
	 * @return the dailySavings
	 */
	public double[] getDailySavings() {
		return dailySavings;
	}

	/**
	 * @param dailySavings the dailySavings to set
	 */
	public void setDailySavings() {
		dailySavings = new double [25];
		for(int i=0; i<25; i++){
			dailySavings[i] = Math.round( (replacementGeneration[i]*tariff11Fees[i] + 
					exportedGeneration[i]*0.5) *100.0)/100.0;
		}
	}	
}
