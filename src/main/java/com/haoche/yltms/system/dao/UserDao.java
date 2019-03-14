package com.haoche.yltms.system.dao;

import java.util.List;

public interface UserDao {
    public List findByUsername(String username);
}
