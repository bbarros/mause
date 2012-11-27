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
	<f:subview id="recepEditView">
		<f:verbatim>
			<h2>Editando Paciente</h2>
		</f:verbatim>
		<h:form id="pacForm">
			<t:panelGrid id="pacienteGrid" columns="2">
				<t:panelGroup>
					<t:outputLabel value="Nome:" for="pacNome" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="pacNome" value="#{recepEditarBean.paciente.nome}"/>
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Endereço:" for="pacEndereco" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="pacEndereco" value="#{recepEditarBean.paciente.endereco}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Telefone:" for="pacTelefone" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="pacTelefone" value="#{recepEditarBean.paciente.telefone}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="CPF:" for="pacCPF" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="pacCPF" value="#{recepEditarBean.paciente.cpf}" disabled="true">
					</t:inputText>
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Data de Nascimento:" for="pacDataNasc" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputDate id="pacDataNasc" value="#{recepEditarBean.paciente.dataNascimento}" />
				</t:panelGroup>	
			</t:panelGrid>
			<t:commandButton value="Salvar" action="#{recepEditarBean.salvarPaciente}" />
		</h:form>
		<h:form id="cancelForm">
			<t:commandButton value="Cancelar" action="#{recepEditarBean.cancelarEdicao}" />
		</h:form>

	</f:subview>
</body>
</html>