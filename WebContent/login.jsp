<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem Vindo ao Mause!</title>
<link href="./css/login.css" type="text/css" rel="stylesheet">
<link href="./css/messages.css" type="text/css" rel="stylesheet">
</head>
<body>
	<f:view>
		<f:verbatim>
			<div class="logoInicial">
				<img src="./images/logoInicial.png"/>
			</div>
			<div class="loginForm">
		</f:verbatim>
		<h:form id="loginForm">
			<t:panelGrid id="loginGrid" columns="2">
				<t:panelGroup>
					<t:outputLabel for="username">Username:</t:outputLabel>
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="username" forceId="true" value="#{loginBean.login}" binding="#{username}"/>
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel for="password">Password:</t:outputLabel>
				</t:panelGroup>
				<t:panelGroup>
					<t:inputSecret id="password" forceId="true" value="#{loginBean.password}" >
						<f:attribute name="username" value="#{username}"/>
						<f:validator validatorId="loginValidator"/>
					</t:inputSecret>
				</t:panelGroup>
				<t:panelGroup colspan="2">
					<t:commandButton value="Submit" action="#{loginBean.validateLogin}" />
				</t:panelGroup>
				<t:panelGroup colspan="2">
					</br>
					<h:message for="password" styleClass="error"/>								
				</t:panelGroup>
			</t:panelGrid>
		</h:form>
		<f:verbatim>
			</div>
		</f:verbatim>
	</f:view>
</body>
</html>