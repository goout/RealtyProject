package org.realty.hibernate;


import org.hibernate.Query;

import org.realty.entity.Street;

import java.util.List;

public class StreetHibDAO extends HibernateDAO<Street> {


    @SuppressWarnings("unchecked")
    public List<Street> getAllAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert");
        List<Street> LST = query.list();
        commit();
        close();
        return LST;
    }

}
