package com.spring2019.transformerImpl;

import com.spring2019.entity.User;
import com.spring2019.model.CameraModel;
import com.spring2019.model.UserModel;
import com.spring2019.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserTransformerImpl implements UserTransformer {



    @Override
    public UserModel entityToModel(User entity) {
        UserModel model = new UserModel();

        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setPassword(entity.getPassword());
        model.setEmail(entity.getEmail());
        model.setFirstName(entity.getFirstName());
        model.setMiddleName(entity.getMiddleName());
        model.setLastName(entity.getLastName());
        model.setPhone(entity.getPhone());
        model.setRoleId(entity.getRoleId());
        return model;
    }

    @Override
    public User modelToEntity(UserModel model) {
        User entity = new User();

        entity.setId(model.getId());
        entity.setUsername(model.getUsername());
        entity.setPassword(model.getPassword());
        entity.setEmail(model.getEmail());
        entity.setFirstName(model.getFirstName());
        entity.setMiddleName(model.getMiddleName());
        entity.setLastName(model.getLastName());
        entity.setPhone(model.getPhone());
        entity.setRoleId(model.getRoleId());
        return entity;


    }
}
