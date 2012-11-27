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
	<f:subview id="doencaEditView">
		<f:verbatim>
			<h2>Editando Doença</h2>
		</f:verbatim>
		<h:form id="doencaForm">
			<t:panelGrid id="doencaGrid" columns="2">
				<t:panelGroup>
					<t:outputLabel value="CID:" for="doencaCid" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="doencaCid" value="#{doencaEditarBean.doenca.cid}" disabled="true"/>
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Nome:" for="usrNome" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrNome" value="#{doencaEditarBean.doenca.nome}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Nome Científico:" for="doencaNC" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="doencaNC" value="#{doencaEditarBean.doenca.nomeCientifico}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Tratamento:" for="doencaTrat" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputTextarea id="doencaTrat" value="#{doencaEditarBean.doenca.tratamento}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Sintomas:" for="doencaSint" />
				</t:panelGroup>
				<t:panelGroup colspan="2">
 					<h:form id="listForm">
	 					<rich:listShuttle sourceValue="#{doencaEditarBean.listaSintomas}"
							targetValue="#{doencaEditarBean.doencaSintomas}"
							var="sintoma" converter="SintomaConverter"
							topControlLabel="Primeiro" bottomControlLabel="Último"
							upControlLabel="Para Cima" downControlLabel="Para Baixo"
							copyAllControlLabel="Incluir Todos" removeAllControlLabel="Remover Todos"
							copyControlLabel="Incluir" removeControlLabel="Remover"
							styleClass="richButton">
							<rich:column>
								<h:outputText value="#{sintoma.nome}" />
							</rich:column>
						</rich:listShuttle>
 					</h:form>
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Descrição:" for="doencaDesc" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputTextarea id="doencaDesc" value="#{doencaEditarBean.doenca.desc}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Referências:" for="doencaRef" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputTextarea  id="doencaRef" value="#{doencaEditarBean.doenca.ref}" />
				</t:panelGroup>	
			</t:panelGrid>
			<t:commandButton value="Salvar" action="#{doencaEditarBean.salvarDoenca}" />
		</h:form>
		<h:form id="cancelForm">
			<t:commandButton value="Cancelar" action="#{doencaEditarBean.cancelarEdicao}" />
		</h:form>

	</f:subview>
</body>
</html>