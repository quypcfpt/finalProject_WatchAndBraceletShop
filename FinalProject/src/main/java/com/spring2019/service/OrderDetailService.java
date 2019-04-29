package com.spring2019.service;

import com.spring2019.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderDetailService {
    public Page<OrderDetail> getAllOrderDetailsActive(Pageable pageable);
    public Page<OrderDetail>  getAllOrderDetails(Pageable pageable);
}
