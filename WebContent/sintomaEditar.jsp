<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:subview id="sintomaEditView">
		<f:verbatim>
			<h2>Editando Sintoma</h2>
		</f:verbatim>
		<h:form id="sintomaForm">
			<t:panelGrid id="sintomaGrid" columns="2">
				<t:panelGroup>
					<t:outputLabel value="CID:" for="sintomaCid" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="sintomaCid" value="#{sintomaEditarBean.sintoma.sintomaCID}" disabled="true"/>
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Nome:" for="sintomaNome" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="sintomaNome" value="#{sintomaEditarBean.sintoma.nome}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Descrição:" for="sintomaDesc" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputTextarea id="sintomaDesc" value="#{sintomaEditarBean.sintoma.desc}" />
				</t:panelGroup>	
			</t:panelGrid>
			<t:commandButton value="Salvar" action="#{sintomaEditarBean.salvarSintoma}" />
		</h:form>
		<h:form id="cancelForm">
			<t:commandButton value="Cancelar" action="#{sintomaEditarBean.cancelarEdicao}" />
		</h:form>

	</f:subview>
</body>
</html>