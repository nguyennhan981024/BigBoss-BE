package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT od FROM Orders od")
    List<Orders> getAllOrder();
}
