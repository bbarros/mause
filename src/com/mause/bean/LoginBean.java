package com.mause.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Agenda;
import com.mause.model.Doenca;
import com.mause.model.Paciente;
import com.mause.model.Sintoma;
import com.mause.model.Usuario;
import com.mause.util.HibernateUtil;

public class LoginBean {
	private String login;
	private String password;
	private List<Agenda> agenda;
	private List<Paciente> pacientes;
	private List<Usuario> usuarios;
	private List<Doenca> doencas;
	private List<Sintoma> sintomas;

	private static final int MEDICO = 1;
	private static final int ESPECIALISTA = 3;
	private static final int ADMINISTRADOR = 4;
	private static final int RECEPCIONISTA = 5;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Doenca> getDoencas() {
		return doencas;
	}

	public void setDoencas(List<Doenca> doencas) {
		this.doencas = doencas;
	}
	
	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

	public String validateLogin() {
		/*
		 * Verifica se existe entrada para o usuário na tabela "Usuario" da base mysql.
		 * Caso exista, verifica se a senha foi inserida corretamente.
		 */
		String resposta = "fail";

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
						
			Usuario rs = (Usuario) session.createCriteria(Usuario.class)
					.add(Restrictions.eq("login", this.login)).uniqueResult();
			
			session.getTransaction().commit();
			
			if (rs != null) { // Verifica se usuário foi encontrado
				// Verifica senha do usuário
				if (rs.getSenha().compareTo(this.password) == 0) {
					HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
					httpSession.setAttribute("sessionValid", "true");
					switch (rs.getCargo().getId()) {
					
					case MEDICO:
						inicializaMedico(rs);
						resposta = "medico";						
						break;
					case ESPECIALISTA:
						inicializaEspec();
						resposta = "espec";						
						break;			
					case ADMINISTRADOR:
						inicializaAdmin();
						resposta = "admin";						
						break;			
					case RECEPCIONISTA:
						inicializaRecep();
						resposta = "recep";						
						break;			
					default:
						System.out.println("Tipo de Usuário desconhecido");
						break;
					}
				}
			}			

		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na busca do usuário");
			e.printStackTrace();
		}

					
		return resposta;
	}
	
	@SuppressWarnings("unchecked")
	private void inicializaMedico(Usuario medico) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.agenda = (List<Agenda>) session.createCriteria(Agenda.class)
					.add(Restrictions.eq("medico", medico))
					.addOrder(Order.asc("dataHora")).list();
			
			this.doencas = (List<Doenca>) session.createCriteria(Doenca.class).list();
			this.sintomas = (List<Sintoma>) session.createCriteria(Sintoma.class).list();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da Agenda médica");
			e.printStackTrace();
		}	
	}

	@SuppressWarnings("unchecked")
	private void inicializaAdmin() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.usuarios = (List<Usuario>) session.createCriteria(Usuario.class).list();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de usuários do sistema");
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unchecked")
	private void inicializaRecep() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.agenda = (List<Agenda>) session.createCriteria(Agenda.class).list();
			this.pacientes = (List<Paciente>) session.createCriteria(Paciente.class)
					.addOrder(Order.asc("nome")).list();			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção das Agendas médicas");
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void inicializaEspec() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.doencas = (List<Doenca>) session.createCriteria(Doenca.class).list();
			this.sintomas = (List<Sintoma>) session.createCriteria(Sintoma.class).list();

			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de doenças");
			e.printStackTrace();
		}		

	}

}
