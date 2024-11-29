package com.coding.dojo.Ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import com.coding.dojo.Ecommerce.entities.Payment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {

    private BigDecimal totalPrice;
    private List<OrderItemRequest> items;
    private Payment paymentInfo;
}