package org.realty.hibernate;



public class HibernateDAO<T> extends AbstractHibDAO {

    public T create(T value) {

        begin();
        getSession().save(value);
        commit();
        return value;

    }

    @SuppressWarnings("unchecked")
    public T read(Class<T> clazz, Long id){
        T event = null;
        begin();
        event = (T) getSession().get(clazz, id);
        commit();
        return event;
    }

    public void update(T clazz) {
        begin();
        getSession().update(clazz);
        commit();

    }

    public void delete(T clazz) {
        begin();
        getSession().delete(clazz);
        commit();

    }

}