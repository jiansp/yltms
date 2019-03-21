package com.haoche.yltms.system.service;

import com.haoche.yltms.system.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void changePassword(User user);

    List<User> findUsers();
}
