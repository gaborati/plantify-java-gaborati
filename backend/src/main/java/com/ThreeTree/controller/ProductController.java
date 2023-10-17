package com.ThreeTree.controller;

import com.ThreeTree.model.Product;
import com.ThreeTree.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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
