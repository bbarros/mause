package com.mause.bean.recep;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.mause.model.Agenda;
import com.mause.util.HibernateUtil;

public class RecepBean {
	private List<Agenda> agenda;
	private Agenda agendamento;

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

	public String marcarPresenca() {
		this.agendamento.setPresente(true);
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.update(this.agendamento);
			
			session.getTransaction().commit();
			
			atualizaAgenda();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na exclusão do agendamento");
			e.printStackTrace();
		}		
		
		return "atualizar";
	}
	
	public String desmarcarPresenca() {
		this.agendamento.setPresente(false);
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.update(this.agendamento);
			
			session.getTransaction().commit();
			
			atualizaAgenda();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na exclusão do agendamento");
			e.printStackTrace();
		}		
		
		return "atualizar";
	}
	
	public String desmarcarConsulta() {
		String resposta = "excluir";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.delete(this.agendamento);
			
			session.getTransaction().commit();
			
			atualizaAgenda();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na exclusão do agendamento");
			e.printStackTrace();
		}		
		
		return resposta;
	}

	@SuppressWarnings("unchecked")
	private void atualizaAgenda() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.agenda.clear();
			this.agenda.addAll((List<Agenda>) session.createCriteria(Agenda.class)
					.addOrder(Order.asc("dataHora")).list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de agendas");
			e.printStackTrace();
		}		
		
	}

}
