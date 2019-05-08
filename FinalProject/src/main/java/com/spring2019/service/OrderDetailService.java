package com.spring2019.service;

import com.spring2019.entity.OrderDetail;
import com.spring2019.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface OrderDetailService {
    public Page<OrderDetail>  getAllOrderDetails(Pageable pageable);
    public List<OrderDetail> getAllListOrderDetail();
    public OrderDetail getOrderDetailById(int id);
    void updateStatus(int id);
    int totalSoldProduct(Date startDate, Date endDate);
    int totaltotalPrice(Date startDate, Date endDate);
    OrderDetail save(OrderDetail orderDetail);
}
