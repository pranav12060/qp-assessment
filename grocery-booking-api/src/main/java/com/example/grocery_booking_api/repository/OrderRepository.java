package com.example.grocery_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grocery_booking_api.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
