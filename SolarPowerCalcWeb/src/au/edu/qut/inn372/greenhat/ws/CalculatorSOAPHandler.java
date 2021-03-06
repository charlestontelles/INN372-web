package au.edu.qut.inn372.greenhat.ws;

import java.util.Iterator;

import javax.xml.bind.JAXB;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SAAJResult;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.dom.DOMSource;

import au.edu.qut.inn372.greenhat.ws.jaxws.CalcEnergyProduction;
import au.edu.qut.inn372.greenhat.ws.jaxws.DeleteCalculation;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetCalculation;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetCalculations;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetEquipments;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetPanels;
import au.edu.qut.inn372.greenhat.ws.jaxws.GetSunLightHours;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveCalculation;
import au.edu.qut.inn372.greenhat.ws.jaxws.SaveUserProfile;
import au.edu.qut.inn372.greenhat.ws.jaxws.ValidateCredentials;

/**
 * 
 * @author Charleston Telles
 * @version 1.0
 */
public class CalculatorSOAPHandler {
	  private static final String NAMESPACE_URI = "http://ws.greenhat.inn372.qut.edu.au/";
	  private static final QName CALC_ENERGY_PRODUCTION_QNAME = new QName(NAMESPACE_URI, "calcEnergyProduction");
	  private static final QName SAVE_CALCULATION_QNAME = new QName(NAMESPACE_URI, "saveCalculation");
	  private static final QName GET_EQUIPMENTS_QNAME = new QName(NAMESPACE_URI, "getEquipments");
	  private static final QName SAVE_USER_PROFILE_QNAME = new QName(NAMESPACE_URI, "saveUserProfile");
	  private static final QName VALIDATE_CREDENTIALS_QNAME = new QName(NAMESPACE_URI, "validateCredentials");
	  private static final QName DELETE_CALCULATION_QNAME = new QName(NAMESPACE_URI, "deleteCalculation");
	  private static final QName GET_CALCULATION_QNAME = new QName(NAMESPACE_URI, "getCalculation");
	  private static final QName GET_CALCULATIONS_QNAME = new QName(NAMESPACE_URI, "getCalculations");
	  private static final QName GET_PANELS_QNAME = new QName(NAMESPACE_URI, "getPanels");
	  private static final QName GET_SUNLIGHTHOURS_QNAME = new QName(NAMESPACE_URI, "getSunLightHours");
	  
	  private MessageFactory messageFactory;
	  private CalculatorAdapter calculatorAdapter;
	  
	  public CalculatorSOAPHandler() throws SOAPException {
		    messageFactory = MessageFactory.newInstance();
		    calculatorAdapter = new CalculatorAdapter();
	  }	  
	  
