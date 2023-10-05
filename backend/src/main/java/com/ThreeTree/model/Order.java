package com.ThreeTree.model;

import jakarta.persistence.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

@Entity(name = "CustomerOrder")
@Table(name = "customer_order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_sequence"
    )
    private Integer orderId;
    private Integer customerId;

    @ElementCollection
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    private Map<Integer, Integer> productsQuantities = new HashMap<>();

    public Order(Integer orderId, Integer customerId, Map<Integer, Integer> productsQuantities) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productsQuantities = productsQuantities;
    }

    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer id) {
        this.orderId = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customer_id) {
        this.customerId = customer_id;
    }

    public Map<Integer, Integer> getProductsQuantities() {
        return productsQuantities;
    }

    public void setProductsQuantities(Map<Integer, Integer> productsQuantities) {
        this.productsQuantities = productsQuantities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(customerId, order.customerId) && Objects.equals(productsQuantities, order.productsQuantities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, productsQuantities);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + orderId +
                ", customer_id=" + customerId +
                ", productsQuantities=" + productsQuantities +
                '}';
    }
}
