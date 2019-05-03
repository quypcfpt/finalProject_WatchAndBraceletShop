package com.spring2019.transformerImpl;

import com.spring2019.entity.Origin;
import com.spring2019.model.CameraModel;
import com.spring2019.model.OriginModel;
import com.spring2019.transformer.OriginTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OriginTransformerImpl implements OriginTransformer {


    @Override
    public OriginModel entityToModel(Origin entity) {
        OriginModel model = new OriginModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setStatus(entity.getStatus());
        model.setActive(entity.isActive());
        return model;
    }

    @Override
    public Origin modelToEntity(OriginModel model) {
        Origin entity = new Origin();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setStatus(model.getStatus());
        entity.setActive(model.isActive());
        return entity;


    }
}