	  public SOAPMessage handleSOAPRequest(SOAPMessage request) throws SOAPException {
		    SOAPBody soapBody = request.getSOAPBody();
		    Iterator iterator = soapBody.getChildElements();
		    Object responsePojo = null;
		    while (iterator.hasNext()) {
		      Object next = iterator.next();
		      if (next instanceof SOAPElement) {
		        SOAPElement soapElement = (SOAPElement) next;
		        QName qname = soapElement.getElementQName();
		          if (CALC_ENERGY_PRODUCTION_QNAME.equals(qname)) {
		            responsePojo = handleCalcEnergyProcutionRequest(soapElement);
		            break;
		          } else if (SAVE_CALCULATION_QNAME.equals(qname)) {
		            responsePojo = handleSaveCalculationRequest(soapElement);
		            break;
		          } else if (SAVE_USER_PROFILE_QNAME.equals(qname)) {
			            responsePojo = handleSaveUserProfileRequest(soapElement);
			            break;
		          } else if (VALIDATE_CREDENTIALS_QNAME.equals(qname)) {
			            responsePojo = handleValidateCredentialsRequest(soapElement);
			            break;
		          } else if (DELETE_CALCULATION_QNAME.equals(qname)) {
			            responsePojo = handleDeleteCalculationRequest(soapElement);
			            break;
		          } else if (GET_CALCULATION_QNAME.equals(qname)) {
			            responsePojo = handleGetCalculationRequest(soapElement);
			            break;
		          } else if (GET_CALCULATIONS_QNAME.equals(qname)) {
			            responsePojo = handleGetCalculationsRequest(soapElement);
			            break;
		          } else if (GET_EQUIPMENTS_QNAME.equals(qname)) {
			            responsePojo = handleGetEquipmentsRequest(soapElement);
			            break;
		          } else if (GET_PANELS_QNAME.equals(qname)) {
			            responsePojo = handleGetPanelsRequest(soapElement);
			            break;
		          } else if (GET_SUNLIGHTHOURS_QNAME.equals(qname)) {
			            responsePojo = handleGetSunLightHours(soapElement);
			            break;
		          } 
		      }
		    }
		    SOAPMessage soapResponse = messageFactory.createMessage();
		    soapBody = soapResponse.getSOAPBody();
		    if (responsePojo != null) {
		      JAXB.marshal(responsePojo, new SAAJResult(soapBody));
		    } else {
		      SOAPFault fault = soapBody.addFault();
		      fault.setFaultString("Unrecognized SOAP request.");
		    }
		    return soapResponse;
		  }
	  
	  private Object handleCalcEnergyProcutionRequest(SOAPElement soapElement) {
		    CalcEnergyProduction request = JAXB.unmarshal(new DOMSource(soapElement), CalcEnergyProduction.class);
		    return calculatorAdapter.calcEnergyProduction(request);
	  }

	  private Object handleSaveCalculationRequest(SOAPElement soapElement) {
		    SaveCalculation request = JAXB.unmarshal(new DOMSource(soapElement), SaveCalculation.class);
		    return calculatorAdapter.saveCalculation(request);
	  }
	  
	  private Object handleGetEquipmentsRequest(SOAPElement soapElement) {
		    GetEquipments request = JAXB.unmarshal(new DOMSource(soapElement), GetEquipments.class);
		    return calculatorAdapter.getEquipments(request);
	  }
	  
	  private Object handleSaveUserProfileRequest(SOAPElement soapElement) {
		    SaveUserProfile request = JAXB.unmarshal(new DOMSource(soapElement), SaveUserProfile.class);
		    return calculatorAdapter.saveUserProfile(request);
	  }
	  
	  private Object handleValidateCredentialsRequest(SOAPElement soapElement) {
		    ValidateCredentials request = JAXB.unmarshal(new DOMSource(soapElement), ValidateCredentials.class);
		    return calculatorAdapter.validateCredentials(request);
	  }
	  
	  private Object handleDeleteCalculationRequest(SOAPElement soapElement) {
		    DeleteCalculation request = JAXB.unmarshal(new DOMSource(soapElement), DeleteCalculation.class);
		    return calculatorAdapter.deleteCalculation(request);
	  }
	  
	  private Object handleGetCalculationRequest(SOAPElement soapElement) {
		    GetCalculation request = JAXB.unmarshal(new DOMSource(soapElement), GetCalculation.class);
		    return calculatorAdapter.getCalculation(request);
	  }
	  
	  private Object handleGetCalculationsRequest(SOAPElement soapElement) {
		    GetCalculations request = JAXB.unmarshal(new DOMSource(soapElement), GetCalculations.class);
		    return calculatorAdapter.getCalculations(request);
	  }
	  
	  private Object handleGetPanelsRequest(SOAPElement soapElement) {
		    GetPanels request = JAXB.unmarshal(new DOMSource(soapElement), GetPanels.class);
		    return calculatorAdapter.getPanels(request);
	  }
	  
	  private Object handleGetSunLightHours(SOAPElement soapElement) {
		    GetSunLightHours request = JAXB.unmarshal(new DOMSource(soapElement), GetSunLightHours.class);
		    return calculatorAdapter.getSunLightHours(request);
	  }
}
