<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:subview id="medConfirmView">
		<f:verbatim>
			<h2>Resumo da Consulta</h2>
		</f:verbatim>
		<div class="msgContent">
			<span class="success">Consulta Finalizada com Sucesso!</span>
		</div>
		<t:panelGrid columns="2">
			<t:panelGroup>
				<t:outputLabel value="Médico:" />
			</t:panelGroup>
			<t:panelGroup>
				<t:outputText value="#{medConfirmacaoBean.consulta.medico.nome}" />
			</t:panelGroup>
			<t:panelGroup>
				<t:outputLabel value="Paciente:" />
			</t:panelGroup>
			<t:panelGroup>
				<t:outputText value="#{medConfirmacaoBean.consulta.paciente.nome}" />
			</t:panelGroup>
			<t:panelGroup>
				<t:outputLabel value="Sintomas:" />
			</t:panelGroup>
			<t:panelGroup>
				<t:dataList var="sint" value="#{medConfirmacaoBean.consulta.sintomas}">
					<t:outputText value="#{sint.nome}" />
				</t:dataList>
			</t:panelGroup>
			<t:panelGroup>
				<t:outputLabel value="Diagnóstico:" />
			</t:panelGroup>
			<t:panelGroup>
				<t:dataList var="diag" value="#{medConfirmacaoBean.consulta.diagnostico}">
					<t:outputText value="#{diag.nome}" />
				</t:dataList>
			</t:panelGroup>
			<t:panelGroup>
				<t:outputLabel value="Receitas:" />
			</t:panelGroup>
			<t:dataTable styleClass="table" 
				var="receita" value="#{medConfirmacaoBean.consulta.receitas}">
				<t:column>
					<f:facet name="header">
						<t:outputText>Receita</t:outputText>
					</f:facet>
					<t:outputText value="#{receita.id}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<t:outputText>Exames</t:outputText>
					</f:facet>
					<t:outputText value="#{receita.exames}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<t:outputText>Medicamentos</t:outputText>
					</f:facet>
					<t:outputText value="#{receita.medicamentos}" />
				</t:column>					
			</t:dataTable>
			<t:panelGroup>
				<t:outputLabel value="Observações:" />
			</t:panelGroup>
			<t:panelGroup>
				<t:outputText value="#{medConfirmacaoBean.consulta.obs}" />
			</t:panelGroup>
		</t:panelGrid>
		<h:form>
			<t:commandButton value="Voltar para Tela Inicial" action="#{medConfirmacaoBean.concluir}" />
		</h:form>
	</f:subview>
</body>
</html>