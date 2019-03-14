package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.dao.UserDao;
import com.haoche.yltms.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
}
