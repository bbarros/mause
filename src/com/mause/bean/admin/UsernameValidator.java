package com.mause.bean.admin;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Usuario;
import com.mause.util.HibernateUtil;

public class UsernameValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object object)
			throws ValidatorException {
		String username = (String) object;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
					
		Usuario rs = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", username)).uniqueResult();
		
		session.getTransaction().commit();
		
		if (rs != null) {
			FacesMessage message = new FacesMessage();
			message.setSummary("Nome de usu‡rio j‡ utilizado!");
			throw new ValidatorException(message);										
		}
	}
}
