package com.mause.bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Usuario;
import com.mause.util.HibernateUtil;

public class LoginValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object object)
			throws ValidatorException {
		String password = (String) object;
		UIInput usernameUI = (UIInput) component.getAttributes().get("username");
		String username = (String) usernameUI.getValue();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
					
		Usuario rs = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", username)).uniqueResult();
		
		if (rs != null) {
			rs = (Usuario) session.createCriteria(Usuario.class)
					.add(Restrictions.eq("login", username))
					.add(Restrictions.eq("senha", password)).uniqueResult();
			
			if(rs == null) {
				FacesMessage message = new FacesMessage();
				message.setSummary("Senha Incorreta");
				throw new ValidatorException(message);
			}	

		} else {
			FacesMessage message = new FacesMessage();
			message.setSummary("Usu‡rio Inexistente");
			throw new ValidatorException(message);			
		}
		
		session.getTransaction().commit();
	
	}
	
}
