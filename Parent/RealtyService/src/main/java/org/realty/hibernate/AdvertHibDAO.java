package org.realty.hibernate;

import org.hibernate.Query;
import org.realty.entity.Advert;
import org.realty.entity.User;

import java.util.List;


public class AdvertHibDAO extends HibernateDAO<Advert> {

    @SuppressWarnings("unchecked")
    public List<Advert> getAllAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert");
        List<Advert> LST = query.list();
        commit();
        return LST;
    }

}
