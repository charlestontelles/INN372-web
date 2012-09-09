<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    	<h3 align = "center"> Average Solar Power Generation (KWh)</h3>
    	
		<br />
		
	   	<table class = "width" align="center">
	    	<tr>
	    		<td> <h:outputText value ="Year"> </h:outputText></td>
				<c:forEach var="i" begin="0" end="24"> 
	    			<th><c:out value="${2012+i}"/></th>
	    		</c:forEach>
	    	</tr>
	    	<tr>
	    		<td> <h:outputText value ="Tariff 11 Fee ($)"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<!-- <td><c:out value="${result.tariff11Fees[i]}"/></td> -->
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.tariff11Fees[i]}"/></td>
	    		</c:forEach>
	    	</tr>
	    	<tr><td> <h:outputText value ="Daily"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.solarPowers[i]}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Quarter"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.solarPowers[i]*91}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Annual"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.solarPowers[i]*365}"/></td>
	    		</c:forEach>
	    	</tr>

	    	<tr><td> <h:outputText value ="Daily Net"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.solarPowers[i] - electricityUsage.dailyAverageUsage}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Quarter Net"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${(result.solarPowers[i] - electricityUsage.dailyAverageUsage)*91}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Annual Net"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${(result.solarPowers[i] - electricityUsage.dailyAverageUsage)*365}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Replacement Generation"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.replacementGeneration[i]}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Exported Generation"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.exportedGeneration[i]}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Daily Savings"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.dailySavings[i]}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<tr><td> <h:outputText value ="Annual Savings"> </h:outputText></td>
	    		<c:forEach var="i" begin="0" end="24"> 
	    			<td> <fmt:formatNumber type="number" groupingUsed="true" value="${result.dailySavings[i] * 365}"/></td>
	    		</c:forEach>
	    	</tr>
	    	
	    	<!--<c:forEach var="i" begin="0" end="24"> 
	    		<c:set var="paybackSavings" scope="session" value="${result.dailySavings[i] * 365}"/>
				<c:if test="${paybackSavings > equipment.cost}">
   					<h:outputText value="Payback Period:"></h:outputText>	 
   					<c:out value="${i+1}"/><p>
				</c:if>
	    	</c:forEach>-->
		</table>	
	</h:form>
	</f:view>
</body>
</html>