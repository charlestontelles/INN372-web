/**
 * 
 */
package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

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
	
	private double [] tariff11Fees;
	//private double [] tariff33Fees;
	
	private double [] solarPowers;
	
	/**
	 * Set up an array to hold tariff fees
	 */
	public void setTariff11Fees(){
		tariff11Fees = new double [25];
		for(int i=0; i<25; i++){
			//tariffFees[i] = tariff11Fee * ( Math.pow( (1+annualTariffIncrease/100), ((i+1)-1) ) );
			tariff11Fees[i] = tariff.getTariff11Fee() * 
					( Math.pow( (1+tariff.getAnnualTariffIncrease()/100), ((i+1)-1) ) );
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
			solarPowers[i]  =((equipment.getSize()
					* (location.getRoof().getPercentageNorth()/100)
					* (1-(location.getRoof().getEfficiencyLossNorth()/100)))
					+ (equipment.getSize()
					*(location.getRoof().getPercentageWest()/100)
					*(1-(location.getRoof().getEfficiencyLossWest()/100))))
					* (100 - panel.getEfficiencyLoss()*i)/100
					* (equipment.getInverter().getEfficiency()/100)*location.getSunLightHours();
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
}
