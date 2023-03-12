package com.toffee.nuts.bulletinboard.repository;

import com.toffee.nuts.bulletinboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByName(String name);

}