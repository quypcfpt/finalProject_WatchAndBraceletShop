package com.spring2019.transformerImpl;

import com.spring2019.entity.Orders;
import com.spring2019.model.OrderModel;
import com.spring2019.transformer.OrderTransformer;
import org.springframework.stereotype.Service;

@Service
public class OrderTransformerImpl implements OrderTransformer {

    @Override
    public OrderModel entityToModel(Orders entity) {
        OrderModel model = new OrderModel();

        model.setId(entity.getId());
        model.setCustimerId(entity.getCustimerId());
        model.setCustomerName(entity.getCustomerName());
        model.setAddress(entity.getAddress());
        model.setEmail(entity.getEmail());
        model.setPhone(entity.getPhone());
        model.setNote(entity.getNote());
        model.setCreateDateTime(entity.getCreateDateTime());
        model.setPaidDateTime(entity.getPaidDateTime());
        model.setStatus(entity.getStatus());
        return model;
    }

    @Override
    public Orders modelToEntity(OrderModel model) {
        Orders entity = new Orders();

        entity.setId(model.getId());
        entity.setCustimerId(model.getCustimerId());
        entity.setCustomerName(model.getCustomerName());
        entity.setAddress(model.getAddress());
        entity.setEmail(model.getEmail());
        entity.setPhone(model.getPhone());
        entity.setNote(model.getNote());
        entity.setCreateDateTime(model.getCreateDateTime());
        entity.setPaidDateTime(model.getPaidDateTime());
        entity.setStatus(model.getStatus());
        return entity;


    }
}
