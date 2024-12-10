package com.isabela.api.product.product_api.controller;

import com.isabela.api.product.product_api.models.dto.ProductDTO;
import com.isabela.api.product.product_api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable String id) {
        return productService.findById(id);
    }

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public ProductDTO newProduct(@RequestBody @Valid ProductDTO productDTO) {
    // productDTO.setProductIdentifier(UUID.randomUUID().toString());
    // return productService.save(productDTO);
    // }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO newProduct(@RequestBody @Valid ProductDTO productDTO) {
        if (productDTO.getProductIdentifier() == null || productDTO.getProductIdentifier().isEmpty()) {
            productDTO.setProductIdentifier(UUID.randomUUID().toString());
        }
        return productService.save(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable String id, @RequestBody @Valid ProductDTO productDTO) {
        return productService.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> getProductsPage(Pageable pageable) {
        return productService.getAllPages(pageable);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategoryId(@PathVariable String categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/productIdentifier/{productIdentifier}")
    public ProductDTO findByProductIdentifier(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }
}