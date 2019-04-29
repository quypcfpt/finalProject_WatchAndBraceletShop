package com.spring2019.repository;

import com.spring2019.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Page<Order> findAllByActive(boolean isActive, Pageable pageable);
}
