package com.ThreeTree.service;

import com.ThreeTree.dao.OrderRepository;
import com.ThreeTree.dto.NewOrderRequest;
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
import java.util.Map;

@Transactional
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PersonService personService;

    public void saveOrder(NewOrderRequest newOrderRequest) {
        if(newOrderRequest.productsQuantities() != null) {
            Order newOrder = new Order();

            Map<Product, Integer> productsQuantities = new HashMap<>();
            for (Map.Entry<Long, Integer> entry : newOrderRequest.productsQuantities().entrySet()) {
                Product product = productService.findProductById(entry.getKey());
                productsQuantities.put(product, entry.getValue());
            }

            newOrder.setProductsQuantities(productsQuantities);
            newOrder.setOrderDate(LocalDate.now());
            newOrder.setPerson(personService.getCustomerById(newOrderRequest.customerId()));

            BigDecimal total = calculateOrderTotal(productsQuantities);
            newOrder.setOrderTotal(total);

            orderRepository.save(newOrder);
        }
    }

    private BigDecimal calculateOrderTotal(Map<Product, Integer> productsQuantities) {
        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry : productsQuantities.entrySet()) {
            BigDecimal productPrice = entry.getKey().getPrice();
            total = total.add(productPrice.multiply(new BigDecimal(entry.getValue())));
        }

        return total;
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
