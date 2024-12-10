package com.isabela.api.shopping.shopping_api.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Document(collection = "shopping")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shopping {
    
    @Id
    private String id;
    private String userIdentifier;

    @CreatedDate
    private LocalDate date;
    private List<Item> items;
    private Double total;

    public Shopping(String userIdentifier, LocalDate date, List<Item> items, Double total) {
        this.userIdentifier = userIdentifier;
        this.date = date;
        this.items = items;
        this.total = total;
    }

}
