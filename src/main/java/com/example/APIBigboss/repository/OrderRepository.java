package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Boolean existsByName(String name);

    @Query("SELECT od FROM Order od WHERE od.id = ?1")
    Optional<Order> findOrderById(Integer id);
    @Query("SELECT od FROM Order od")
    List<Order> getAllOrder();
    @Query("SELECT od FROM Order od WHERE od.code_order = ?1")
    Order findByOrderCode(String code);
}
