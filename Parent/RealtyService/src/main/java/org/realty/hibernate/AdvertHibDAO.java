package org.realty.hibernate;

import org.hibernate.Query;
import org.realty.entity.Advert;
import org.realty.entity.User;

import java.util.List;


public class AdvertHibDAO extends HibernateDAO<Advert> {

    @SuppressWarnings("unchecked")
    public List<Advert> getAllAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert order by advert_id");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }


    @SuppressWarnings("unchecked")
    public List<Advert> getAllAdvertsDESC() {
        begin();
        Query query = getSession().createQuery("FROM Advert order by advert_id DESC");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }


    @SuppressWarnings("unchecked")
    public List<Advert> getRentAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert WHERE category='Rent'");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }

    @SuppressWarnings("unchecked")
    public List<Advert> getRentAdvertsDESC() {
        begin();
        Query query = getSession().createQuery("FROM Advert WHERE category='Rent' order by advert_id DESC");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }


    @SuppressWarnings("unchecked")
    public List<Advert> getSaleAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert WHERE category='Sale'");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }

    @SuppressWarnings("unchecked")
    public List<Advert> getSaleAdvertsDESC() {
        begin();
        Query query = getSession().createQuery("FROM Advert WHERE category='Sale' order by advert_id DESC");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }

    @SuppressWarnings("unchecked")
    public List<Advert> getPurchaseAdverts() {
        begin();
        Query query = getSession().createQuery("FROM Advert WHERE category='Purchase'");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }


    @SuppressWarnings("unchecked")
    public List<Advert> getPurchaseAdvertsDESC() {
        begin();
        Query query = getSession().createQuery("FROM Advert WHERE category='Purchase' order by advert_id DESC");
        List<Advert> LST = query.list();
        commit();
        close();
        return LST;
    }


}
