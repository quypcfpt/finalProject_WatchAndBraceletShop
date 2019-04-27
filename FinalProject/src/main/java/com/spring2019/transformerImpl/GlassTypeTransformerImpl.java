package com.spring2019.transformerImpl;

import com.spring2019.entity.GlassType;
import com.spring2019.model.CameraModel;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.transformer.GlassTypeTransformer;
import javafx.scene.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class GlassTypeTransformerImpl implements GlassTypeTransformer {
    @Override
    public GlassTypeModel entityToModel(GlassType entity) {
        GlassTypeModel model = new GlassTypeModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setActive(entity.isActive());
        return model;
    }

    @Override
    public GlassType modelToEntity(GlassTypeModel model) {
        GlassType entity = new GlassType();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setActive(model.isActive());
        return entity;
    }
}
