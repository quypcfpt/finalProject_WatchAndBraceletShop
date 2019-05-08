package com.spring2019.service;

import com.spring2019.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    public Page<Orders>  getAllOrders(Pageable pageable);
    public List<Orders> getAllListOrders();
    public Orders getOrderById(int id);
    void updateStatus(int id);
}
