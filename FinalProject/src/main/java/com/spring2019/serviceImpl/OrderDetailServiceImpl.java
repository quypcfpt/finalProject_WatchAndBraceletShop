package com.spring2019.serviceImpl;

import com.spring2019.entity.OrderDetail;
import com.spring2019.repository.OrderDetailRepository;
import com.spring2019.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository repository;

    @Override
    public Page<OrderDetail>  getAllOrderDetails(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
