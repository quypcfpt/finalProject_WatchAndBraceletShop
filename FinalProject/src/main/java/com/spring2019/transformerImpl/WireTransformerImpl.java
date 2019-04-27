package com.spring2019.transformerImpl;

import com.spring2019.entity.WireType;
import com.spring2019.model.CameraModel;
import com.spring2019.model.WireTypeModel;
import com.spring2019.transformer.WireTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class WireTransformerImpl implements WireTransformer {



    @Override
    public WireTypeModel entityToModel(WireType entity) {
        WireTypeModel model = new WireTypeModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setActive(entity.isActive());
        return model;
    }

    @Override
    public WireType modelToEntity(WireTypeModel model) {
        WireType entity = new WireType();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setActive(model.isActive());
        return entity;


    }
}
