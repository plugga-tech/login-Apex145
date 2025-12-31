package com.login.Login.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.Login.Model.User.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

   Optional<User> findByUsername(String username);
    
}
