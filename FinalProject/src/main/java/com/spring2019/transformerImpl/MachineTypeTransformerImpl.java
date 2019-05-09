package com.spring2019.transformerImpl;

import com.spring2019.entity.MachineType;
import com.spring2019.model.MachineTypeModel;
import com.spring2019.transformer.MachineTypeTransformer;
import org.springframework.stereotype.Service;

@Service
public class MachineTypeTransformerImpl implements MachineTypeTransformer {


    @Override
    public MachineTypeModel entityToModel(MachineType entity) {
        MachineTypeModel model = new MachineTypeModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setActive(entity.isActive());
        return model;
    }

    @Override
    public MachineType modelToEntity(MachineTypeModel model) {
        MachineType entity = new MachineType();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setActive(model.isActive());
        return entity;


    }
}
