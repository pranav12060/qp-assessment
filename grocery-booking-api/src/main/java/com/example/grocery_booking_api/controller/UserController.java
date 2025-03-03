package com.example.grocery_booking_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocery_booking_api.DTO.OrderRequestDTO;
import com.example.grocery_booking_api.DTO.OrderResponseDTO;
import com.example.grocery_booking_api.model.GroceryItem;
import com.example.grocery_booking_api.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
    private UserService userService;

    // View available grocery items
    @GetMapping("/items")
    public List<GroceryItem> getAvailableItems() {
        return userService.getAvailableItems();
    }

    //Book multiple grocery items in a single order
    @PostMapping("/order")
    public OrderResponseDTO placeOrder(@RequestBody OrderRequestDTO orderRequest, @RequestParam  String username) {
        return userService.placeOrder(orderRequest, username);
    }
}

