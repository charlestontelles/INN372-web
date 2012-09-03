<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
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
					<td class="right"><h:outputText value="#{calculator.solarPower}">
							<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
						</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
				<tr>
					<td><h:outputText value="Quarterly:"></h:outputText></td>
					<td class="right"><h:outputText value="#{calculator.solarPower * 91}">
							<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
						</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
				<tr>
					<td><h:outputText value="Annually:"></h:outputText></td>
					<td class="right"><h:outputText value="#{calculator.solarPower * 365}">
							<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
						</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
				<tr><td></td><td></td></tr>
				<tr>
					<td><h:outputText value="Daily Net:"></h:outputText></td>
					<td class="right"><h:outputText value="#{calculator.solarPower - electricityUsage.dailyAverageUsage}">
						<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
					</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
							<tr>
					<td><h:outputText value="Quarterly Net:"></h:outputText></td>
					<td class="right"><h:outputText value="#{(calculator.solarPower - electricityUsage.dailyAverageUsage) * 91}">
						<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
					</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
							<tr>
					<td><h:outputText value="Annual Net:"></h:outputText></td>
					<td class="right"><h:outputText value="#{(calculator.solarPower - electricityUsage.dailyAverageUsage) * 365}">
						<f:convertNumber minFractionDigits="2" maxFractionDigits="2"/>
					</h:outputText></td>
					<td class="right"><h:outputText value="KWh"></h:outputText></td>
				</tr>
			</table>
			</fieldset>
		</td></tr>
		</table>
	</h:form>
	</f:view>
</body>
</html>