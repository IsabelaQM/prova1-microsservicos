package com.isabela.api.product.product_api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isabela.api.product.product_api.services.CategoryService;

import jakarta.validation.Valid;

import com.isabela.api.product.product_api.models.dto.CategoryDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO newCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.save(categoryDTO);
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable String id, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.update(id, categoryDTO);
    }

    @GetMapping("/pageable")
    public Page<CategoryDTO> getCategoriesPage(Pageable pageable) {
        return categoryService.getAllPage(pageable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }   
}
