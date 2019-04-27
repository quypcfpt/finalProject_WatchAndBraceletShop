package com.spring2019.transformerImpl;

import com.spring2019.entity.OrderDetail;
import com.spring2019.model.CameraModel;
import com.spring2019.model.OrderDetailModel;
import com.spring2019.transformer.OrderDetailTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OrderDetailTransformerImpl implements OrderDetailTransformer {



    @Override
    public OrderDetailModel entityToModel(OrderDetail entity) {
        OrderDetailModel model = new OrderDetailModel();
        model.setId(entity.getId());
        model.setOrderId(entity.getOrderId());
        model.setProductId(entity.getProductId());
        model.setPrice(entity.getPrice());
        model.setQuantity(entity.getQuantity());
        model.setTotalPrice(entity.getTotalPrice());
        return model;
    }

    @Override
    public OrderDetail modelToEntity(OrderDetailModel model) {
        OrderDetail entity = new OrderDetail();
        entity.setId(model.getId());
        entity.setOrderId(model.getOrderId());
        entity.setProductId(model.getProductId());
        entity.setPrice(model.getPrice());
        entity.setQuantity(model.getQuantity());
        entity.setTotalPrice(model.getTotalPrice());
        return entity;

    }
}
