package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.WireType;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.WireTypeModel;


public interface WireTypeTransformer {
    public WireTypeModel entityToModel(WireType entity);

    public WireType modelToEntity(WireTypeModel model);
}
