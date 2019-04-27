package com.spring2019.transformerImpl;

import com.spring2019.entity.Role;
import com.spring2019.model.CameraModel;
import com.spring2019.model.RoleModel;
import com.spring2019.transformer.RoleTransformer;
import javafx.scene.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

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
