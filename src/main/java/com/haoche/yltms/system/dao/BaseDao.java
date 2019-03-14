package com.haoche.yltms.system.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao extends Serializable {
    public abstract List findBySql (String sql);
}
