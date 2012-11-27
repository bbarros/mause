package com.mause.bean.recep;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.mause.model.Paciente;
import com.mause.util.HibernateUtil;

public class RecepPacBean {
	private List<Paciente> pacientes;
	private Paciente pac;

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente getPac() {
		return pac;
	}

	public void setPac(Paciente pac) {
		this.pac = pac;
	}
	
	public String adicionarPaciente() {
		String resposta = "adicionar";
		this.pac = new Paciente();		
		return resposta;
	}
	
	public String editarPaciente() {
		return "editar";
	}
	
	public String excluirPaciente() {
		String resposta = "excluir";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.delete(this.pac);
			
			session.getTransaction().commit();
			
			atualizaListaPacientes();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na exclusão do paciente");
			e.printStackTrace();
		}		
		
		return resposta;
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaListaPacientes() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.pacientes.clear();
			this.pacientes.addAll((List<Paciente>) session.createCriteria(Paciente.class)
					.addOrder(Order.asc("nome")).list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de pacientes do sistema");
			e.printStackTrace();
		}		
		
	}


}
