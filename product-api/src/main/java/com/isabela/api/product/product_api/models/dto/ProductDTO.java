package com.isabela.api.product.product_api.models.dto;

import com.isabela.api.product.product_api.models.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    private String productIdentifier;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private Double price;

    // @NotBlank(message = "Category is required")
    // private String categoryId;

    @NotNull(message = "Category ID is required")
    private String categoryId;

    public static ProductDTO convert(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setProductIdentifier(product.getProductIdentifier());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategoryId(product.getCategory().getId());

        // if (product.getCategory() != null) {
        //     dto.setCategory(CategoryDTO.convert(product.getCategory()));
        // }

        return dto;
    }

    // public Product toEntity(CategoryRepository categoryRepository) {
    //     Product product = new Product();
    //     product.setName(this.name);
    //     product.setProductIdentifier(this.productIdentifier);
    //     product.setDescription(this.description);
    //     product.setPrice(this.price);

    //     // Buscar a categoria pelo ID
    //     if (this.categoryId != null) {
    //         Category category = categoryRepository.findById(this.categoryId)
    //                 .orElseThrow(() -> new RuntimeException("Category not found"));
    //         product.setCategory(category);
    //     }

    //     return product;
    // }
}
