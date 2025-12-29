package com.login.Login.Repository;

import org.springframework.data.repository.CrudRepository;

import com.login.Login.User.User;


public interface UserRepository extends CrudRepository<User, Integer> {
    
}
