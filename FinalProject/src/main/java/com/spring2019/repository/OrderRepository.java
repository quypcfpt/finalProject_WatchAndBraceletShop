package com.spring2019.repository;

import com.spring2019.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    Orders findById(int id);
    List<Orders> findAllByStatus(int status);
}
