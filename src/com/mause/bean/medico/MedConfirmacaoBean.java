package com.mause.bean.medico;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.mause.model.Consulta;

public class MedConfirmacaoBean {
	private Consulta consulta;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	public String concluir() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    Map map = externalContext.getSessionMap();
	    map.remove("medConsultaBean");
	    map.remove("medConfirmacaoBean");
		return "concluir";
	}
}
