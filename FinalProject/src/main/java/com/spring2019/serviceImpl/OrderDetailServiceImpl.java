package com.spring2019.serviceImpl;

import com.spring2019.entity.OrderDetail;
import com.spring2019.repository.OrderDetailRepository;
import com.spring2019.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository repository;

    @Override
    public Page<OrderDetail>  getAllOrderDetails(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<OrderDetail> getAllListOrderDetail() {
        return repository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
            return repository.findById(id);
    }

    @Override
    public void updateStatus(int id) {
//        OrderDetail entity = repository.findById(id);
//        if (entity != null) {
//            if (entity.getStatus() == 1) {
//                entity.setStatus(2);
//            }else if (entity.getStatus() == 2) {
//                entity.setStatus(3);
//            } else if (entity.getStatus() == 3) {
//                entity.setStatus(4);
//            }else{
//                entity.setStatus(1);
//            }
//            repository.save(entity);
    }

    @Override
    public int totalSoldProduct(Date startDate, Date endDate) {
       return  repository.CountSoldProduct(startDate, endDate);
    }
    @Override
    public int totaltotalPrice(Date startDate, Date endDate) {
        return  repository.CountTotalPrice(startDate, endDate);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }
}
