package com.mause.bean.medico;

import com.mause.model.Sintoma;

public class MedDetalheSintomaBean {
	private Sintoma sintoma;

	public Sintoma getSintoma() {
		return sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}
	
	public String retornar() {
		return "retornar";
	}

}
