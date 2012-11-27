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
	<f:subview id="medAgendaView">
		<f:verbatim>
			<h2>Agenda de Consultas</h2>
		</f:verbatim>
		<t:div styleClass="msgContent" rendered="#{empty medicoBean.agenda}">
			<span class="info">Não existem consultas pendentes!</span> 
		</t:div>
		<t:dataTable id="tabelaAgenda" forceId="true" styleClass="table"
			value="#{medicoBean.agenda}" var="agendamento" rendered="#{not empty medicoBean.agenda}">
			
			<t:column id="dataHora">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Med.Inicial.TableHeader.DataHora']}" />
				</f:facet>
				<h:outputText value="#{agendamento.dataHora}" >
					<f:convertDateTime dateStyle="medium" timeZone="EST" type="both" />
				</h:outputText>
			</t:column>
			<t:column id="paciente">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Med.Inicial.TableHeader.Paciente']}" />
				</f:facet>
				<t:outputText value="#{agendamento.paciente.nome}" />
			</t:column>
			<t:column id="medico">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Med.Inicial.TableHeader.Medico']}" />
				</f:facet>
				<t:outputText value="#{agendamento.medico.nome}" />
			</t:column>				
<			<t:column id="panelPresente">
				<f:facet name="header">
					<t:outputText value="Paciente" />
				</f:facet>
				<t:div styleClass="msgContent" rendered="#{!agendamento.presente}">
					<span class="error">Ausente</span> 
				</t:div>
				<t:div styleClass="msgContent" rendered="#{agendamento.presente}">
					<span class="success">Presente</span> 
				</t:div>
			</t:column>								
 			<t:column id="command">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Med.Inicial.TableHeader.Command']}" />
				</f:facet>
				<h:form id="submitForm">
					<t:commandButton value="Iniciar" action="#{medicoBean.iniciarConsulta}" disabled="#{!agendamento.presente}">
						<f:setPropertyActionListener value="#{agendamento}" target="#{medicoBean.agendamento}"/>
					</t:commandButton>
				</h:form>
			</t:column>
		</t:dataTable>
	</f:subview>
</body>
</html>