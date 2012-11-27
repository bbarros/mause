package com.mause.bean.espec;

import java.util.List;

import org.hibernate.Session;

import com.mause.model.Sintoma;
import com.mause.util.HibernateUtil;

public class SintomaBean {
	private String view_id;
	private String doenca_view_id;

	private List<Sintoma> listaSintomas;
	private Sintoma sintoma;

	public String getView_id() {
		return view_id;
	}

	public void setView_id(String view_id) {
		this.view_id = view_id;
	}

	public String getDoenca_view_id() {
		return doenca_view_id;
	}

	public void setDoenca_view_id(String doenca_view_id) {
		this.doenca_view_id = doenca_view_id;
	}

	public List<Sintoma> getListaSintomas() {
		return listaSintomas;
	}

	public void setListaSintomas(List<Sintoma> listaSintomas) {
		this.listaSintomas = listaSintomas;
	}
	
	public Sintoma getSintoma() {
		return sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}
	
	public String adicionarSintoma() {
		String resposta = "adicionar";

		this.sintoma = new Sintoma();
		
		return resposta;
	}

	public String editarSintoma() {
		String resposta = "editar";
		
		return resposta;
	}

	public String excluirSintoma() {
		String resposta = "excluir";
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.delete(this.sintoma);
			
			session.getTransaction().commit();
			
			atualizaListaSintomas();
						
		} catch (Exception e) {
			System.out.println("Ocorreu uma Exception na exclusão do sintoma");
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
	
}
