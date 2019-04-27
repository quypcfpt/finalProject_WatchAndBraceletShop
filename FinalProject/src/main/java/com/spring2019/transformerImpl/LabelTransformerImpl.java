package com.spring2019.transformerImpl;

import com.spring2019.entity.Label;
import com.spring2019.model.CameraModel;
import com.spring2019.model.LabelModel;
import com.spring2019.transformer.LabelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LabelTransformerImpl implements LabelTransformer {


    @Override
    public LabelModel entityToModel(Label entity) {
        LabelModel model = new LabelModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setStatus(entity.getStatus());
        model.setActive(entity.isActive());
        return model;
    }

    @Override
    public Label modelToEntity(LabelModel model) {
        Label entity = new Label();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setStatus(model.getStatus());
        entity.setActive(model.isActive());
        return entity;


    }
}
