package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.dao.TestDao;
import com.haoche.yltms.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List findTest() {
        return this.testDao.findTest();
    }
}
