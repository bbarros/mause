package com.mause.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionListener implements PhaseListener{

	private static final long serialVersionUID = 7462471043940736940L;

	@Override
	public void afterPhase(PhaseEvent event) {
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		HttpServletRequest request = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionValid") == null) {
			String viewID = facesContext.getViewRoot().getViewId().toString(); 
			if( viewID.matches(".*\\.jsp") && (viewID.compareTo("/login.jsp") != 0)) {
				NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
				nh.handleNavigation(facesContext, null, "logout");
			}
		}
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
