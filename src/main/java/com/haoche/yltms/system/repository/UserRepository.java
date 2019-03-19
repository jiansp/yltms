package com.haoche.yltms.system.repository;

import com.haoche.yltms.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
