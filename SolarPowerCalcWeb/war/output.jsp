<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solar Calculator Tool-&gt; Solar Power Generation</title>
<LINK href="<%=request.getContextPath()%>/css/greenhat_style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <f:view>
    <h:form styleClass="input" >
    	<h3 align = "center"> Average Solar Power Generation </h3>
    	
    	<table class = "width" align="center">
		<tr><td> 
			<fieldset>
				<table class = "width">
				<tr>
					<td><h:outputText value="Daily:"></h:outputText></td>
					<td class="right"><h:outputText value="#{result.solarPowers[0]}">
							<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
						</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
				<tr>
					<td><h:outputText value="Quarterly:"></h:outputText></td>
					<td class="right"><h:outputText value="#{result.solarPowers[0] * 91}">
							<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
						</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
				<tr>
					<td><h:outputText value="Annually:"></h:outputText></td>
					<td class="right"><h:outputText value="#{result.solarPowers[0] * 365}">
							<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
						</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
				<tr><td></td><td></td></tr>
				<tr>
					<td><h:outputText value="Daily Net:"></h:outputText></td>
					<td class="right"><h:outputText value="#{result.solarPowers[0] - electricityUsage.dailyAverageUsage}">
						<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
					</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
							<tr>
					<td><h:outputText value="Quarterly Net:"></h:outputText></td>
					<td class="right"><h:outputText value="#{(result.solarPowers[0] - electricityUsage.dailyAverageUsage) * 91}">
						<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
					</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
							<tr>
					<td><h:outputText value="Annual Net:"></h:outputText></td>
					<td class="right"><h:outputText value="#{(result.solarPowers[0] - electricityUsage.dailyAverageUsage) * 365}">
						<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
					</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
			</table>
			</fieldset>
			
			
			
			
			
			
			
			<br />
			<h:outputText value = "Below is just a trial output"></h:outputText>
		</td></tr>
		<tr><td> 
			
		</td></tr>
		</table >
		
		
		<table class = "width" border = "1" align="center">
				<tr>
					<td> <h:outputText value = "Year"></h:outputText> </td> 
					<th> <h:outputText value = "2012"></h:outputText> </th> 
					<th> <h:outputText value = "2013"></h:outputText> </th>
					<th> <h:outputText value = "2014"></h:outputText> </th>
					<th> <h:outputText value = "2015"></h:outputText> </th>
					<th> <h:outputText value = "2016"></h:outputText> </th>
					<th> <h:outputText value = "2017"></h:outputText> </th>
					<th> <h:outputText value = "2018"></h:outputText> </th>
					<th> <h:outputText value = "2019"></h:outputText> </th>
					<th> <h:outputText value = "2020"></h:outputText> </th>
					<th> <h:outputText value = "2021"></h:outputText> </th>
				</tr>
				<tr>
					<td> <h:outputText value = "Tariff 11 Fee"></h:outputText> </td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[0]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
										<td>
						<h:outputText value= "#{result.tariff11Fees[1]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[2]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[3]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[4]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[5]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[6]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[7]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[8]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.tariff11Fees[9]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
				</tr>
				
				<tr>
					<td> <h:outputText value = "Average Daily Solar Generation"></h:outputText> </td>
					<td>
						<h:outputText value= "#{result.solarPowers[0]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
										<td>
						<h:outputText value= "#{result.solarPowers[1]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[2]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[3]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[4]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[5]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[6]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[7]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[8]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
					<td>
						<h:outputText value= "#{result.solarPowers[9]}">
							<f:convertNumber minFractionDigits="4" maxFractionDigits="4"/>
						</h:outputText>
					</td>
				</tr>
				
			</table>	
			
			
	</h:form>
	</f:view>
</body>
</html>