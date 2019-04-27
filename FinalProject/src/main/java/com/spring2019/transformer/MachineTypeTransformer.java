package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.MachineType;
import com.spring2019.model.MachineTypeModel;
import com.spring2019.model.MachineTypeModel;


public interface MachineTypeTransformer {
    public MachineTypeModel entityToModel(MachineType entity);

    public MachineType modelToEntity(MachineTypeModel model);
}
