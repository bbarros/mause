package com.mause.bean.admin;

import java.util.List;

import org.hibernate.Session;

import com.mause.model.Cargo;
import com.mause.model.Usuario;
import com.mause.util.HibernateUtil;

public class AdminBean {
	private List<Usuario> usuarios;
	private Usuario usr;
	private List<Cargo> cargos;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@SuppressWarnings("unchecked")
	public String editarUsuario() {
		String resposta = "editar";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.cargos = (List<Cargo>) session.createCriteria(Cargo.class).list();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da relação de cargos");
			e.printStackTrace();
		}		
		
		return resposta;
	}
	
	public String excluirUsuario() {
		String resposta = "excluir";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.delete(this.usr);
			
			session.getTransaction().commit();
			
			atualizaListaUsuarios();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na exclusão do usuário");
			e.printStackTrace();
		}		
		
		return resposta;
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaListaUsuarios() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.usuarios.clear();
			this.usuarios.addAll((List<Usuario>) session.createCriteria(Usuario.class).list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de usuários do sistema");
			e.printStackTrace();
		}		
		
	}
	
	@SuppressWarnings("unchecked")
	public String adicionarUsuario() {
		String resposta = "adicionar";

		this.usr = new Usuario();
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.cargos = (List<Cargo>) session.createCriteria(Cargo.class).list();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da relação de cargos");
			e.printStackTrace();
		}		

		return resposta;
	}

}
