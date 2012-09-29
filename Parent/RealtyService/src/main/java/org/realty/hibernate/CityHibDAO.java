package org.realty.hibernate;


import org.hibernate.Query;
import org.realty.entity.City;


import java.util.List;

public class CityHibDAO extends HibernateDAO<City> {

    @SuppressWarnings("unchecked")
    public List<City> getAllCitys() {
        begin();
        Query query = getSession().createQuery("FROM City");
        List<City> LST = query.list();
        commit();
        close();
        return LST;
    }

}
