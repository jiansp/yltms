package com.haoche.yltms.system.dao.impl;

import com.haoche.yltms.system.dao.UserDao;
import com.haoche.yltms.system.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    public List findByUsername(String username){
        String hql = "from User where (isDelete is null or isDelete !=1) and username = :username";
        return this.findByHqlParams(hql, "username", username);
    }

    @Override
    public void save(User user) {
        this.save(user);
    }
}
