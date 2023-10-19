package com.ThreeTree.dao;

import com.ThreeTree.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Initializer {

    private final ProductRepository productRepository;

    @Autowired
    public Initializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void init() {
        createProduct("Cactus", "A small and prickly cactus plant", new BigDecimal("10.99"), 100, "https://images.unsplash.com/photo-1622599806389-9c6e0eb0fcec?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2940&q=80");
        createProduct("Spider Plant", "An easy-to-care-for indoor plant", new BigDecimal("12.99"), 80, "https://images.unsplash.com/photo-1610551724444-5fb527b5ad20?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2615&q=80");
        createProduct("Succulent", "A collection of beautiful succulent plants", new BigDecimal("15.99"), 120, "https://images.unsplash.com/photo-1463320898484-cdee8141c787?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2940&q=80");
        createProduct("Peace Lily", "A classic indoor plant with white flowers", new BigDecimal("14.99"), 90, "https://images.unsplash.com/photo-1652731706545-901f1026da4d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2787&q=80");
        createProduct("Snake Plant", "A hardy and low-maintenance plant", new BigDecimal("11.99"), 110, "https://images.unsplash.com/photo-1616961002389-504228edfcb7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fFNuYWtlJTIwUGxhbnR8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=800&q=60");
        createProduct("Rubber Plant", "A popular indoor plant with glossy leaves", new BigDecimal("16.99"), 70, "https://images.unsplash.com/photo-1616132803693-958f93bffb5b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2864&q=80");
        createProduct("Aloe Vera", "A versatile plant known for its healing properties", new BigDecimal("13.99"), 95, "https://images.unsplash.com/photo-1613372978247-de50228e8033?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2787&q=80");
        createProduct("Monstera", "A trendy houseplant with unique leaves", new BigDecimal("19.99"), 60, "https://plus.unsplash.com/premium_photo-1664015821116-218d91eb62ed?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2864&q=80");
        createProduct("Bamboo Palm", "A tropical palm plant for your home", new BigDecimal("18.99"), 75, "https://images.unsplash.com/photo-1558543942-5cb506ae9707?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2787&q=80");
    }

    private void createProduct(String name, String description, BigDecimal price, int stock, String image) {
        Product product = new Product();
        product.setName(name);
        product.setSku(generateSku());
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setImage(image);

        productRepository.save(product);
    }

    private String generateSku() {
        return "SKU-" + System.currentTimeMillis();
    }
}
