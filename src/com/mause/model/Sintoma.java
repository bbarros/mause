package com.mause.model;

import java.io.Serializable;

public class Sintoma implements Serializable {

	private static final long serialVersionUID = 4762477527068653415L;
	
	private String sintomaCID;
	private String nome;
	private String desc;
	
	public Sintoma() {}
	
	public Sintoma(String sintomaCID, String nome, String desc) {
		this.sintomaCID = sintomaCID;
		this.nome = nome;
		this.desc = desc;
	}

	public String getSintomaCID() {
		return sintomaCID;
	}
	
	public void setSintomaCID(String sintomaCID) {
		this.sintomaCID = sintomaCID;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sintomaCID == null) ? 0 : sintomaCID.hashCode());
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
		Sintoma other = (Sintoma) obj;
		if (sintomaCID == null) {
			if (other.sintomaCID != null)
				return false;
		} else if (!sintomaCID.equals(other.sintomaCID))
			return false;
		return true;
	}
	
}
