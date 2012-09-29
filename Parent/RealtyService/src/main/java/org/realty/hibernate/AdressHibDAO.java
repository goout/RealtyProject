package org.realty.hibernate;


import org.hibernate.Query;
import org.realty.entity.Adress;


import java.util.List;

public class AdressHibDAO extends HibernateDAO<Adress> {

    @SuppressWarnings("unchecked")
    public List<Adress> getAllAdress() {
        begin();
        Query query = getSession().createQuery("FROM Adress");
        List<Adress> LST = query.list();
        commit();
        close();
        return LST;
    }
}
