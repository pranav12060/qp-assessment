package com.example.grocery_booking_api.DTO;

import java.util.List;

public class OrderRequestDTO {
    private List<OrderItemDTO> orderItems;

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}

