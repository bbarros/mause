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
	<f:subview id="medConsultaView">
		<f:verbatim>
			<h2>Dados da Consulta</h2>
		</f:verbatim>
		<t:panelGrid id="consultaGrid" columns="2">
			<t:panelGroup colspan="2">
				<rich:panel>
			        <f:facet name="header">
			        	<t:outputText value="Dados do Médico" />
			        </f:facet>
					<t:outputText>Nome do Médico: </t:outputText>
					<t:outputText value="#{medConsultaBean.consulta.medico.nome}" />
				</rich:panel>
			</t:panelGroup>
			<t:panelGroup colspan="2">
				<rich:panel>
			        <f:facet name="header">
			        	<t:outputText value="Dados do Paciente" />
			        </f:facet>
					<t:outputText>Nome do Paciente: </t:outputText>
					<t:outputText value="#{medConsultaBean.consulta.paciente.nome}" />
				</rich:panel>
			</t:panelGroup>

			<t:panelGroup colspan="2">
				<rich:panel>
			        <f:facet name="header">
			        	<t:outputText value="Sintomas" />
			        </f:facet>
					<a4j:form id="sintomaForm">
	 					<rich:listShuttle sourceValue="#{medConsultaBean.sintomas}"
							targetValue="#{medConsultaBean.sintomasSel}"
							var="sintoma" converter="SintomaConverter"
							topControlLabel="Primeiro" bottomControlLabel="Último"
							upControlLabel="Para Cima" downControlLabel="Para Baixo"
							copyAllControlLabel="Incluir Todos" removeAllControlLabel="Remover Todos"
							copyControlLabel="Incluir" removeControlLabel="Remover"
							styleClass="richButton">
							<rich:column>
								<h:outputText value="#{sintoma.nome}" />
							</rich:column>
							<a4j:support event="onlistchanged" />
            				<a4j:support event="onorderchanged" />
						</rich:listShuttle>
						<a4j:commandButton value="Sugerir Diagnóstico" reRender="tabelaSugestoes"
							action="#{medConsultaBean.gerarDiagnostico}" />
					</a4j:form>
				</rich:panel>
			</t:panelGroup>			

 			<t:panelGroup id="tabelaSugestoes" colspan="2">
				<rich:panel rendered="#{not empty medConsultaBean.autoDiagnostico}">
			        <f:facet name="header">
			        	<t:outputText value="Sugestões de Diagnóstico" />
			        </f:facet>
	        		<t:dataTable styleClass="table tablePanel"
						value="#{medConsultaBean.autoDiagnostico}" var="sugestao">			
						<t:column id="diagCid">
							<f:facet name="header">
								<t:outputText value="CID" />
							</f:facet>
							<t:outputText value="#{sugestao.cid}" />
						</t:column>
						<t:column id="diagNome">
							<f:facet name="header">
								<t:outputText value="Nome" />
							</f:facet>
							<t:outputText value="#{sugestao.nome}" />
						</t:column>
						<t:column id="commandAceitar">
							<f:facet name="header">
								<t:outputText value="Aceitar" />
							</f:facet>
							<a4j:form id="submitAceitar">
								<a4j:commandButton value="Aceitar" reRender="tabelaDiagnosticos"
									action="#{medConsultaBean.aceitarDiagnostico}">
									<f:setPropertyActionListener value="#{sugestao}" target="#{medConsultaBean.diagItem}"/>
								</a4j:commandButton>
							</a4j:form>
						</t:column>				
			        </t:dataTable>
				</rich:panel>
			</t:panelGroup>
			
			<t:panelGroup id="tabelaDiagnosticos" colspan="2">
				<rich:panel>
			        <f:facet name="header">
			        	<t:outputText value="Diagnósticos" />
			        </f:facet>
	        		<t:dataTable styleClass="table tablePanel"  rendered="#{not empty medConsultaBean.doencasSel}"
						value="#{medConsultaBean.doencasSel}" var="diagnostico">			
						<t:column id="diagCid">
							<f:facet name="header">
								<t:outputText value="CID" />
							</f:facet>
							<t:outputText value="#{diagnostico.cid}" />
						</t:column>
						<t:column id="diagNome">
							<f:facet name="header">
								<t:outputText value="Nome" />
							</f:facet>
							<t:outputText value="#{diagnostico.nome}" />
						</t:column>
						<t:column id="commandExcluirDiag">
							<f:facet name="header">
								<t:outputText value="Excluir" />
							</f:facet>
							<a4j:form id="submitExcluir">
								<a4j:commandButton value="Excluir" reRender="tabelaDiagnosticos"
									action="#{medConsultaBean.excluirDiagnostico}">
									<f:setPropertyActionListener value="#{diagnostico}" target="#{medConsultaBean.diagItem}"/>
								</a4j:commandButton>
							</a4j:form>
						</t:column>				
			        </t:dataTable>
			        <a4j:form id="editarDiagForm">
					    <a4j:commandButton id="commandDiag" value="Editar Diagnóstico" reRender="modalDiag"
					    	action="#{medConsultaBean.editarDiagnostico}" oncomplete="#{rich:component('modalDiag')}.show()">
		    			</a4j:commandButton>							
			        </a4j:form>				        
				</rich:panel>
			</t:panelGroup>
			
 			<t:panelGroup colspan="2">
			 	<rich:modalPanel id="modalDiag"  width="550" height="300">
			        <f:facet name="header">
			            <h:panelGroup>
			                <h:outputText value="Editar Diagnóstico" ></h:outputText>
			            </h:panelGroup>
			        </f:facet>
			        <f:facet name="controls">
			            <h:panelGroup>
			                <h:graphicImage value="./images/close.png" id="closeModal"/>
			                <rich:componentControl for="modalDiag" attachTo="closeModal" operation="hide" event="onclick"/>
			            </h:panelGroup>
			        </f:facet>
			        <f:verbatim><h2>Diagnóstico</h2></f:verbatim>
		        	<a4j:form id="editDiagForm">
	 					<rich:listShuttle sourceValue="#{medConsultaBean.doencasNaoSel}"
							targetValue="#{medConsultaBean.doencasSel}"
							var="doenca" converter="DoencaConverter"
							topControlLabel="Primeiro" bottomControlLabel="Último"
							upControlLabel="Para Cima" downControlLabel="Para Baixo"
							copyAllControlLabel="Incluir Todos" removeAllControlLabel="Remover Todos"
							copyControlLabel="Incluir" removeControlLabel="Remover"
							styleClass="richButton">
							<rich:column>
								<h:outputText value="#{doenca.nome}" />
							</rich:column>
						</rich:listShuttle>
					    <a4j:commandButton id="commandEditarDiag" value="Salvar" reRender="tabelaDiagnosticos">
					   		<rich:componentControl for="modalDiag" attachTo="commandEditarDiag" operation="hide" event="onclick"/>
		    			</a4j:commandButton>							
		        	</a4j:form>
			    </rich:modalPanel>
			</t:panelGroup>			

			<t:panelGroup id="tabelaReituario" colspan="2">
				<rich:panel>
			        <f:facet name="header">
			        	<t:outputText value="Receituário" />
			        </f:facet>
	        		<t:dataTable styleClass="table tablePanel" rendered="#{not empty medConsultaBean.receituario}"
						value="#{medConsultaBean.receituario}" var="receita">			
						<t:column id="diagCid">
							<f:facet name="header">
								<t:outputText value="Exames" />
							</f:facet>
							<t:outputText value="#{receita.exames}" />
						</t:column>
						<t:column id="diagNome">
							<f:facet name="header">
								<t:outputText value="Medicamentos" />
							</f:facet>
							<t:outputText value="#{receita.medicamentos}" />
						</t:column>
						<t:column id="commandEditarReceita">
							<f:facet name="header">
								<t:outputText value="Editar" />
							</f:facet>
					        <a4j:form id="submitEditarReceita">
							    <a4j:commandButton id="commandEditarReceita" value="Editar" reRender="modalReceita"
							    	oncomplete="#{rich:component('modalReceita')}.show()">
									<f:setPropertyActionListener value="#{receita}" target="#{medConsultaBean.receita}"/>
									<f:setPropertyActionListener value="#{receita}" target="#{medConsultaBean.receitaEdit}"/>
				    			</a4j:commandButton>							
					        </a4j:form>
						</t:column>
						<t:column id="commandExcluirReceita">
							<f:facet name="header">
								<t:outputText value="Excluir" />
							</f:facet>
							<a4j:form id="submitExcluirReceita">
								<a4j:commandButton value="Excluir" reRender="tabelaReituario"
									action="#{medConsultaBean.excluirReceita}">
									<f:setPropertyActionListener value="#{receita}" target="#{medConsultaBean.receita}"/>
								</a4j:commandButton>
							</a4j:form>
						</t:column>				
			        </t:dataTable>
			        <a4j:form id="novaReceitaForm">
					    <a4j:commandButton id="commandReceita" value="Inserir Receita" reRender="modalReceita"
					    	action="#{medConsultaBean.novaReceita}" oncomplete="#{rich:component('modalReceita')}.show()">
		    			</a4j:commandButton>							
			        </a4j:form>
				</rich:panel>
			</t:panelGroup>

			<t:panelGroup colspan="2">
			 	<rich:modalPanel id="modalReceita" width="300" height="250">
			        <f:facet name="header">
			            <h:panelGroup>
			                <h:outputText value="Receita Médica"></h:outputText>
			            </h:panelGroup>
			        </f:facet>
			        <f:facet name="controls">
			            <h:panelGroup>
			                <h:graphicImage value="./images/close.png" id="closeModalReceita"/>
			                <rich:componentControl for="modalReceita" attachTo="closeModalReceita" operation="hide" event="onclick"/>
			            </h:panelGroup>
			        </f:facet>
			        <f:verbatim><h2>Receita</h2></f:verbatim>
		        	<a4j:form id="receitaForm">
				        <t:panelGrid id="receitaGrid" columns="2">
				        	<t:panelGroup>
				        		<t:outputLabel for="exames" value="Exames:" />			        	
				        	</t:panelGroup>
				        	<t:panelGroup>
				        		<t:inputTextarea id="exames" value="#{medConsultaBean.receita.exames}" />
				        	</t:panelGroup>
				        	<t:panelGroup>
				        		<t:outputLabel for="medicamentos" value="Medicamentos:" />			        	
				        	</t:panelGroup>
				        	<t:panelGroup>
				        		<t:inputTextarea id="medicamentos" value="#{medConsultaBean.receita.medicamentos}" />
				        	</t:panelGroup>
				        	<t:panelGroup>
				        		<t:outputLabel for="observacoes" value="Observações:" />			        	
				        	</t:panelGroup>
				        	<t:panelGroup>
				        		<t:inputTextarea id="observacoes" value="#{medConsultaBean.receita.obs}" />
				        	</t:panelGroup>
				        	<t:panelGroup colspan="2">
								<a4j:commandButton id="insereReceita" value="Confirmar" 
									action="#{medConsultaBean.salvarReceita}" reRender="tabelaReituario">
									<rich:componentControl for="modalReceita" attachTo="insereReceita" operation="hide" event="onclick"/>
								</a4j:commandButton>
				        	</t:panelGroup>
				        </t:panelGrid>
		        	</a4j:form>
			    </rich:modalPanel>
			</t:panelGroup>

			<t:panelGroup colspan="2">
				<a4j:form>
					<rich:panel>
				        <f:facet name="header">
				        	<t:outputText value="Observações Médicas" />
				        </f:facet>
						<t:outputLabel for="consultaObs" value="Observações: "/>
						<t:inputTextarea id="consultaObs" value="#{medConsultaBean.consulta.obs}">
							<a4j:support event="onchange" />
						</t:inputTextarea>
					</rich:panel>
				</a4j:form>
			</t:panelGroup>
			
			<t:panelGroup>
				<h:form>
					<h:commandButton value="Finalizar" action="#{medConsultaBean.salvarConsulta}" />
				</h:form>
			</t:panelGroup>
			<t:panelGroup>
				<h:form>
					<h:commandButton value="Cancelar" action="#{medConsultaBean.cancelarConsulta}" />
				</h:form>
			</t:panelGroup>

  		</t:panelGrid>
	</f:subview>
</body>
</html>