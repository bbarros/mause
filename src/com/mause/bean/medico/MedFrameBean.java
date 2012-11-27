package com.mause.bean.medico;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class MedFrameBean {
	private boolean consultaIsVisible = true;
	private boolean doencasVisible = false;
	private boolean sintomasVisible = false;

	public boolean isConsultaIsVisible() {
		return consultaIsVisible;
	}

	public void setConsultaIsVisible(boolean consultaIsVisible) {
		this.consultaIsVisible = consultaIsVisible;
	}
	
	public boolean isDoencasVisible() {
		return doencasVisible;
	}

	public void setDoencasVisible(boolean doencasVisible) {
		this.doencasVisible = doencasVisible;
	}

	public boolean isSintomasVisible() {
		return sintomasVisible;
	}

	public void setSintomasVisible(boolean sintomasVisible) {
		this.sintomasVisible = sintomasVisible;
	}

	public void showConsulta() {
		this.doencasVisible = false;
		this.sintomasVisible = false;
		this.consultaIsVisible = true;
	}

	public void showDoencas() {
		this.doencasVisible = true;
		this.sintomasVisible = false;
		this.consultaIsVisible = false;
	}

	public void showSintomas() {
		this.doencasVisible = false;
		this.sintomasVisible = true;
		this.consultaIsVisible = false;
	}

	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	    session.invalidate();
	    return "logout";
	}

}
