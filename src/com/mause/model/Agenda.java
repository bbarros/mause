package com.mause.model;

import java.io.Serializable;
import java.util.Date;


public class Agenda implements Serializable {
	/**
	 * Hash SHA que define a versão da classe serializável "Agenda". Calculado
	 * com base no nome dos atributos e nas assinaturas dos métodos da classe. 
	 */
	private static final long serialVersionUID = -3032014167767948474L;
	
	private Usuario medico;
	private Paciente paciente;
	private Date dataHora;
	private boolean presente;

	public Usuario getMedico() {
		return medico;
	}
	
	public void setMedico(Usuario medico) {
		this.medico = medico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Date getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
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
		Agenda other = (Agenda) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		return true;
	}
	
	
}
