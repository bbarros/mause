package com.mause.bean.admin;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class AdminFrameBean {
	private boolean usuarioIsVisible = true;

	public boolean isUsuarioIsVisible() {
		return usuarioIsVisible;
	}

	public void setUsuarioIsVisible(boolean usuarioIsVisible) {
		this.usuarioIsVisible = usuarioIsVisible;
	}
	
	public void showUsuario() {
		this.usuarioIsVisible = true;
	}
	
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	    session.invalidate();
	    return "logout";
	}
}
