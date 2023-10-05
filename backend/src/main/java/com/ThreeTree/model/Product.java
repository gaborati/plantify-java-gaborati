package com.ThreeTree.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )

    private Integer productId;
    private String name;

    private Integer price;

    public Product(Integer productId, String name, Integer price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price);
    }
}
