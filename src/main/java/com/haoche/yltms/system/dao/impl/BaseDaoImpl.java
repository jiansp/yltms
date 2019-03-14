package com.haoche.yltms.system.dao.impl;

import com.haoche.yltms.system.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private Session getSession() {
        return entityManagerFactory.unwrap(SessionFactory.class).openSession();
    }

    @Override
    public List findBySql(String sql) {
        Session session = getSession();
        Query query = session.createSQLQuery(sql);
        return query.list();
    }

    @Override
    public List findByHqlParams(String hql, String paramName, Object paramValue) {
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setParameter(paramName, paramValue);

        return query.list();
    }
}
