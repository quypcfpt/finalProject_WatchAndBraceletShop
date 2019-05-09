package com.spring2019.transformerImpl;

import com.spring2019.entity.GlassType;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.transformer.GlassTypeTransformer;
import org.springframework.stereotype.Service;

@Service
public class GlassTypeTransformerImpl implements GlassTypeTransformer {
    @Override
    public GlassTypeModel entityToModel(GlassType entity) {
        GlassTypeModel model = new GlassTypeModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setActive(entity.isActive());
        model.setStatus(entity.getStatus());
        return model;
    }

    @Override
    public GlassType modelToEntity(GlassTypeModel model) {
        GlassType entity = new GlassType();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setActive(model.isActive());
        entity.setStatus(model.getStatus());
        return entity;
    }
}
