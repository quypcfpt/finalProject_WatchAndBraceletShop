package com.spring2019.transformerImpl;

import com.spring2019.entity.Role;
import com.spring2019.model.RoleModel;
import com.spring2019.transformer.RoleTransformer;
import org.springframework.stereotype.Service;

@Service
public class RoleTransformerImpl implements RoleTransformer {

    @Override
    public RoleModel entityToModel(Role entity) {
        RoleModel model = new RoleModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    @Override
    public Role modelToEntity(RoleModel model) {
        Role entity = new Role();

        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;


    }
}
