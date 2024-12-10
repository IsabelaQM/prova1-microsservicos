package com.isabela.api.product.product_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isabela.api.product.product_api.models.Product;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> { 
    
    List<Product> findByCategoryId(String categoryId);
    Optional<Product> findByProductIdentifier(String productIdentifier);
}