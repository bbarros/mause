package com.mause.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Sintoma;

public class SintomaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
			throws ConverterException {

		if (value != null) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
						
			Sintoma sint = (Sintoma) session.createCriteria(Sintoma.class)
					.add(Restrictions.eq("sintomaCID", value)).uniqueResult();
			
			session.getTransaction().commit();

			return sint;			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
			throws ConverterException {
		if (value instanceof Sintoma) {
			Sintoma sint = (Sintoma) value;
			return sint.getSintomaCID();
		}
		return null;
	}

}
