package com.spring2019.service;

import com.spring2019.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    public Page<Order>  getAllOrders(Pageable pageable);
}
