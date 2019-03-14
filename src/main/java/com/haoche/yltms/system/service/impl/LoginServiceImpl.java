package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.dao.UserDao;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        List list = this.userDao.findByUsername(username);
        if(list == null || list.size() == 0){
            return null;
        }
        return (User) list.get(0);
    }
}
