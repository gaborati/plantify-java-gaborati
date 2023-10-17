package com.ThreeTree.service;

import com.ThreeTree.dao.ProductRepository;
import com.ThreeTree.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow();
    }


    public void saveProduct(Product product) {
        productRepository.save(product);
    }


}
