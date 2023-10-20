package com.ThreeTree.service;

import com.ThreeTree.dao.OrderRepository;
import com.ThreeTree.model.Order;
import com.ThreeTree.model.Person;
import com.ThreeTree.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Transactional
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).get();
        orderRepository.delete(order);
    }

    public void updateOrder(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id).orElseThrow();
        orderToUpdate.setProductsQuantities(order.getProductsQuantities());
        orderRepository.save(orderToUpdate);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public List<Order> getOrders() {
        List<Order> all = orderRepository.findAll();
        HashMap<Product, Integer> productsQuantities = new HashMap<>();
        Product key = new Product(1L, "Cactus", "A small and prickly cactus plant", "sku", new BigDecimal("10.99"), 100, "https://images.unsplash.com/photo-1622599806389-9c6e0eb0fcec?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2940&q=80",new HashSet<>());
        productsQuantities.put(key,2);
        all.add(new Order(1L, new Date(2023,1,2), BigDecimal.TEN, productsQuantities,new Person()));
        return all;
    }
}
