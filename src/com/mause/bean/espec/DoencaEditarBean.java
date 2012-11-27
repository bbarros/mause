package com.mause.bean.espec;

import java.util.List;

import org.hibernate.Session;

import com.mause.model.Doenca;
import com.mause.model.Sintoma;
import com.mause.util.HibernateUtil;

public class DoencaEditarBean {
	private Doenca doenca;
	private List<Sintoma> doencaSintomas;
	private List<Doenca> listaDoencas;
	private List<Sintoma> listaSintomas;

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}

	public List<Doenca> getListaDoencas() {
		return listaDoencas;
	}

	public void setListaDoencas(List<Doenca> listaDoencas) {
		this.listaDoencas = listaDoencas;
	}

	public List<Sintoma> getListaSintomas() {
		return listaSintomas;
	}

	public void setListaSintomas(List<Sintoma> listaSintomas) {
		this.listaSintomas = listaSintomas;
	}
	
	public List<Sintoma> getDoencaSintomas() {
		return doencaSintomas;
	}

	public void setDoencaSintomas(List<Sintoma> doencaSintomas) {
		this.doencaSintomas = doencaSintomas;
	}

	public String salvarDoenca() {
		String resposta = "success";
		
		this.doenca.getSintomas().clear();
		this.doenca.getSintomas().addAll(this.doencaSintomas);
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.update(this.doenca);
			
			session.getTransaction().commit();
			
			atualizaListaDoencas();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na adição da doença");
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

	
	public String cancelarEdicao() {
		return "cancelada";
	}

}
