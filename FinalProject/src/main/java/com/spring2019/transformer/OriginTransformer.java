package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Origin;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.OriginModel;


public interface OriginTransformer {
    public OriginModel entityToModel(Origin entity);

    public Origin modelToEntity(OriginModel model);
}
