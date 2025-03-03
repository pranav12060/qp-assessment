package com.example.grocery_booking_api.DTO;

import java.util.List;

import java.util.List;

import java.util.List;

public class OrderResponseDTO {
    private Long orderId;
    private double totalPrice;
    private List<OrderItemDTO> orderItems;

    // Constructor
    public OrderResponseDTO(Long orderId, double totalPrice, List<OrderItemDTO> orderItems) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
