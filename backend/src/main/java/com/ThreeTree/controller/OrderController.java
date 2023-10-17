package com.ThreeTree.controller;

import com.ThreeTree.model.Order;
import com.ThreeTree.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable("orderId") Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrderById(@PathVariable("id") Long id, @RequestBody Order order) {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
