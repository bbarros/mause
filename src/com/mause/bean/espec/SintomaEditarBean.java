package com.mause.bean.espec;

import java.util.List;

import org.hibernate.Session;

import com.mause.model.Sintoma;
import com.mause.util.HibernateUtil;

public class SintomaEditarBean {
	private Sintoma sintoma;
	private List<Sintoma> listaSintomas;
	
	
	public Sintoma getSintoma() {
		return sintoma;
	}
	
	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}
	
	public List<Sintoma> getListaSintomas() {
		return listaSintomas;
	}
	
	public void setListaSintomas(List<Sintoma> listaSintomas) {
		this.listaSintomas = listaSintomas;
	}
	
	public String salvarSintoma() {
		String resposta = "success";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.update(this.sintoma);
			
			session.getTransaction().commit();
			
			atualizaListaSintomas();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na atulização do sintoma");
			e.printStackTrace();
		}		
		
		return resposta;
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaListaSintomas() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			this.listaSintomas.clear();
			this.listaSintomas.addAll((List<Sintoma>) session.createCriteria(Sintoma.class).list());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na obtenção da lista de sintomas do sistema");
			e.printStackTrace();
		}		
		
	}

	public String cancelarEdicao() {
		return "cancelada";
	}

}
