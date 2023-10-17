package com.ThreeTree.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

@Entity(name = "Orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Long orderId;
    private Date orderDate;
    private BigDecimal orderTotal;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Person person;
}
