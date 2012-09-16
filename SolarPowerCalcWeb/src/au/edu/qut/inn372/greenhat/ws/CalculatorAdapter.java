package au.edu.qut.inn372.greenhat.ws;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.ws.jaxws.CalcEnergyProduction;
import au.edu.qut.inn372.greenhat.ws.jaxws.CalcEnergyProductionResponse;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetEquipments;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetEquipmentsResponse;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveCalculation;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveCalculationResponse;
/**
 * 
 * @author Charleston Telles
 * @version 1.0
 */
public class CalculatorAdapter {
	private CalculatorControllerWS controller = new CalculatorControllerWS();
	
	public SaveCalculationResponse saveCalculation(SaveCalculation saveCalculation){
		String message = controller.saveCalculation(saveCalculation.getCalculator());
		SaveCalculationResponse response = new SaveCalculationResponse();
		response.setResult(message);
		return response;
	}
	
	public CalcEnergyProductionResponse calcEnergyProduction(CalcEnergyProduction calcEnergyProduction){
		Calculator calculator = controller.calcEnergyProduction(calcEnergyProduction.getCalculator());
		CalcEnergyProductionResponse response = new CalcEnergyProductionResponse();
		response.setCalculator(calculator);
		return response;
	}
	
	public GetEquipmentsResponse getEquipments(GetEquipments getEquipments){
		Equipment[] equipments = controller.getEquipments();
		GetEquipmentsResponse response = new GetEquipmentsResponse();
		response.setEquipments(equipments);
		return response;
	}
}
