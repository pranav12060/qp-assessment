package com.example.grocery_booking_api.DTO;

public class OrderItemDTO {
    private Long groceryItemId;
    private int quantity;

    // Constructor
    public OrderItemDTO(Long groceryItemId, int quantity) {
        this.groceryItemId = groceryItemId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getGroceryItemId() {
        return groceryItemId;
    }

    public void setGroceryItemId(Long groceryItemId) {
        this.groceryItemId = groceryItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
