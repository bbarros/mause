package com.mause.bean.medico;

import java.util.List;

import com.mause.model.Sintoma;

public class MedSintomaBean {
	private List<Sintoma> listaSintomas;
	private Sintoma	sintoma;

	public List<Sintoma> getListaSintomas() {
		return listaSintomas;
	}

	public void setListaSintomas(List<Sintoma> listaSintomas) {
		this.listaSintomas = listaSintomas;
	}

	public Sintoma getSintoma() {
		return sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}

	public String visualizarSintoma() {
		return "visualizar";
	}
}
