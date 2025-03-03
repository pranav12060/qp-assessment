package com.example.grocery_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.grocery_booking_api.model.OrderItem;

import jakarta.transaction.Transactional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	@Modifying
	@Transactional
	@Query("DELETE FROM OrderItem oi WHERE oi.groceryItem.id = :groceryItemId")
	void deleteByGroceryItemId(@Param("groceryItemId") Long groceryItemId);
}
