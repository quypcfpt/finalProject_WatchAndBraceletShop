package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Role;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.RoleModel;


public interface RoleTransformer {
    public RoleModel entityToModel(Role entity);

    public Role modelToEntity(RoleModel model);
}
