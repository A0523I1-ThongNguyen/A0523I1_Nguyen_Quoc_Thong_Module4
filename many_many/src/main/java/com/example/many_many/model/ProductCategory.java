package com.example.many_many.model;

import jakarta.persistence.*;

@Entity
public class ProductCategory {
    // n-n là : một bản ghi trong một bảng liên kết với nhiều bản ghi trong bảng khác và ngược lại
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public ProductCategory() {
    }

    public ProductCategory(Long id, Product product, Category category) {
        this.id = id;
        this.product = product;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
