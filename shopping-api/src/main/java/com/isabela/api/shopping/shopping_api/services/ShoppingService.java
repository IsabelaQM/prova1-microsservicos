package com.isabela.api.shopping.shopping_api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabela.api.shopping.shopping_api.models.Shopping;
import com.isabela.api.shopping.shopping_api.repositories.ShoppingRepository;

@Service
public class ShoppingService {
    
    @Autowired
    private ShoppingRepository shopRepository;

    public List<Shopping> getAllShoppings() {
        return shopRepository.findAll();
    }

    public Shopping getShoppingById(String id) {
        return shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Shopping saveShopping(Shopping shopping) {
        double total = shopping.getItems().stream()
                               .mapToDouble(item -> item.getPrice())
                               .sum();
        shopping.setTotal(total);
        return shopRepository.save(shopping);
    }

    public List<Shopping> getShoppingsByUser(String userIdentifier) {
        return shopRepository.findByUserIdentifier(userIdentifier);
    }

    public List<Shopping> getShoppingsByProduct(String productIdentifier) {
        return shopRepository.findByProductIdentifier(productIdentifier);
    }

    public List<Shopping> getShoppingsByProductIdentifier(String productIdentifier) {
        return shopRepository.findByProductIdentifier(productIdentifier);
    }

    public List<Shopping> getShoppingsByDate(LocalDate date) {
        return shopRepository.findByDate(date);
    }

    public List<Shopping> getReportByDate(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("As datas de início e fim são obrigatórias!");
        }
        return shopRepository.findByDateBetween(startDate, endDate);
    }

    public List<Shopping> getShopsByFilter(LocalDate startDate, LocalDate endDate, Double minimumValue) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("As datas de início e fim são obrigatórias!");
        }
        if (minimumValue == null) {
            minimumValue = 0.0;
        }
        return shopRepository.findByDateAndMinimumValue(startDate, endDate, minimumValue);
    }
    
}
