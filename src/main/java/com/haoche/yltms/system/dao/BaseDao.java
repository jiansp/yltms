package com.haoche.yltms.system.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao extends Serializable {
    public List findBySql (String sql);
    public List findByHqlParams(String hql, String paramName, Object paramValue);
    public Serializable save(Object object);
    public void update(Object object);
}
