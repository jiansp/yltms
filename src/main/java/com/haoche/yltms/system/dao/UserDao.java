package com.haoche.yltms.system.dao;

import com.haoche.yltms.system.model.User;

import java.util.List;

public interface UserDao {
    public List findByUsername(String username);

    void save(User user);
}
