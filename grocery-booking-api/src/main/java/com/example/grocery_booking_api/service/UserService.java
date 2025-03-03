package com.example.grocery_booking_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery_booking_api.DTO.OrderItemDTO;
import com.example.grocery_booking_api.DTO.OrderRequestDTO;
import com.example.grocery_booking_api.DTO.OrderResponseDTO;
import com.example.grocery_booking_api.model.GroceryItem;
import com.example.grocery_booking_api.model.Order;
import com.example.grocery_booking_api.model.OrderItem;
import com.example.grocery_booking_api.repository.GroceryRepository;
import com.example.grocery_booking_api.repository.OrderItemRepository;
import com.example.grocery_booking_api.repository.OrderRepository;

@Service
public class UserService {
    @Autowired
    private GroceryRepository groceryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    // Get available grocery items
    public List<GroceryItem> getAvailableItems() {
        return groceryRepository.findAll().stream()
                .filter(item -> item.getStock() > 0)
                .collect(Collectors.toList());
    }

    // Place an order with multiple grocery items    
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequest, String username) {
        Order order = new Order();
        order.setUsername(username);
        order = orderRepository.save(order);

        List<OrderItemDTO> orderItemResponses = new ArrayList<>();
        double totalPrice = 0.0;

        for (OrderItemDTO itemRequest : orderRequest.getOrderItems()) {
            GroceryItem groceryItem = groceryRepository
                .findById(itemRequest.getGroceryItemId())
                .orElseThrow(() -> new RuntimeException("Grocery item not found"));
            
            if (groceryItem.getStock() < itemRequest.getQuantity()) {
                throw new RuntimeException("Insufficient stock for item: " + groceryItem.getName());
            }

            groceryItem.setStock(groceryItem.getStock() - itemRequest.getQuantity());
            groceryRepository.save(groceryItem);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setGroceryItem(groceryItem);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPricePerUnit(groceryItem.getPrice());
            orderItemRepository.save(orderItem);

            totalPrice += groceryItem.getPrice() * itemRequest.getQuantity();
            
            orderItemResponses.add(new OrderItemDTO(groceryItem.getId(), itemRequest.getQuantity()));
        }

        order.setTotalPrice(totalPrice);
        orderRepository.save(order);

        return new OrderResponseDTO(order.getId(), totalPrice, orderItemResponses);
    }
}
