package com.mause.bean.medico;

import java.util.List;

import com.mause.model.Doenca;
import com.mause.model.Sintoma;

public class MedDetalheDoencaBean {
	private Doenca doenca;
	private List<Sintoma> doencaSintomas;

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

	public String retornar() {
		return "retornar";
	}

}
