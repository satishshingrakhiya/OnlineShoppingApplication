package com.shoping.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDTO {
    private long id;
    private String skuCode;
    private long price;
    private int quantity;
}
