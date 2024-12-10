package com.isabela.api.product.product_api.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isabela.api.product.product_api.models.Category;
import com.isabela.api.product.product_api.models.dto.CategoryDTO;
import com.isabela.api.product.product_api.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryDTO::convert)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(String id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return CategoryDTO.convert(category);
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = Category.convert(categoryDTO);
        if (category.getName().isBlank()) {
            throw new IllegalArgumentException("Category name cannot be blank");
        }
        category = categoryRepository.save(category);
        return CategoryDTO.convert(category);
    }

    public CategoryDTO update(String id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
        category.setName(categoryDTO.getName());
        category = categoryRepository.save(category);
        return CategoryDTO.convert(category);
    }

    public Page<CategoryDTO> getAllPage(Pageable page) {
        Page<Category> categories = categoryRepository.findAll(page);
        return categories.map(CategoryDTO::convert);
    }

    public void delete(String id) {
        categoryRepository.deleteById(id);
    }
}
