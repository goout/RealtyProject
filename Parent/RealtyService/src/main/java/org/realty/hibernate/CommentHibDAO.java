package org.realty.hibernate;


import org.hibernate.Query;
import org.realty.entity.Comment;

import java.util.List;

public class CommentHibDAO extends HibernateDAO<Comment> {

    @SuppressWarnings("unchecked")
    public List<Comment> getAllComments() {
        begin();
        Query query = getSession().createQuery("FROM Comment");
        List<Comment> LST = query.list();
        commit();
        close();
        return LST;
    }


}
