package com.example.grocery_booking_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocery_booking_api.model.GroceryItem;
import com.example.grocery_booking_api.service.AdminService;

@RestController
@RequestMapping("/api/admin/items")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// Add grocery items
	@PostMapping
	public GroceryItem addItem(@RequestBody GroceryItem item) {
		return adminService.addGroceryItem(item);
	}
	
   // View existing grocery items 
	@GetMapping
	public List<GroceryItem> getAllItems() {
		return adminService.getAllItems();
	}

    //Remove grocery items
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id) {
		adminService.deleteGroceryItem(id);
	}

	//	Update grocery item details 
	@PutMapping("/")
	public GroceryItem updateItem( @RequestBody GroceryItem item) {
		return adminService.updateGroceryItem( item);
	}

	//	Manage inventory
	@PutMapping("/{id}")
	public GroceryItem updateStock(@PathVariable Long id, @RequestParam("stock") int stock) {
		return adminService.updateStock(id, stock);
	}

}
