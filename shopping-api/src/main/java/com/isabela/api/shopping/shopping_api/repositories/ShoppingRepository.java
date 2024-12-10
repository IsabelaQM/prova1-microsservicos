package com.isabela.api.shopping.shopping_api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.isabela.api.shopping.shopping_api.models.Shopping;
import java.time.LocalDate;


public interface ShoppingRepository extends MongoRepository<Shopping, String> {

    @Query("{ 'userIdentifier' : ?0 }")
    List<Shopping> findByUserIdentifier(String userIdentifier);

    @Query("{ 'items.productIdentifier' : ?0 }")
    List<Shopping> findByProductIdentifier(String productIdentifier);

    @Query("{ 'date' : { $gte : ?0, $lte : ?1 }, 'total' : { $gte : ?2 } }")
    List<Shopping> findByDateAndMinimumValue(LocalDate startDate, LocalDate endDate, Double minimumValue);

    @Query("{ 'date' : { $gte : ?0, $lte : ?1 } }")
    List<Shopping> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("{ 'date' : ?0 }")
    List<Shopping> findByDate(LocalDate date);
    
}
