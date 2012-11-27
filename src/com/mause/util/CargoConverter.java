package com.mause.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mause.model.Cargo;

public class CargoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
			throws ConverterException {

		if (value != null) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
						
			Cargo cargo = (Cargo) session.createCriteria(Cargo.class)
					.add(Restrictions.eq("nome", value)).uniqueResult();
			
			session.getTransaction().commit();

			return cargo;			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
			throws ConverterException {
		if (value instanceof Cargo) {
			Cargo cargo = (Cargo) value;
			return cargo.getNome();
		}
		return null;
	}

}
