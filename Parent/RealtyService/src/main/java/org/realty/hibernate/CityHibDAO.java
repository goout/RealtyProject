package org.realty.hibernate;


import org.hibernate.Query;
import org.realty.entity.City;


import java.util.List;

public class CityHibDAO extends HibernateDAO<City> {

    @SuppressWarnings("unchecked")
    public List<City> getAllAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert");
        List<City> LST = query.list();
        commit();
        return LST;
    }

}
