package com.ThreeTree.dto;

import java.util.Map;

public record NewOrderRequest(Integer customerId,
                              Map<Integer, Integer> productsQuantities) {
}
