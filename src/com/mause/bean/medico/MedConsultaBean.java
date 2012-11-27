package com.mause.bean.medico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Agenda;
import com.mause.model.Consulta;
import com.mause.model.Doenca;
import com.mause.model.Receituario;
import com.mause.model.Sintoma;
import com.mause.util.HibernateUtil;

public class MedConsultaBean {
	private Consulta consulta;
	private Agenda agendamento;
	private List<Agenda> agenda;
	private List<Sintoma> sintomas;
	private List<Sintoma> sintomasSel;
	private List<Doenca> doencas;
	private List<Doenca> doencasSel;
	private List<Doenca> doencasNaoSel;
	private List<Doenca> autoDiagnostico;
	private Doenca diagItem;
	private Receituario receita;
	private Receituario receitaEdit;
	private List<Receituario> receituario;
	
	public Consulta getConsulta() {
		return consulta;
	}
	
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Agenda getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agenda agendamento) {
		this.agendamento = agendamento;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

	public List<Sintoma> getSintomasSel() {
		return sintomasSel;
	}

	public void setSintomasSel(List<Sintoma> sintomasSel) {
		this.sintomasSel = sintomasSel;
	}

	public List<Doenca> getDoencas() {
		return doencas;
	}

	public void setDoencas(List<Doenca> doencas) {
		this.doencas = doencas;
	}

	public List<Doenca> getDoencasSel() {
		return doencasSel;
	}

	public void setDoencasSel(List<Doenca> doencasSel) {
		this.doencasSel = doencasSel;
	}

	public List<Doenca> getDoencasNaoSel() {
		return doencasNaoSel;
	}

	public void setDoencasNaoSel(List<Doenca> doencasNaoSel) {
		this.doencasNaoSel = doencasNaoSel;
	}

	public List<Doenca> getAutoDiagnostico() {
		return autoDiagnostico;
	}

	public void setAutoDiagnostico(List<Doenca> autoDiagnostico) {
		this.autoDiagnostico = autoDiagnostico;
	}

	public Doenca getDiagItem() {
		return diagItem;
	}

	public void setDiagItem(Doenca diagItem) {
		this.diagItem = diagItem;
	}

	public Receituario getReceita() {
		return receita;
	}

	public void setReceita(Receituario receita) {
		this.receita = receita;
	}

	public Receituario getReceitaEdit() {
		return receitaEdit;
	}

	public void setReceitaEdit(Receituario receitaEdit) {
		this.receitaEdit = receitaEdit;
	}

	public List<Receituario> getReceituario() {
		return receituario;
	}

	public void setReceituario(List<Receituario> receituario) {
		this.receituario = receituario;
	}

	@SuppressWarnings("unchecked")
	public void gerarDiagnostico() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
					
		this.autoDiagnostico = new ArrayList<Doenca>(); 
		List<Doenca> rs = (List<Doenca>) session.createCriteria(Doenca.class).list();
		
		session.getTransaction().commit();
		
		Iterator<Doenca> itDoenca = rs.iterator();
		while (itDoenca.hasNext()) {
			Doenca doenc = itDoenca.next();
			Iterator<Sintoma> itSintoma = this.sintomasSel.iterator();
			while (itSintoma.hasNext()) {
				Sintoma sint = itSintoma.next();
				if(doenc.getSintomas().contains(sint)) {
					if(this.autoDiagnostico.contains(doenc)) {
						this.autoDiagnostico.remove(doenc);
						this.autoDiagnostico.add(0, doenc);
					} else {
						this.autoDiagnostico.add(doenc);
					}
				}
			}
		}
	}
	
	public void aceitarDiagnostico() {
		if(this.doencasSel == null) {
			this.doencasSel = new ArrayList<Doenca>();
		}
		
		if(!this.doencasSel.contains(diagItem)) {
			this.doencasSel.add(this.diagItem);			
		}
	}
	
	public void excluirDiagnostico() {
		if(this.doencasSel.contains(this.diagItem)) {
			this.doencasSel.remove(this.diagItem);			
		}
	}
	
	public void editarDiagnostico() {
		if (this.doencasNaoSel == null) {
			this.doencasNaoSel = new ArrayList<Doenca>();			
		}
		this.doencasNaoSel.clear();
		this.doencasNaoSel.addAll(this.doencas);
		
		if (this.doencasSel != null) {
			Iterator<Doenca> it = this.doencasSel.iterator();
			while (it.hasNext()) {
				this.doencasNaoSel.remove(it.next());
			}
		} else {
			this.doencasSel = new ArrayList<Doenca>();
		}
	}
	
	public void novaReceita() {
		this.receita = new Receituario();
		this.receitaEdit = null;
	}
	
	public void salvarReceita() {
		if(this.receituario == null) {
			this.receituario = new ArrayList<Receituario>();
		}
		if (this.receitaEdit != null) {
			this.receituario.remove(this.receitaEdit);
		}
		this.receituario.add(this.receita);			
	}
		
	public void excluirReceita() {
		if(this.receituario.contains(this.receita)) {
			this.receituario.remove(this.receita);
		}
	}
	
	public String salvarConsulta() {
		String resposta = "success";
		
		this.consulta.setSintomas(new HashSet<Sintoma>(this.sintomasSel));
		this.consulta.setDiagnostico(new HashSet<Doenca>(this.doencasSel));
		this.consulta.setReceitas(new HashSet<Receituario>(this.receituario));
		this.consulta.setFinalizada(true);
		
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
						
			session.save(this.consulta);
			session.delete(this.agendamento);
			
			session.getTransaction().commit();
			
			atualizaAgenda();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na gravação da consulta\n");
			e.printStackTrace();
		}

		
		return resposta;
	}
	
	public String cancelarConsulta() {
		return "cancelar";
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaAgenda() {
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.agenda.clear();
			this.agenda.addAll((List<Agenda>) session.createCriteria(Agenda.class)
					.add(Restrictions.eq("medico", this.consulta.getMedico())).list());
			
			session.getTransaction().commit();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na atualização da agenda medica\n");
			e.printStackTrace();
		}
	}
	
}
