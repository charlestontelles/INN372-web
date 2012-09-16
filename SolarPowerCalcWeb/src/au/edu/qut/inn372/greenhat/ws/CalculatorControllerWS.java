package au.edu.qut.inn372.greenhat.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.dao.CalculatorDAO;
import au.edu.qut.inn372.greenhat.dao.EquipmentDAO;
import au.edu.qut.inn372.greenhat.dao.gae.CalculatorDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.EquipmentDAOImpl;

/**
 * 
 * @author Charleston Telles
 * @version 1.0
 */
@WebService
public class CalculatorControllerWS {
	private Calculator calculator = new Calculator();	
	private CalculatorDAO calculatorDAO = new CalculatorDAOImpl();
	private EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
	
	@WebMethod
	@WebResult(name = "result") 
	public String saveCalculation(@WebParam(name = "calculator") Calculator calculator){
		try {
			calculatorDAO.saveCalculation(calculator);
			return "ok";
		} catch (Exception e) {
			return "error: " + e;
		}		
	}
	
	@WebMethod
	@WebResult(name = "calculator") 
	public Calculator calcEnergyProduction(@WebParam(name = "calculator") Calculator calculator){
		this.calculator = calculator;
		//this.calculator.calculateSolarPower();
		this.calculator.performCalculations();
		return calculator;
	}
	
	@WebMethod
	@WebResult(name = "equipments") 
	public Equipment[] getEquipments(){
		List<Equipment> arrayList = equipmentDAO.getEquipments();		
		Equipment[] list = new Equipment[arrayList.size()];
		arrayList.toArray(list);
		return list;
	}
	
}
