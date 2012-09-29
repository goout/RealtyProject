package org.realty.hibernate;


import org.hibernate.Query;
import org.realty.entity.District;

import java.util.List;

public class DistrictHibDAO extends HibernateDAO<District> {



    @SuppressWarnings("unchecked")
    public List<District> getAllAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert");
        List<District> LST = query.list();
        commit();
        close();
        return LST;
    }


}
