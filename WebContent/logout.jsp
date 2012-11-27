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
			</br></br>
			<span class="success">Sua sessão foi encerrada com sucesso!</span>
		</f:verbatim>
		<h:form id="logoutForm">
			</br></br>
			<h:commandButton value="Voltar à Pagina Inicial" action="#{logoutBean.voltarInicio}" />
		</h:form>
		<f:verbatim>
		</f:verbatim>
	</f:view>
</body>
</html>