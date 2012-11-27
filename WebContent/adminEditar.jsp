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
	<f:subview id="adminEditView">
		<f:verbatim>
			<h2>Editando Usuário</h2>
		</f:verbatim>
		<h:form id="usrForm">
			<t:panelGrid id="usuarioGrid" columns="2">
				<t:panelGroup colspan="2" styleClass="msgContent">
					<h:message for="usrCPF" styleClass="error"/>
				</t:panelGroup>
				<t:panelGroup colspan="2" styleClass="msgContent">
					<h:message for="usrLogin" styleClass="error"/>
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Login:" for="usrLogin" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrLogin" value="#{adminEditarBean.usuario.login}" binding="#{login}" disabled="true"/>
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Senha:" for="usrSenha" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputSecret id="usrSenha" value="#{adminEditarBean.usuario.senha}" />
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Nome:" for="usrNome" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrNome" value="#{adminEditarBean.usuario.nome}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Endereço:" for="usrEndereco" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrEndereco" value="#{adminEditarBean.usuario.endereco}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Telefone:" for="usrTelefone" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrTelefone" value="#{adminEditarBean.usuario.telefone}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="CPF:" for="usrCPF" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrCPF" value="#{adminEditarBean.usuario.cpf}">
						<f:attribute name="login" value="#{login}"/>
						<f:validator validatorId="cpfValidator"/>
					</t:inputText>
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Data de Nascimento:" for="usrDataNasc" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputDate id="usrDataNasc" value="#{adminEditarBean.usuario.dataNascimento}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="CRM:" for="usrCRM" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrCRM" value="#{adminEditarBean.usuario.crm}" />
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Cargo:" for="usrCargo" />
				</t:panelGroup>
				<t:panelGroup>
					<t:selectOneMenu id="usrCargo" value="#{adminEditarBean.usuario.cargo}"
						converter="CargoConverter" >
						<f:selectItems value="#{adminEditarBean.listaCargos}" var="cargo" itemLabel="#{cargo.nome}"/>
					</t:selectOneMenu>
				</t:panelGroup>
			</t:panelGrid>
			<t:commandButton value="Salvar" action="#{adminEditarBean.salvarUsuario}" />
		</h:form>
		<h:form id="cancelForm">
			<t:commandButton value="Cancelar" action="#{adminEditarBean.cancelarEdicao}" />
		</h:form>

	</f:subview>
</body>
</html>