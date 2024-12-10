package com.isabela.api.product.product_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isabela.api.product.product_api.models.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> { 

}
