package com.mause.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Consulta implements Serializable{
	private static final long serialVersionUID = -4327461509488229247L;

	private int id;
	private Usuario medico;
	private Paciente paciente;
	private Date dataHorario;
	private boolean finalizada;
	private String obs;
	private Set<Sintoma> sintomas;
	private Set<Doenca> diagnostico;
	private Set<Receituario> receitas;

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public Date getDataHorario() {
		return dataHorario;
	}
	
	public void setDataHorario(Date dataHorario) {
		this.dataHorario = dataHorario;
	}
	
	public boolean isFinalizada() {
		return finalizada;
	}
	
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	public String getObs() {
		return obs;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public Set<Sintoma> getSintomas() {
		return sintomas;
	}
	
	public void setSintomas(Set<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}
	
	public Set<Doenca> getDiagnostico() {
		return diagnostico;
	}
	
	public void setDiagnostico(Set<Doenca> diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public Set<Receituario> getReceitas() {
		return receitas;
	}
	
	public void setReceitas(Set<Receituario> receitas) {
		this.receitas = receitas;
	}
	
}
