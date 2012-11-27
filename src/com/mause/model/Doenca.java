package com.mause.model;

import java.io.Serializable;
import java.util.Set;

public class Doenca implements Serializable {

	private static final long serialVersionUID = -7020617797565802495L;
	
	private String cid;
	private String nome;
	private String nomeCientifico;
	private String tratamento;
	private String ref;
	private String desc;
	private Set<Sintoma> sintomas;

	
	public String getCid() {
		return cid;
	}
	
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeCientifico() {
		return nomeCientifico;
	}
	
	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}
	
	public String getTratamento() {
		return tratamento;
	}
	
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(Set<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
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
		Doenca other = (Doenca) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		return true;
	}

}
