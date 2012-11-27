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
	<f:subview id="sintomaInitView">
		<f:verbatim>
			<h2>Gerenciamento de Sintomas</h2>
		</f:verbatim>
		<h:form id="addFormHeader">
			<t:commandButton styleClass="addButton" image="./images/addSintomas.png" value="Adicionar Novo Sintoma" action="#{sintomaBean.adicionarSintoma}" />
		</h:form>
		<t:dataTable id="tabelaUsuarios" forceId="true" styleClass="table"
			value="#{sintomaBean.listaSintomas}" var="sintoma">			
			<t:column id="cid">
				<f:facet name="header">
					<t:outputText value="CID" />
				</f:facet>
				<t:outputText value="#{sintoma.sintomaCID}" />
			</t:column>
			<t:column id="nome">
				<f:facet name="header">
					<t:outputText value="Nome" />
				</f:facet>
				<t:outputText value="#{sintoma.nome}" />
			</t:column>
			<t:column id="commandEditar">
				<f:facet name="header">
					<t:outputText value="Editar" />
				</f:facet>
				<h:form id="submitEditar">
					<t:commandButton styleClass="imgButton" image="./images/editButton.png" value="Editar" action="#{sintomaBean.editarSintoma}">
						<f:setPropertyActionListener value="#{sintoma}" target="#{sintomaBean.sintoma}"/>
					</t:commandButton>
				</h:form>
			</t:column>				
			<t:column id="commandExcluir">
				<f:facet name="header">
					<t:outputText value="Excluir" />
				</f:facet>
				<h:form id="submitExcluir">
					<t:commandButton styleClass="imgButton" image="./images/delButton.png" value="Excluir" action="#{sintomaBean.excluirSintoma}">
						<f:setPropertyActionListener value="#{sintoma}" target="#{sintomaBean.sintoma}"/>
					</t:commandButton>
				</h:form>
			</t:column>				
		</t:dataTable>		
		<h:form id="addFormFooter">
			<t:commandButton styleClass="addButton" image="./images/addSintomas.png" value="Adicionar Novo Sintoma" action="#{sintomaBean.adicionarSintoma}" />
		</h:form>
	</f:subview>
</body>
</html>