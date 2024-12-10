package com.isabela.api.product.product_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.isabela.api.product.product_api.models.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    private String id;
    private String productIdentifier;
    private String name;
    private String description;
    private Double price;

    // @PrePersist
    // public void prePersist() {
    //     if (this.productIdentifier == null) {
    //         this.productIdentifier = UUID.randomUUID().toString();
    //     }
    // }
    
    @DBRef
    private Category category;

    public static Product convert(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
    


    
}
