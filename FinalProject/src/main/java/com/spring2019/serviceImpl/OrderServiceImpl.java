package com.spring2019.serviceImpl;

import com.spring2019.entity.Order;
import com.spring2019.repository.OrderRepository;
import com.spring2019.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;
    @Override
    public Page<Order>  getAllOrdersActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<Order>  getAllOrders(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
