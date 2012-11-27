package com.mause.bean.espec;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class EspecFrameBean {
	private boolean doencaIsVisible = true;
	private boolean sintomaIsVisible = false;
	private boolean outraIsVisible = false;

	
	public boolean isDoencaIsVisible() {
		return doencaIsVisible;
	}
	
	public void setDoencaIsVisible(boolean doencaIsVisible) {
		this.doencaIsVisible = doencaIsVisible;
	}
	
	public boolean isSintomaIsVisible() {
		return sintomaIsVisible;
	}
	
	public void setSintomaIsVisible(boolean sintomaIsVisible) {
		this.sintomaIsVisible = sintomaIsVisible;
	}
	
	public boolean isOutraIsVisible() {
		return outraIsVisible;
	}
	
	public void setOutraIsVisible(boolean outraIsVisible) {
		this.outraIsVisible = outraIsVisible;
	}
	
	public void showDoenca() {
		this.sintomaIsVisible = false;
		this.outraIsVisible = false;
		this.doencaIsVisible = true;
	}

	public void showSintoma() {
		this.outraIsVisible = false;
		this.doencaIsVisible = false;
		this.sintomaIsVisible = true;
	}

	public void showOutra() {
		this.doencaIsVisible = false;
		this.sintomaIsVisible = false;
		this.outraIsVisible = true;
	}

	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	    session.invalidate();
	    return "logout";
	}
}
