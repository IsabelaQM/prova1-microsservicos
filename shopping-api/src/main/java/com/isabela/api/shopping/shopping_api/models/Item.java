package com.isabela.api.shopping.shopping_api.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Item {
    
    private String productIdentifier;
    private Double price;
}
