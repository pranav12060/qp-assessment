package com.example.grocery_booking_api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grocery_booking_api.model.GroceryItem;

@Repository
public interface GroceryRepository extends JpaRepository<GroceryItem, Long> {

	Optional<GroceryItem> findByName(String name);
}