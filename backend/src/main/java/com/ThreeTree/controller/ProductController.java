package com.ThreeTree.controller;

import com.ThreeTree.model.Product;
import com.ThreeTree.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> missingProduct(NoSuchElementException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }


    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

}
