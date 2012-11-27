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
	<f:subview id="adminAddView">
		<f:verbatim>
			<h2>Editando Usuário</h2>
		</f:verbatim>
		<h:form id="usrForm">
			<t:panelGrid id="usuarioGrid" columns="2">
				<t:panelGroup colspan="2" styleClass="msgContent">
					<h:message for="usrCPF" styleClass="error" />
				</t:panelGroup>
				<t:panelGroup colspan="2" styleClass="msgContent">
					<h:message for="usrLogin" styleClass="error" />
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Login:" for="usrLogin" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrLogin" value="#{adminAdicionarBean.usuario.login}"  binding="#{login}">
						<f:validator validatorId="usernameValidator"/>
					</t:inputText>
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Senha:" for="usrSenha" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputSecret id="usrSenha" value="#{adminAdicionarBean.usuario.senha}" />
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Nome:" for="usrNome" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrNome" value="#{adminAdicionarBean.usuario.nome}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Endereço:" for="usrEndereco" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrEndereco" value="#{adminAdicionarBean.usuario.endereco}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="Telefone:" for="usrTelefone" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrTelefone" value="#{adminAdicionarBean.usuario.telefone}" />
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="CPF:" for="usrCPF" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrCPF" value="#{adminAdicionarBean.usuario.cpf}">
						<f:attribute name="login" value="#{login}"/>
						<f:validator validatorId="cpfValidator"/>
					</t:inputText>
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Data de Nascimento:" for="usrDataNasc" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputDate id="usrDataNasc" value="#{adminAdicionarBean.usuario.dataNascimento}" />
				</t:panelGroup>	
				<t:panelGroup>
					<t:outputLabel value="CRM:" for="usrCRM" />
				</t:panelGroup>
				<t:panelGroup>
					<t:inputText id="usrCRM" value="#{adminAdicionarBean.usuario.crm}" />
				</t:panelGroup>
				<t:panelGroup>
					<t:outputLabel value="Cargo:" for="usrCargo" />
				</t:panelGroup>
				<t:panelGroup>
					<t:selectOneMenu id="usrCargo" value="#{adminAdicionarBean.usuario.cargo}"
						converter="CargoConverter" >
						<f:selectItems value="#{adminAdicionarBean.listaCargos}" var="cargo" itemLabel="#{cargo.nome}"/>
					</t:selectOneMenu>
				</t:panelGroup>
			</t:panelGrid>
			<t:commandButton value="Salvar" action="#{adminAdicionarBean.salvarUsuario}" />
		</h:form>
		<h:form id="cancelForm">
			<t:commandButton value="Cancelar" action="#{adminAdicionarBean.cancelarAdicao}" />
		</h:form>

	</f:subview>
</body>
</html>