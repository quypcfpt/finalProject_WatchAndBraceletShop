package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.User;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.UserModel;


public interface UserTransformer {
    public UserModel entityToModel(User entity);

    public User modelToEntity(UserModel model);
}
