package com.toffee.nuts.bulletinboard.repository;

import com.toffee.nuts.bulletinboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}