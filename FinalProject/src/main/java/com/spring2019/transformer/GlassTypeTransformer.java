package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.model.GlassTypeModel;
import org.springframework.stereotype.Service;


public interface GlassTypeTransformer {
    public GlassTypeModel entityToModel(GlassType entity);

    public GlassType modelToEntity(GlassTypeModel model);
}
