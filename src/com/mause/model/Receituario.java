package com.mause.model;

import java.io.Serializable;

public class Receituario implements Serializable {
	private static final long serialVersionUID = -8041711972914592211L;

	private String exames;
	private String medicamentos;
	private String obs;
	private int id;

	
	public String getExames() {
		return exames;
	}
	
	public void setExames(String exames) {
		this.exames = exames;
	}
	
	public String getMedicamentos() {
		return medicamentos;
	}
	
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	public String getObs() {
		return obs;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receituario other = (Receituario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
