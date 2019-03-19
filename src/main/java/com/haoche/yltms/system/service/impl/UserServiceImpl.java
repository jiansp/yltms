package com.haoche.yltms.system.service.impl;

import com.haoche.yltms.system.repository.UserRepository;
import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.service.UserService;
import com.haoche.yltms.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        Date now = new Date();
        user.setId(UUIDGenerator.getUUID());
        user.setType(User.GENERAL_USER);
        user.setCreateTime(now);
        this.userRepository.save(user);
    }
}
