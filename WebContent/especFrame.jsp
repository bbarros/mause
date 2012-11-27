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
	<link rel="stylesheet" href="./css/styles.css" media="all" type="text/css" />	
	<link rel="stylesheet" href="./css/messages.css" media="all" type="text/css" />	
	<title>Insert title here</title>
</head>
<body>
<f:view>
	<div id="header">
	  <div class="subContainer">
	    <div id="logo">
	      <div id="box"><img src="images/logo.png" /></div>
	    </div> <!-- /logo -->
	    <div id="logout">
	    	<h:form>
		    	<h:commandLink action="#{especFrameBean.logout}" >
		    		<h:outputText value="Logout"></h:outputText>
		    	</h:commandLink>
	    	</h:form>
	    </div> <!-- logout -->	    
	  </div> <!-- /subContainer -->
	</div> <!-- header -->
	
	<div id="navigation">
	  	<a4j:form id="tabsForm">
			<ul>
			    <li>
			    	<a4j:commandLink action="#{especFrameBean.showDoenca}" reRender="primaryPanel">
			    		<h:outputText value="Doenças"></h:outputText>
			    	</a4j:commandLink>
			    </li>
			    <li>
			    	<a4j:commandLink action="#{especFrameBean.showSintoma}" reRender="primaryPanel">
			    		<h:outputText value="Sintomas"></h:outputText>
			    	</a4j:commandLink>
			    </li>
			  </ul>
	  	</a4j:form>
	</div>
	<!-- /navigation -->
	<div id="container">
	  <div id="primaryContent">
	  	<rich:panel id="primaryPanel">
			<a4j:include viewId="/doencaInicial.jsp" rendered="#{especFrameBean.doencaIsVisible}"/>
			<a4j:include viewId="/sintomaInicial.jsp" rendered="#{especFrameBean.sintomaIsVisible}"/>
	  	</rich:panel>
	  </div> <!-- /primaryContent -->
	  <br class="clear" />
	</div> <!-- container -->
	<div id="footer">
		</br>
	</div> <!-- /footer -->

</f:view>
</body>
</html>