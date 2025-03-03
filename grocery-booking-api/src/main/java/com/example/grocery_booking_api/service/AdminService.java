package com.example.grocery_booking_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery_booking_api.model.GroceryItem;
import com.example.grocery_booking_api.repository.GroceryRepository;
import com.example.grocery_booking_api.repository.OrderItemRepository;

@Service
public class AdminService {
	
	@Autowired
    private GroceryRepository groceryRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryRepository.save(item);
    }

    // View available grocery items
    public List<GroceryItem> getAllItems() {
        return groceryRepository.findAll();
    }

    // delete grocery item
    public void deleteGroceryItem(Long id) {
    	System.out.println(" id i "+id);
    	orderItemRepository.deleteByGroceryItemId(id);
        groceryRepository.deleteById(id);
    }

    // update grocery items
    public GroceryItem updateGroceryItem( GroceryItem updatedItem) {
        return groceryRepository.findByName(updatedItem.getName())
                .map(item -> {
                    item.setName(updatedItem.getName());
                    item.setPrice(updatedItem.getPrice());
                    item.setStock(updatedItem.getStock());
                    return groceryRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }
    
    
    //manage inventory
    public GroceryItem updateStock(Long id, int stock) {
        GroceryItem item = groceryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setStock(stock);
        return groceryRepository.save(item);
    }

}
