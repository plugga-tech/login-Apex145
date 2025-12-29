package com.login.Login.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.Login.User.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    
}
