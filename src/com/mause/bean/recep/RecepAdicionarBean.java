package com.mause.bean.recep;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.mause.model.Paciente;
import com.mause.util.HibernateUtil;

public class RecepAdicionarBean {
	private Paciente paciente;
	private List<Paciente> listaPacientes;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public String salvarPaciente() {
		String resposta = "success";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.save(this.paciente);
			
			session.getTransaction().commit();
			
			atualizaListaPacientes();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na edição do paciente");
			e.printStackTrace();
		}		
		
		return resposta;
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaListaPacientes() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.listaPacientes.clear();
			this.listaPacientes.addAll((List<Paciente>) session.createCriteria(Paciente.class)
					.addOrder(Order.asc("nome")).list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de pacientes do sistema");
			e.printStackTrace();
		}		
		
	}
	
	public String cancelarAdicao() {
		return "cancelada";
	}

}
