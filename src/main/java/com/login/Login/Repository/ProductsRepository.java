package com.login.Login.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.Login.Product.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer>{
    
}
