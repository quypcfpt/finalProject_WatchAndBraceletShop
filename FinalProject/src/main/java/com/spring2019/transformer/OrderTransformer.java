package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Order;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.OrderModel;


public interface OrderTransformer {
    public OrderModel entityToModel(Order entity);

    public Order modelToEntity(OrderModel model);
}
