package org.realty.hibernate;


import org.realty.entity.User;
import org.hibernate.Query;

import java.util.List;

public class UserHibDAO extends HibernateDAO<User> {

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        begin();
        Query query = getSession().createQuery("FROM User");
        List<User> LST = query.list();
        commit();
        return LST;
    }
}
