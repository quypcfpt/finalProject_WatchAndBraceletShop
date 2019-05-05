package com.spring2019.transformerImpl;

import com.spring2019.entity.OrderDetail;
import com.spring2019.model.CameraModel;
import com.spring2019.model.OrderDetailModel;
import com.spring2019.transformer.OrderDetailTransformer;
import com.spring2019.transformer.OrderTransformer;
import com.spring2019.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OrderDetailTransformerImpl implements OrderDetailTransformer {
    @Autowired
    ProductTransformer transformer;
    @Autowired
    OrderTransformer ortransformer;
    @Override
    public OrderDetailModel entityToModel(OrderDetail entity) {
        OrderDetailModel model = new OrderDetailModel();
        model.setId(entity.getId());
        model.setOrderModel(ortransformer.entityToModel(entity.getOrderById()));
        model.setProduct(transformer.entityToModel(entity.getProductById()));
        model.setPrice(entity.getPrice());
        model.setQuantity(entity.getQuantity());
        model.setTotalPrice(entity.getPrice()*entity.getQuantity());
        return model;
    }

    @Override
    public OrderDetail modelToEntity(OrderDetailModel model) {
        OrderDetail entity = new OrderDetail();
        entity.setId(model.getId());
        entity.setOrderById(ortransformer.modelToEntity(model.getOrderModel()));
        entity.setProductById(transformer.modelToEntity(model.getProduct()));
        entity.setPrice(model.getPrice());
        entity.setQuantity(model.getQuantity());
        return entity;

    }
}
