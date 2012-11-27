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
	<f:subview id="recepPacienteView">
		<f:verbatim>
			<h2>Gerenciamento de Pacientes</h2>
		</f:verbatim>
		<h:form id="addFormHeader">
			<t:commandButton value="Adicionar Novo Paciente" action="#{recepPacBean.adicionarPaciente}" />
		</h:form>
		<t:dataTable id="tabelaPacientes" forceId="true" styleClass="table"
			value="#{recepPacBean.pacientes}" var="paciente">			
			<t:column id="nome">
				<f:facet name="header">
					<t:outputText value="Nome" />
				</f:facet>
				<t:outputText value="#{paciente.nome}" />
			</t:column>
			<t:column id="endereco">
				<f:facet name="header">
					<t:outputText value="Endereço" />
				</f:facet>
				<t:outputText value="#{paciente.endereco}" />
			</t:column>
			<t:column id="telefone">
				<f:facet name="header">
					<t:outputText value="Telefone" />
				</f:facet>
				<t:outputText value="#{paciente.telefone}" />
			</t:column>				
			<t:column id="cpf">
				<f:facet name="header">
					<t:outputText value="CPF" />
				</f:facet>
				<t:outputText value="#{paciente.cpf}" />
			</t:column>				
			<t:column id="dataNascimento">
				<f:facet name="header">
					<t:outputText value="Data de Nascimento" />
				</f:facet>
				<t:outputText value="#{paciente.dataNascimento}" />
			</t:column>				
			<t:column id="commandEditar">
				<f:facet name="header">
					<t:outputText value="Editar" />
				</f:facet>
				<h:form id="submitEditar">
					<t:commandButton styleClass="imgButton" image="./images/editButton.png" action="#{recepPacBean.editarPaciente}">
						<f:setPropertyActionListener value="#{paciente}" target="#{recepPacBean.pac}"/>
					</t:commandButton>
				</h:form>
			</t:column>				
			<t:column id="commandExcluir">
				<f:facet name="header">
					<t:outputText value="Excluir" />
				</f:facet>
				<h:form id="submitExcluir">
					<t:commandButton styleClass="imgButton" image="./images/delButton.png" action="#{recepPacBean.excluirPaciente}">
						<f:setPropertyActionListener value="#{paciente}" target="#{recepPacBean.pac}"/>
					</t:commandButton>
				</h:form>
			</t:column>				
		</t:dataTable>		
		<h:form id="addFormFooter">
			<t:commandButton value="Adicionar Novo Paciente" action="#{recepPacBean.adicionarPaciente}" />
		</h:form>
	</f:subview>
</body>
</html>