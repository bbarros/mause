package com.mause.bean.admin;

import java.util.List;

import org.hibernate.Session;

import com.mause.model.Cargo;
import com.mause.model.Usuario;
import com.mause.util.HibernateUtil;

public class AdminAdicionarBean {
	private Usuario usuario;
	private List<Cargo> listaCargos;
	private List<Usuario> listaUsuarios;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Cargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String salvarUsuario() {
		String resposta = "success";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.save(this.usuario);
			
			session.getTransaction().commit();
			
			atualizaListaUsuarios();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na adição do usuário");
			e.printStackTrace();
		}		
		
		return resposta;
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaListaUsuarios() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.listaUsuarios.clear();
			this.listaUsuarios.addAll((List<Usuario>) session.createCriteria(Usuario.class).list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de usuários do sistema");
			e.printStackTrace();
		}		
		
	}

	
	public String cancelarAdicao() {
		return "cancelada";
	}
	
}
