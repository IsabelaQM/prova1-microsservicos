package com.isabela.api.product.product_api.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isabela.api.product.product_api.models.Category;
import com.isabela.api.product.product_api.models.Product;
import com.isabela.api.product.product_api.models.dto.ProductDTO;
import com.isabela.api.product.product_api.repositories.CategoryRepository;
import com.isabela.api.product.product_api.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        return ProductDTO.convert(product);
    }

    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        if (productDTO.getProductIdentifier() == null) {
            productDTO.setProductIdentifier(UUID.randomUUID().toString());
        }

        // Busca a categoria pelo ID
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));

        // Converte e salva o produto
        Product product = Product.convert(productDTO, category);
        product = productRepository.save(product);
        return ProductDTO.convert(product);
    }

    @Transactional
    public ProductDTO update(String id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductIdentifier(productDTO.getProductIdentifier());

        // Buscar a categoria pelo ID
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
        product.setCategory(category);

        product = productRepository.save(product);
        return ProductDTO.convert(product);
    }

    @Transactional
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public Page<ProductDTO> getAllPages(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductDTO::convert);
    }

    public List<ProductDTO> getProductByCategoryId(String categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        return ProductDTO.convert(product);
    }
}