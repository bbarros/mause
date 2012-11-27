package com.mause.bean.admin;

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

public class CpfValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object object)
			throws ValidatorException {
		String cpf = (String) object;
		UIInput loginUI = (UIInput) component.getAttributes().get("login");
		String login = (String) loginUI.getValue();
		
		if(cpf.matches(".*[a-zA-Z].*")) {
			FacesMessage message = new FacesMessage();
			message.setSummary("O CPF deve conter apenas Nœmeros!");
			throw new ValidatorException(message);		
			
		} else {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
						
			Usuario rs = (Usuario) session.createCriteria(Usuario.class)
					.add(Restrictions.eq("cpf", cpf)).uniqueResult();
			
			session.getTransaction().commit();

			if (rs != null) {
				if (rs.getLogin().compareTo(login) != 0) {
					FacesMessage message = new FacesMessage();
					message.setSummary("CPF j‡ cadastrado!");
					throw new ValidatorException(message);										
				}
			}
		}
	}
}
