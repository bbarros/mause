package com.mause.bean.recep;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Paciente;
import com.mause.util.HibernateUtil;

public class CpfValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object object)
			throws ValidatorException {
		String cpf = (String) object;
		
		if(cpf.matches(".*[a-zA-Z].*")) {
			FacesMessage message = new FacesMessage();
			message.setSummary("O CPF deve conter apenas N�meros!");
			throw new ValidatorException(message);		
			
		} else {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
						
			Paciente rs = (Paciente) session.createCriteria(Paciente.class)
					.add(Restrictions.eq("cpf", cpf)).uniqueResult();
			
			session.getTransaction().commit();

			if (rs != null) {
				FacesMessage message = new FacesMessage();
				message.setSummary("CPF j� cadastrado!");
				throw new ValidatorException(message);										
			}
		}
	}
}
