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
	<f:subview id="recepInitView">
		<f:verbatim>
			<h2>Consultas Médicas</h2>
		</f:verbatim>
		<t:dataTable id="tabelaAgenda" forceId="true" styleClass="table"
			value="#{recepBean.agenda}" var="agendamento">
			
			<t:column id="dataHora">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Recep.Inicial.TableHeader.DataHora']}" />
				</f:facet>
				<t:outputText value="#{agendamento.dataHora}" >
					<f:convertDateTime dateStyle="medium" timeZone="EST" type="both" />
				</t:outputText>
			</t:column>
			<t:column id="paciente">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Recep.Inicial.TableHeader.Paciente']}" />
				</f:facet>
				<t:outputText value="#{agendamento.paciente.nome}" />
			</t:column>
			<t:column id="medico">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Recep.Inicial.TableHeader.Medico']}" />
				</f:facet>
				<t:outputText value="#{agendamento.medico.nome}" />
			</t:column>				
			<t:column id="command">
				<f:facet name="header">
					<t:outputText value="#{AppMsg['Recep.Inicial.TableHeader.Command']}" />
				</f:facet>
				<h:form id="deleteForm">
					<t:commandButton value="Demarcar" action="#{recepBean.desmarcarConsulta}">
						<f:setPropertyActionListener value="#{agendamento}" target="#{recepBean.agendamento}"/>
					</t:commandButton>
				</h:form>
			</t:column>				
			<t:column id="commandPresente">
				<f:facet name="header">
					<t:outputText value="Presente" />
				</f:facet>
				<h:form id="presencaForm">
					<t:commandButton styleClass="imgButton" image="./images/error.png" rendered="#{!agendamento.presente}"
						value="Presente" action="#{recepBean.marcarPresenca}">
						<f:setPropertyActionListener value="#{agendamento}" target="#{recepBean.agendamento}"/>
					</t:commandButton>
					<t:commandButton styleClass="imgButton" image="./images/success.png" rendered="#{agendamento.presente}"
						value="Presente" action="#{recepBean.desmarcarPresenca}">
						<f:setPropertyActionListener value="#{agendamento}" target="#{recepBean.agendamento}"/>
					</t:commandButton>
				</h:form>
			</t:column>	
		</t:dataTable>
	</f:subview>
</body>
</html>