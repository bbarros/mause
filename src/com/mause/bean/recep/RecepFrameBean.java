package com.mause.bean.recep;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class RecepFrameBean {
	private boolean agendaVisible = true;
	private boolean pacienteVisible = false;

	public boolean isAgendaVisible() {
		return agendaVisible;
	}

	public void setAgendaVisible(boolean agendaVisible) {
		this.agendaVisible = agendaVisible;
	}
	
	public boolean isPacienteVisible() {
		return pacienteVisible;
	}

	public void setPacienteVisible(boolean pacienteVisible) {
		this.pacienteVisible = pacienteVisible;
	}

	public void showAgenda() {
		this.pacienteVisible = false;
		this.agendaVisible = true;
	}
	
	public void showPaciente() {
		this.agendaVisible = false;
		this.pacienteVisible = true;
	}
	
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	    session.invalidate();
	    return "logout";
	}

}
