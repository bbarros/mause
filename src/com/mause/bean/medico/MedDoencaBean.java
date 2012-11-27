package com.mause.bean.medico;

import java.util.ArrayList;
import java.util.List;

import com.mause.model.Doenca;
import com.mause.model.Sintoma;

public class MedDoencaBean {
	private List<Doenca> listaDoencas;
	private Doenca doenca;
	private List<Sintoma> doencaSintomas;

	public List<Doenca> getListaDoencas() {
		return listaDoencas;
	}

	public void setListaDoencas(List<Doenca> listaDoencas) {
		this.listaDoencas = listaDoencas;
	}

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}
	
	public List<Sintoma> getDoencaSintomas() {
		return doencaSintomas;
	}

	public void setDoencaSintomas(List<Sintoma> doencaSintomas) {
		this.doencaSintomas = doencaSintomas;
	}

	public String visualizarDoenca() {
		this.doencaSintomas = new ArrayList<Sintoma>();
		this.doencaSintomas.addAll(this.doenca.getSintomas());
		return "visualizar";
	}
}
