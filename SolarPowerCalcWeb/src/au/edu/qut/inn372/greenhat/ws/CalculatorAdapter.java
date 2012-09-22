package au.edu.qut.inn372.greenhat.ws;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.UserProfile;
import au.edu.qut.inn372.greenhat.ws.jaxws.CalcEnergyProduction;
import au.edu.qut.inn372.greenhat.ws.jaxws.CalcEnergyProductionResponse;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetEquipments;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetEquipmentsResponse;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveCalculation;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveCalculationResponse;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveUserProfile;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveUserProfileResponse;
import au.edu.qut.inn372.greenhat.ws.jaxws.ValidateCredentials;
import au.edu.qut.inn372.greenhat.ws.jaxws.ValidateCredentialsResponse;
/**
 * The Web Service Adapter is responsible to convert the JAXB to 
 * Bean objects
 * 
 * @author Charleston Telles
 * @version 1.0
 */
public class CalculatorAdapter {
	private CalculatorControllerWS controller = new CalculatorControllerWS();
	/**
	 * Save a calculation in database
	 * 
	 * @param saveCalculation
	 * @return
	 */
	public SaveCalculationResponse saveCalculation(SaveCalculation saveCalculation){
		String message = controller.saveCalculation(saveCalculation.getCalculator());
		SaveCalculationResponse response = new SaveCalculationResponse();
		response.setResult(message);
		return response;
	}
	/**
	 * Execute energy production calculation
	 * 
	 * @param calcEnergyProduction
	 * @return
	 */
	public CalcEnergyProductionResponse calcEnergyProduction(CalcEnergyProduction calcEnergyProduction){
		Calculator calculator = controller.calcEnergyProduction(calcEnergyProduction.getCalculator());
		CalcEnergyProductionResponse response = new CalcEnergyProductionResponse();
		response.setCalculator(calculator);
		return response;
	}
	/**
	 * Gets a list of equipments from database
	 * 
	 * @param getEquipments
	 * @return
	 */
	public GetEquipmentsResponse getEquipments(GetEquipments getEquipments){
		Equipment[] equipments = controller.getEquipments();
		GetEquipmentsResponse response = new GetEquipmentsResponse();
		response.setEquipments(equipments);
		return response;
	}
	/**
	 * Save a user profile, if user profile already exists then
	 * it will be updated 
	 * 
	 * @param saveUserProfile
	 * @return
	 */
	public SaveUserProfileResponse saveUserProfile(SaveUserProfile saveUserProfile){
		UserProfile userProfile = controller.saveUserProfile(saveUserProfile.getUserProfile());
		SaveUserProfileResponse response = new SaveUserProfileResponse();
		response.setUserProfile(userProfile);
		return response;
	}	
	/**
	 * Validates the credentials used to login
	 * 
	 * @param validateCredentials
	 * @return
	 */
	public ValidateCredentialsResponse validateCredentials(ValidateCredentials validateCredentials){
		String result = controller.validateCredentials(validateCredentials.getEmail(), validateCredentials.getPassword());
		ValidateCredentialsResponse response = new ValidateCredentialsResponse();
		response.setResult(result);
		return response;
	}
}
