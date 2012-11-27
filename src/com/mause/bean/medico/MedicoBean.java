package com.mause.bean.medico;

import java.util.List;

import org.hibernate.Session;

import com.mause.model.Agenda;
import com.mause.model.Consulta;
import com.mause.model.Doenca;
import com.mause.model.Sintoma;
import com.mause.util.HibernateUtil;

public class MedicoBean {
	private String nomeMedico;
	private List<Agenda> agenda;
	private Agenda agendamento;
	private Consulta consulta;
	private List<Sintoma> sintomas;
	private List<Doenca> doencas;

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

	public Agenda getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agenda agendamento) {
		this.agendamento = agendamento;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

	public List<Doenca> getDoencas() {
		return doencas;
	}

	public void setDoencas(List<Doenca> doencas) {
		this.doencas = doencas;
	}

	@SuppressWarnings("unchecked")
	public String iniciarConsulta() {
		String resposta = "consulta";
		
		this.consulta = new Consulta();
		this.consulta.setDataHorario(this.agendamento.getDataHora());
		this.consulta.setMedico(this.agendamento.getMedico());
		this.consulta.setPaciente(this.agendamento.getPaciente());
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
					
		this.sintomas = (List<Sintoma>) session.createCriteria(Sintoma.class).list();
		this.doencas = (List<Doenca>) session.createCriteria(Doenca.class).list();
		
		session.getTransaction().commit();

		
		return resposta;
	}
}
