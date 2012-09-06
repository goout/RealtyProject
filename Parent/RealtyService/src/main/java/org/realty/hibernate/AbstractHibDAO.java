package org.realty.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;



public class AbstractHibDAO {


    private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    protected AbstractHibDAO() {
    }

    public static Session getSession() {
        Session session =  AbstractHibDAO.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            AbstractHibDAO.session.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }




}
