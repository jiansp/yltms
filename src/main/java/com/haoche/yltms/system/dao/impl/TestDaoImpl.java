package com.haoche.yltms.system.dao.impl;

import com.haoche.yltms.system.dao.TestDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoImpl extends BaseDaoImpl implements TestDao {

    @Override
    public List findTest() {
        return this.findBySql("select * from test");
    }
}
