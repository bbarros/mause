package com.mause.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Doenca;

public class DoencaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
			throws ConverterException {

		if (value != null) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
						
			Doenca doenc = (Doenca) session.createCriteria(Doenca.class)
					.add(Restrictions.eq("cid", value)).uniqueResult();
			
			session.getTransaction().commit();

			return doenc;			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
			throws ConverterException {
		if (value instanceof Doenca) {
			Doenca doenc = (Doenca) value;
			return doenc.getCid();
		}
		return null;
	}

}
