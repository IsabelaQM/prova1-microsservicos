package com.isabela.api.shopping.shopping_api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isabela.api.shopping.shopping_api.models.Shopping;
import com.isabela.api.shopping.shopping_api.services.ShoppingService;

@RestController
@RequestMapping("/shopping")	
public class ShoppingController {
    
    @Autowired
    private ShoppingService shopService;

    // 1. GET /shopping -> findAll
    @GetMapping
    public List<Shopping> getAllShops() {
        return shopService.getAllShoppings();
    }

    // 2. GET /shopping/{id} -> findById
    @GetMapping("/{id}")
    public Shopping getShopById(@PathVariable String id) {
        return shopService.getShoppingById(id);
    }

    // 3. POST /shopping -> save
    @PostMapping
    public Shopping saveShop(@RequestBody Shopping shop) {
        return shopService.saveShopping(shop);
    }

    // 4. GET /shopping/shopByUser -> getByUser
    @GetMapping("/shopByUser/{userIdentifier}")
    public List<Shopping> getShoppingsByUser(@PathVariable String userIdentifier) {
        return shopService.getShoppingsByUser(userIdentifier);
    }

    // 5. GET /shopping/{productIdentifier} -> findByProductIdentifier
    @GetMapping("/productIdentifier/{productIdentifier}")
    public List<Shopping> getShopsByProductIdentifier(@PathVariable String productIdentifier) {
        return shopService.getShoppingsByProductIdentifier(productIdentifier);
    }

    // 6. GET /shopping/shopByDate -> getByDate
    @GetMapping("/shopByDate/{date}")
    public List<Shopping> getShopsByDate(
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return shopService.getShoppingsByDate(date);
    }

    //7. GET /shopping/search -> getShopsByFilter
    @GetMapping("/search")
    public List<Shopping> getShopsByFilter(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
        @RequestParam(required = false) Double minimumValue
    ) {
        return shopService.getShopsByFilter(startDate, endDate, minimumValue);
    }

    // 8. GET /shopping/report -> getReportByDate
    @GetMapping("/report")
    public List<Shopping> getReportByDate(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return shopService.getReportByDate(startDate, endDate);
    }
}
