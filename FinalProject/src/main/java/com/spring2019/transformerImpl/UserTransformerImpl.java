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
        model.setStatus(entity.getStatus());
        model.setRoleId(entity.getRoleId());
        return model;
    }

    @Override
    public User modelToEntity(UserModel model) {
        User entity = new User();
        if(model.getId()!=null) {
            entity.setId(model.getId());
        }
        entity.setUsername(model.getUsername());
        entity.setPassword(model.getPassword());
        if(model.getEmail()!=null) {
            entity.setEmail(model.getEmail());
        }
        if(model.getFirstName()!=null) {
            entity.setFirstName(model.getFirstName());
        }
        if(model.getMiddleName()!=null) {
            entity.setMiddleName(model.getMiddleName());
        }
        if(model.getLastName()!=null) {
            entity.setLastName(model.getLastName());
        }
        if(model.getPhone()!=null) {
            entity.setPhone(model.getPhone());
        }
        if(model.getStatus()!=0) {
            entity.setStatus(model.getStatus());
        }
        if(model.getRoleId()!=0) {
            entity.setRoleId(model.getRoleId());
        }
        return entity;


    }
}
