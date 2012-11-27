package com.mause.bean.espec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.mause.model.Doenca;
import com.mause.model.Sintoma;
import com.mause.util.HibernateUtil;

public class DoencaBean {
	private  String view_id;
	private String sintoma_view_id;
	
	private List<Doenca> listaDoencas;
	private Doenca doenca;
	private List<Sintoma> doencaSintomas;
	private List<Sintoma> sintomas;

	public String getView_id() {
		return view_id;
	}

	public void setView_id(String view_id) {
		this.view_id = view_id;
	}

	public String getSintoma_view_id() {
		return sintoma_view_id;
	}

	public void setSintoma_view_id(String sintoma_view_id) {
		this.sintoma_view_id = sintoma_view_id;
	}

	public List<Doenca> getListaDoencas() {
		return listaDoencas;
	}

	public void setListaDoencas(List<Doenca> listaDoencas) {
		this.listaDoencas = listaDoencas;
	}
	
	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}
	
	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}
	
	public List<Sintoma> getDoencaSintomas() {
		return doencaSintomas;
	}

	public void setDoencaSintomas(List<Sintoma> doencaSintomas) {
		this.doencaSintomas = doencaSintomas;
	}

	@SuppressWarnings("unchecked")
	public String adicionarDoenca() {
		String resposta = "adicionar";

		this.doenca = new Doenca();
		this.doenca.setSintomas(new HashSet<Sintoma>());
		
		/*
		 * A coleção de sintomas deve ser do tipo List para que possa ser manipulado
		 * pelos elementos de view do RichFaces.
		 */
		
		this.doencaSintomas = (List<Sintoma>) new ArrayList<Sintoma>();
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.sintomas = (List<Sintoma>) session.createCriteria(Sintoma.class).list();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da relação de sintomas");
			e.printStackTrace();
		}		

		return resposta;
	}

	@SuppressWarnings("unchecked")
	public String editarDoenca() {
		String resposta = "editar";
		
		/*
		 * A coleção de sintomas deve ser do tipo List para que possa ser manipulado
		 * pelos elementos de view do RichFaces.
		 */
		this.doencaSintomas = (List<Sintoma>) new ArrayList<Sintoma>();
		this.doencaSintomas.addAll(this.doenca.getSintomas());
				
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.sintomas = (List<Sintoma>) session.createCriteria(Sintoma.class).list();
						
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da relação de sintomas");
			e.printStackTrace();
		}		

		Iterator<Sintoma> it = this.doencaSintomas.iterator(); 
		while(it.hasNext()) {
			Sintoma sint = it.next();
			if (this.sintomas.contains(sint)) {
				this.sintomas.remove(sint);
			}
		}

		return resposta;
	}

	public String excluirDoenca() {
		String resposta = "excluir";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.delete(this.doenca);
			
			session.getTransaction().commit();
			
			atualizaListaDoencas();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na exclusão da doença");
			e.printStackTrace();
		}		
		
		return resposta;
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaListaDoencas() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.listaDoencas.clear();
			this.listaDoencas.addAll((List<Doenca>) session.createCriteria(Doenca.class).list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de doenças do sistema");
			e.printStackTrace();
		}		
		
	}

}
