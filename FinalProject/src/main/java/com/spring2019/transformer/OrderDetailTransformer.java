package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.OrderDetail;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.OrderDetailModel;


public interface OrderDetailTransformer {
    public OrderDetailModel entityToModel(OrderDetail entity);

    public OrderDetail modelToEntity(OrderDetailModel model);
}
