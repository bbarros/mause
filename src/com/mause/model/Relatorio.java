package com.mause.model;

import java.util.Date;

public class Relatorio {
	private Date data;
	private int qtdeConsultas;
	private int doenca1;
	private int doenca2;
	private int doenca3;
	private String medico1;
	private String medico2;
	private String medico3;
	private String aceitacaoDiag;

	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getQtdeConsultas() {
		return qtdeConsultas;
	}
	
	public void setQtdeConsultas(int qtdeConsultas) {
		this.qtdeConsultas = qtdeConsultas;
	}
	
	public int getDoenca1() {
		return doenca1;
	}
	
	public void setDoenca1(int doenca1) {
		this.doenca1 = doenca1;
	}
	
	public int getDoenca2() {
		return doenca2;
	}
	
	public void setDoenca2(int doenca2) {
		this.doenca2 = doenca2;
	}
	
	public int getDoenca3() {
		return doenca3;
	}
	
	public void setDoenca3(int doenca3) {
		this.doenca3 = doenca3;
	}
	
	public String getMedico1() {
		return medico1;
	}
	
	public void setMedico1(String medico1) {
		this.medico1 = medico1;
	}
	
	public String getMedico2() {
		return medico2;
	}
	
	public void setMedico2(String medico2) {
		this.medico2 = medico2;
	}
	
	public String getMedico3() {
		return medico3;
	}
	
	public void setMedico3(String medico3) {
		this.medico3 = medico3;
	}
	
	public String getAceitacaoDiag() {
		return aceitacaoDiag;
	}
	
	public void setAceitacaoDiag(String aceitacaoDiag) {
		this.aceitacaoDiag = aceitacaoDiag;
	}
	
}
