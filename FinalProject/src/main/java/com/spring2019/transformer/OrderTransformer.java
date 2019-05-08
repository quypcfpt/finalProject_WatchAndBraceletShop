package com.spring2019.transformer;

import com.spring2019.entity.Orders;
import com.spring2019.model.OrderModel;


public interface OrderTransformer {
    public OrderModel entityToModel(Orders entity);

    public Orders modelToEntity(OrderModel model);
    public OrderModel entityToModel2(Orders entity);

    public Orders modelToEntity2(OrderModel model);
}
