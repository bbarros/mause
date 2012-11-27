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
			<h2>Base de Sintomas</h2>
		</f:verbatim>
		<t:dataTable id="tabelaUsuarios" forceId="true" styleClass="table"
			value="#{medSintomaBean.listaSintomas}" var="sintoma">			
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
			<t:column id="command">
				<f:facet name="header">
					<t:outputText value="Visualizar" />
				</f:facet>
				<h:form id="submit">
					<t:commandButton value="Detalhes" action="#{medSintomaBean.visualizarSintoma}">
						<f:setPropertyActionListener value="#{sintoma}" target="#{medSintomaBean.sintoma}"/>
					</t:commandButton>
				</h:form>
			</t:column>				
		</t:dataTable>		
	</f:subview>
</body>
</html>