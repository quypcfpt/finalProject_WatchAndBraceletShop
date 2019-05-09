package com.spring2019.serviceImpl;

import com.spring2019.entity.Orders;
import com.spring2019.repository.OrderRepository;
import com.spring2019.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Override
    public Page<Orders>  getAllOrders(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Orders> getAllListOrders() {
        return repository.findAll();
    }

    @Override
    public List<Orders> getAllListOrdersByStatus(int status) {
        return repository.findAllByStatus(status);
    }


    @Override
    public Orders getOrderById(int id) {
        return repository.findById(id);
    }



    @Override
    public void updateStatus(int id) {
        Orders entity = repository.findById(id);
        if (entity != null) {
            if (entity.getStatus() == 1) {
                entity.setStatus(2);
            }else if (entity.getStatus() == 2) {
                entity.setStatus(3);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                entity.setPaidDateTime(dateFormat.format(date));
            } else if (entity.getStatus() == 3) {
                entity.setStatus(4);

            }else{
              return;
            }
            repository.save(entity);
        }
    }

    @Override
    public int totaltotalOrder(Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return  repository.countOrder(dateFormat.format(startDate), dateFormat.format(endDate));
    }

    @Override
    public int totaltotalOrderByStatus(Date startDate, Date endDate, int status) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return  repository.CountOrderStatus(dateFormat.format(startDate), dateFormat.format(endDate), status);
    }

    @Override
    public Orders save(Orders orders) {


        return repository.save(orders);
    }


}
