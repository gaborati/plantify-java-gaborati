package com.ThreeTree.service;

import com.ThreeTree.dao.OrderRepository;
import com.ThreeTree.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return orderRepository.findAll();
    }
}
