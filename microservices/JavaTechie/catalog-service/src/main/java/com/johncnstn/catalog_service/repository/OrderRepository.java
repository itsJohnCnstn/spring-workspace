package com.johncnstn.catalog_service.repository;

import com.johncnstn.catalog_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {



}
